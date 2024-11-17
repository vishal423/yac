/*
 * YAC -- Companion to build opinionated Java and SPA applications.
 * Copyright (C) 2024 Vishal Mahajan
 *
 * This package is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; version 2 of the
 * license as found in the file LICENSE.
 *
 * This package is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package tech.yac.cli;

import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.nodes.Tag;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Optional;
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import tech.yac.core.domain.Application;
import tech.yac.core.module.YacModule;
import tech.yac.core.module.YacModuleFactory;
import tech.yac.git.domain.GitVersionControl;
import tech.yac.maven.domain.MavenBuildTool;
import tech.yac.spring.domain.SpringYacApplication;

@Component
@Command(name = "yac")
public class YacCli implements Callable<Integer> {

    @Option(names = "-d", description = "Dry Run code generation")
    boolean dryRun;

    @Parameters(index = "0", paramLabel = "<file>", description = "Yac application configuration file path")
    private File appConfiguration;

    private YacModuleFactory moduleFactory;

    YacCli(RootYacModuleFactory moduleFactory) {
        this.moduleFactory = moduleFactory;
    }

    public Integer call() throws Exception {
        Constructor constructor = new Constructor(Application.class, new LoaderOptions());
        constructor.addTypeDescription(new TypeDescription(MavenBuildTool.class, new Tag("!maven")));
        constructor.addTypeDescription(new TypeDescription(SpringYacApplication.class, new Tag("!spring")));
        constructor.addTypeDescription(new TypeDescription(GitVersionControl.class, new Tag("!git")));

        Application application = null;
        Yaml yaml = new Yaml(constructor);
        try (InputStream stream = new FileInputStream(appConfiguration)) {
            application = yaml.load(stream);

        } catch (Exception e) {
            System.err.println("Could not parse Yac application configuration file");
            System.err.println(e);
            return 1;
        }

        String applicationLocationLog = System.getProperty("user.dir");
        System.out.println("Project to generate at -> " + applicationLocationLog);
        application.setLocation(applicationLocationLog);

        Optional<YacModule> rootModuleOptional = moduleFactory.getModuleGraph(application);
        if(rootModuleOptional.isPresent()) {
            YacModule rootModule = rootModuleOptional.get();
            rootModule.configureOptions(application);

            if(dryRun) {
                rootModule.dryRun(application);
            } else {
                rootModule.run(application);
            }
        }

        return 0;
    }
}


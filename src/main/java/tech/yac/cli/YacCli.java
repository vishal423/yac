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
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import tech.yac.core.domain.Application;
import tech.yac.core.module.YacModule;
import tech.yac.core.module.YacModuleFactory;
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

        YacModule rootModule = moduleFactory.getModuleGraph(application);
        rootModule.configureOptions(application);

        if(dryRun) {
            rootModule.dryRun(application);
        } else {
            rootModule.run(application);
        }

        return 0;
    }
}


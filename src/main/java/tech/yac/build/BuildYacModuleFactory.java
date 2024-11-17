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
package tech.yac.build;

import org.springframework.stereotype.Component;

import java.util.Optional;

import tech.yac.core.domain.Application;
import tech.yac.core.exception.YacException;
import tech.yac.core.module.YacModule;
import tech.yac.core.module.YacModuleFactory;
import tech.yac.core.service.YacFileServiceFactory;
import tech.yac.core.service.YacTemplateServiceFactory;
import tech.yac.maven.MavenYacModule;

@Component
public class BuildYacModuleFactory implements YacModuleFactory {

    private YacTemplateServiceFactory templateServiceFactory;
    private YacFileServiceFactory fileServiceFactory;

    public BuildYacModuleFactory(YacTemplateServiceFactory templateServiceFactory, YacFileServiceFactory fileServiceFactory) {
        this.templateServiceFactory = templateServiceFactory;
        this.fileServiceFactory = fileServiceFactory;
    }

    public Optional<YacModule> getModuleGraph(Application application) {
        return Optional.of(getBuildModule(application));
    }

    public YacModule getBuildModule(Application application) {

        if(application.getApplication().getBuildTool() == null) {
            throw new YacException("Application build tool configuration missing");
        }

        switch(application.getApplication().getBuildTool().getType()) {
            case MAVEN:
                return new MavenYacModule(templateServiceFactory, fileServiceFactory);
            default:
                throw new YacException("not supported");
        }
    }
}

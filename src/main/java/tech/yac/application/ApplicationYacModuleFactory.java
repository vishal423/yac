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
package tech.yac.application;

import org.springframework.stereotype.Component;

import tech.yac.build.BuildYacModuleFactory;
import tech.yac.core.domain.Application;
import tech.yac.core.exception.YacException;
import tech.yac.core.module.YacModule;
import tech.yac.core.module.YacModuleFactory;
import tech.yac.core.service.YacFileServiceFactory;
import tech.yac.core.service.YacTemplateServiceFactory;
import tech.yac.spring.SpringYacModule;

@Component
public class ApplicationYacModuleFactory implements YacModuleFactory {

    private YacTemplateServiceFactory templateServiceFactory;
    private YacFileServiceFactory fileServiceFactory;
    private BuildYacModuleFactory buildModuleFactory;

    public ApplicationYacModuleFactory(
        YacTemplateServiceFactory templateServiceFactory, YacFileServiceFactory fileServiceFactory,
        BuildYacModuleFactory buildModuleFactory) {
        this.templateServiceFactory = templateServiceFactory;
        this.fileServiceFactory = fileServiceFactory;
        this.buildModuleFactory = buildModuleFactory;
    }

    public YacModule getModuleGraph(Application application) {
        YacModule applicationModule = getApplicationModule(application);

        YacModule buildModule = buildModuleFactory.getModuleGraph(application);
        applicationModule.composeWith(buildModule);

        return applicationModule;
    }

    private YacModule getApplicationModule(Application application) {

        if(application.getApplication() == null) {
            throw new YacException("Application configuration missing");
        }

        switch(application.getApplication().getType()) {
            case BACKEND:
                switch(application.getApplication().getFrameworkType()) {
                    case SPRING:
                        return new SpringYacModule(templateServiceFactory, fileServiceFactory);
                    default:
                        throw new YacException("not supported");
                }
            default:
                throw new YacException("not supported");
        }
    }
}


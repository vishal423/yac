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
package tech.yac.maven;


import tech.yac.core.domain.Application;
import tech.yac.core.domain.YacTemplateConfig;
import tech.yac.core.module.CoreYacModule;
import tech.yac.core.service.YacFileServiceFactory;
import tech.yac.core.service.YacTemplateServiceFactory;

/**
 * Maven Codegen
 *
 * @author Vishal Mahajan
 */
public class MavenYacModule extends CoreYacModule {

    public MavenYacModule(YacTemplateServiceFactory templateServiceFactory,
        YacFileServiceFactory fileServiceFactory) {
        super(templateServiceFactory, fileServiceFactory);
    }

    @Override
    protected void configureModuleOptions(Application application) {
      // specify default options that are not explicitly configured
    }

    @Override
    protected YacTemplateConfig configureTemplates(Application application) {
        System.out.println("Configure template files ...");
        return new MavenYacTemplateConfig(application);
    }
}

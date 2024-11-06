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

import tech.yac.application.ApplicationYacModuleFactory;
import tech.yac.core.domain.Application;
import tech.yac.core.module.RootYacModule;
import tech.yac.core.module.YacModule;
import tech.yac.core.module.YacModuleFactory;

/**
 * YAC Module Factory
*
* @author Vishal Mahajan
*/
@Component
public class RootYacModuleFactory implements YacModuleFactory {
    private ApplicationYacModuleFactory applicationModuleFactory;

    public RootYacModuleFactory(ApplicationYacModuleFactory applicationModuleFactory) {
        this.applicationModuleFactory = applicationModuleFactory;
    }

    public YacModule getModuleGraph(Application application) {

        YacModule rootModule = getRootModule(application);

        YacModule applicationModule = applicationModuleFactory.getModuleGraph(application);
        rootModule.composeWith(applicationModule);

        return rootModule;
    }

    private YacModule getRootModule(Application application) {
        return new RootYacModule();
    }
}


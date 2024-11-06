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
package tech.yac.core.module;

import java.util.LinkedList;
import java.util.List;

import tech.yac.core.domain.Application;
import tech.yac.core.exception.YacException;

public class RootYacModule implements YacModule {

    private List<YacModule> modules = new LinkedList<>();

    @Override
    public YacModule composeWith(YacModule module) {
        if(modules.isEmpty()) {
            modules.add(module);
        } else {
            throw new YacException("Root module cannot be composed with more than one application module");
        }
        return this;
    }

    @Override
    public void configureOptions(Application application) {
        for(YacModule module: modules) {
            module.configureOptions(application);
        }
    }

    @Override
    public void dryRun(Application application) {
        for(YacModule module: modules) {
            module.dryRun(application);
        }
    }

    @Override
    public void run(Application application) {

        for(YacModule module: modules) {
            module.run(application);
        }
    }
}

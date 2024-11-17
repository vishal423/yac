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
package tech.yac.scm;

import org.springframework.stereotype.Component;

import java.util.Optional;

import tech.yac.core.domain.Application;
import tech.yac.core.exception.YacException;
import tech.yac.core.module.YacModule;
import tech.yac.core.module.YacModuleFactory;
import tech.yac.core.service.YacFileServiceFactory;
import tech.yac.core.service.YacTemplateServiceFactory;
import tech.yac.git.GitYacModule;

@Component
public class ScmYacModuleFactory implements YacModuleFactory {

    private YacTemplateServiceFactory templateServiceFactory;
    private YacFileServiceFactory fileServiceFactory;

    public ScmYacModuleFactory(YacTemplateServiceFactory templateServiceFactory, YacFileServiceFactory fileServiceFactory) {
        this.templateServiceFactory = templateServiceFactory;
        this.fileServiceFactory = fileServiceFactory;
    }

    @Override
    public Optional<YacModule> getModuleGraph(Application application) {
        return getScmModule(application);
    }

    public Optional<YacModule> getScmModule(Application application) {

        if(application.getScm() == null) {
            return Optional.empty();
        }

        switch(application.getScm().getType()) {
            case GIT:
                return Optional.of(new GitYacModule(templateServiceFactory, fileServiceFactory));
            default:
                throw new YacException("not supported");
        }
    }
}


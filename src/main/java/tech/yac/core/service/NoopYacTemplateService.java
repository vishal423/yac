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
package tech.yac.core.service;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Paths;

import tech.yac.core.domain.YacTemplateModel;
import tech.yac.core.domain.file.YacFileContent;
import tech.yac.core.exception.YacTemplateException;

public class NoopYacTemplateService implements YacTemplateService {

    @Override
    public YacFileContent process(YacTemplateModel templateModel) throws YacTemplateException {
        try {
            return new YacFileContent(templateModel.getDestination(),
                getTemplatePath(templateModel).getContentAsByteArray());
        } catch(Exception exception) {
            throw new YacTemplateException(exception);
        }
    }

    private ClassPathResource getTemplatePath(YacTemplateModel templateModel) throws IOException {
        if(templateModel.getSource().getPath().isPresent()) {
        return new ClassPathResource(
            Paths.get("templates",
                templateModel.getTemplateRoot(),
                templateModel.getSource().getPath().get(),
                templateModel.getSource().getName()).toString());
        }
        return new ClassPathResource(
            Paths.get("templates",
                templateModel.getTemplateRoot(),
                templateModel.getSource().getName()).toString());
    }
}


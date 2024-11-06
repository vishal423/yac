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

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Optional;

import tech.yac.core.domain.YacTemplateConfig;

public class YacTemplateServiceFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public YacTemplateService getInstance(Optional<String> templateExtension) {
        if(templateExtension.isPresent()) {
            if(YacTemplateConfig.DEFAULT_TEMPLATE_EXTENSION.equalsIgnoreCase(templateExtension.get())) {
                return applicationContext.getBean(FreeMarkerYacTemplateService.class.getSimpleName(), YacTemplateService.class);
            }
        }
        return applicationContext.getBean(NoopYacTemplateService.class.getSimpleName(), YacTemplateService.class);
    }
}

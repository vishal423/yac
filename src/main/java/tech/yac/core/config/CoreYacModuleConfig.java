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
package tech.yac.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import tech.yac.core.service.FreeMarkerYacTemplateService;
import tech.yac.core.service.LocalYacFileService;
import tech.yac.core.service.LogYacFileService;
import tech.yac.core.service.NoopYacTemplateService;
import tech.yac.core.service.YacFileService;
import tech.yac.core.service.YacFileServiceFactory;
import tech.yac.core.service.YacTemplateService;
import tech.yac.core.service.YacTemplateServiceFactory;

@Configuration
class CoreYacModuleConfig {

    @Bean("FreeMarkerYacTemplateService")
    @Primary
    YacTemplateService templateService(freemarker.template.Configuration configuration) {
        return new FreeMarkerYacTemplateService(configuration);
    }

    @Bean("NoopYacTemplateService")
    YacTemplateService noopTemplateService() {
        return new NoopYacTemplateService();
    }

    @Bean
    YacTemplateServiceFactory templateFactory() {
        return new YacTemplateServiceFactory();
    }

    @Bean("LocalYacFileService")
    @Primary
    YacFileService fileService() {
        return new LocalYacFileService();
    }

    @Bean("LogYacFileService")
    YacFileService logFileService() {
        return new LogYacFileService();
    }

    @Bean
    YacFileServiceFactory fileServiceFactory() {
        return new YacFileServiceFactory();
    }
}

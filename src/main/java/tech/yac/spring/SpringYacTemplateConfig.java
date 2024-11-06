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
package tech.yac.spring;

import java.util.LinkedHashMap;
import java.util.Map;

import tech.yac.core.domain.Application;
import tech.yac.core.domain.YacTemplateConfig;
import tech.yac.core.domain.file.YacFile;
import tech.yac.spring.domain.SpringYacApplication;

public class SpringYacTemplateConfig implements YacTemplateConfig {

    private Map<YacFile, YacFile> templates = new LinkedHashMap<>();

    public SpringYacTemplateConfig(Application application) {
        configureTemplates(application);
    }

    private void configureTemplates(Application application) {
        SpringYacApplication springApplication = (SpringYacApplication) application.getApplication();

        addNestedTemplateFile("src/main/java/package", "Application.java",
            "src/main/java/" + springApplication.getRootPackagePath(), application.getName() + "Application.java");
        addNestedTemplateFile("src/main/resources", "application.yaml");
    }

    @Override
    public String getTemplateRoot() {
        return "spring";
    }

    @Override
    public Map<YacFile, YacFile> getTemplates() {
        return templates;
    }
}

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
package tech.yac.core.domain;

import static tech.yac.core.domain.file.YacFile.file;
import static tech.yac.core.domain.file.YacTemplateFile.file;

import java.util.Map;

import tech.yac.core.domain.file.YacFile;

public interface YacTemplateConfig {

    String DEFAULT_TEMPLATE_EXTENSION = ".ftl";
    String[] SUPPORTED_TEMPLATE_EXTENSIONS = new String[] {".ftl"};

    String getTemplateRoot();

    Map<YacFile, YacFile> getTemplates();

    default void addTemplateFile(String name) {
        addTemplateFile(name, DEFAULT_TEMPLATE_EXTENSION);
    }

    default void addNestedTemplateFile(String path, String name) {
        addTemplateFile(path, name, DEFAULT_TEMPLATE_EXTENSION);
    }

    default void addNestedTemplateFile(String srcPath, String srcName, String destPath, String destName) {
        addTemplateFile(srcPath, srcName, destPath, destName, DEFAULT_TEMPLATE_EXTENSION);
    }

    default void addTemplateFile(String srcPath, String srcName, String destPath, String destName, String templateExtension) {
        getTemplates().put(file(srcName, templateExtension).parent(srcPath), file(destName).parent(destPath));
    }

    default void addTemplateFile(String path, String name, String templateExtension) {
        getTemplates().put(file(name, templateExtension).parent(path), file(name).parent(path));
    }

    default void addTemplateFile(String name, String templateExtension) {
        getTemplates().put(file(name, templateExtension), file(name));
    }

    default void addFile(String name) {
        getTemplates().put(file(name), file(name));
    }

    default void addExecutableFile(String name) {
        getTemplates().put(file(name), file(name).executable());
    }
}

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
package tech.yac.core.domain.file;

public class YacTemplateFile extends YacFile {
    private String templateExtension;

    private YacTemplateFile(String path, String templateExtension) {
        super(path);
        this.templateExtension = templateExtension;
    }

    public static YacTemplateFile file(String filePath, String templateExtension) {
        return new YacTemplateFile(filePath, templateExtension);
    }

    public String getTemplateExtension() {
        return templateExtension;
    }
}

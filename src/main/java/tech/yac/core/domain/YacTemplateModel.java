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

import java.util.Optional;

import tech.yac.core.domain.file.YacFile;
import tech.yac.core.domain.file.YacTemplateFile;

public class YacTemplateModel {

    private String templateRoot;
    private YacFile source;
    private YacFile destination;
    private Object model;

    public YacTemplateModel(String templateRoot, YacFile source, YacFile destination, Object model) {
        this.templateRoot = templateRoot;
        this.source = source;
        this.destination = destination;
        this.model = model;
    }

    public String getTemplateRoot() {
        return templateRoot;
    }

    public YacFile getSource() {
        return source;
    }

    public YacFile getDestination() {
        return destination;
    }

    public Optional<String> getTemplateExtension() {
        if(source instanceof YacTemplateFile) {
            return Optional.of(((YacTemplateFile) source).getTemplateExtension());
        }
        return Optional.empty();
    }

    public Object getModel() {
        return model;
    }
}

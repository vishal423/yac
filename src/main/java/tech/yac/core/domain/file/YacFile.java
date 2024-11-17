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

import java.util.Optional;

public class YacFile {
    private Optional<String> path = Optional.empty();
    private String name;
    private YacFilePermission permission;
    private boolean directory;

    YacFile(String name) {
        this.name = name;
        this.permission = YacFilePermission.standard();
    }

    public static YacFile file(String name) {
        return new YacFile(name);
    }

    public YacFile parent(String path) {
        this.path = Optional.of(path);
        return this;
    }

    public YacFile executable() {
        this.permission.setExecutable();
        return this;
    }

    public YacFile directory() {
        this.directory = true;
        return this;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getPath() {
        return path;
    }

    public boolean isExecutable() {
        return permission.isExecute();
    }

    public boolean isDirectory() {
        return this.directory;
    }
}


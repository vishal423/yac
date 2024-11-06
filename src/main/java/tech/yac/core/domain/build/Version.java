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
package tech.yac.core.domain.build;

public class Version {
    private int major;
    private int minor;
    private Integer patch;

    public Version(int major, int minor) {
        this.major = major;
        this.minor = minor;
    }

    public Version(int major, int minor, int patch) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
    }

    @Override
    public String toString() {
        return new StringBuilder()
            .append(major).append(".")
            .append(minor)
            .append(getPatchString()).toString();
    }

    private String getPatchString() {
        return patch != null ? "." +  patch.toString(): "";
    }
}


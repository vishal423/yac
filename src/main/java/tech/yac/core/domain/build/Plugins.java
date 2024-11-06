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

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Plugins {
    private Set<Plugin> plugins = new TreeSet<>(
            Comparator.comparing(Plugin::getGroup));

    public Set<Plugin> getPlugins() {
        return plugins;
    }

    public void addPlugin(Plugin plugin) {
        plugins.add(plugin);
    }
}

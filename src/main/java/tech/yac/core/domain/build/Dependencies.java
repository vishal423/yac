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
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Dependencies {
    private Set<Dependency> dependencies = new TreeSet<>(
            Comparator.comparing(Dependency::getGroup));
    private Set<Dependency> testDependencies = new TreeSet<>(
            Comparator.comparing(Dependency::getGroup));
    private Map<String, DependencyGroup> groupedDependencies = new LinkedHashMap<>();

    public Set<Dependency> getDependencies() {
        return dependencies;
    }

    public Set<Dependency> getTestDependencies() {
        return testDependencies;
    }

    public Map<String, DependencyGroup> getGroupedDependencies() {
        return groupedDependencies;
    }

    public void addDependency(Dependency dependency) {
        if(DependencyScope.TEST.equals(dependency.getScope())) {
            testDependencies.add(dependency);
        }

        dependencies.add(dependency);
    }

    public void addGroupedDependency(String group, Dependency dependency) {
        groupedDependencies.compute(group, (key, val) -> {
            if(val == null) {
                return new DependencyGroup();
            } else {
                val.addDependency(dependency);
                return val;
            }
        });
    }
}


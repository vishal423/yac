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
package tech.yac.maven.domain;

import java.util.Optional;
import java.util.Set;

import tech.yac.core.domain.build.BuildTool;
import tech.yac.core.domain.build.BuildToolType;
import tech.yac.core.domain.build.Dependencies;
import tech.yac.core.domain.build.Dependency;
import tech.yac.core.domain.build.Plugin;
import tech.yac.core.domain.build.Plugins;

public class MavenBuildTool implements BuildTool {
    private static final String MAVEN_VERSION = "3.9.9";
    private static final String WRAPPER_VERSION = "3.3.2";

    private String version;
    private String wrapperVersion;
    private boolean wrapper;
    private Optional<Dependency> parent;
    private Dependencies dependencies;
    private Plugins plugins;

    public MavenBuildTool() {
        this.version = MAVEN_VERSION;
        this.wrapperVersion = WRAPPER_VERSION;
        this.wrapper = true;
        this.parent = Optional.empty();
        this.dependencies = new Dependencies();
        this.plugins = new Plugins();
    }

    @Override
    public BuildToolType getType() {
        return BuildToolType.MAVEN;
    }

    @Override
    public void addDependency(Dependency dependency) {
        dependencies.addDependency(dependency);
    }

    public void addPlugin(Plugin plugin) {
        plugins.addPlugin(plugin);
    }

    public String getVersion() {
        return version;
    }

    public String getWrapperVersion() {
        return wrapperVersion;
    }

    public void setWrapper(boolean wrapper) {
        this.wrapper = wrapper;
    }

    public boolean isWrapper() {
        return wrapper;
    }

    public void setParent(Dependency parent) {
        this.parent = Optional.of(parent);
    }

    public Dependency getParent() {
        return parent.orElse(null);
    }

    public boolean containsParent() {
        return parent.isPresent();
    }

    public Set<Dependency> getDependencies() {
        return dependencies.getDependencies();
    }

    public Set<Dependency> getTestDependencies() {
        return dependencies.getTestDependencies();
    }

    public Set<Plugin> getPlugins() {
        return plugins.getPlugins();
    }
}

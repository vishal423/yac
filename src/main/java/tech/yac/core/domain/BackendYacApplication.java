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

import tech.yac.core.domain.build.BuildTool;
import tech.yac.core.domain.build.BuildToolType;

/**
 * Represents a backend server side Java application
 *
 * @author Vishal Mahajan
 */
public abstract class BackendYacApplication implements YacApplication {
    private BuildTool buildTool;
    private String rootPackage;

    @Override
    public ApplicationType getType() {
        return ApplicationType.BACKEND;
    }

    @Override
    public BuildToolType[] getSupportedBuildTools() {
        return new BuildToolType[]{BuildToolType.MAVEN};
    }

    public void setRootPackage(String rootPackage) {
        this.rootPackage = rootPackage;
    }

    public String getRootPackage() {
        return this.rootPackage;
    }

    public String getRootPackagePath() {
        return this.rootPackage.replace('.', '/');
    }

    public void setBuildTool(BuildTool buildTool) {
        this.buildTool = buildTool;
    }

    public BuildTool getBuildTool() {
        return this.buildTool;
    }
}

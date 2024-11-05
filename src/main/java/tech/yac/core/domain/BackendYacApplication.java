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
    // private Dependencies dependencies;

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

    public void setBuildTool(BuildTool buildTool) {
        this.buildTool = buildTool;
    }

    public BuildTool getBuildTool() {
        return this.buildTool;
    }
}

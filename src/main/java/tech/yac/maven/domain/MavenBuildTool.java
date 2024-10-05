package tech.yac.maven.domain;

import tech.yac.core.domain.BuildTool;
import tech.yac.core.domain.BuildToolType;

public class MavenBuildTool implements BuildTool {
    private static final String VERSION = "3.9.9";
    private static final String WRAPPER_VERSION = "3.3.2";

    private String version;
    private String wrapperVersion;
    private boolean wrapper;

    public MavenBuildTool() {
        this.version = VERSION;
        this.wrapperVersion = WRAPPER_VERSION;
        this.wrapper = true;
    }

    @Override
    public BuildToolType getType() {
        return BuildToolType.MAVEN;
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
}

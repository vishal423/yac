package tech.yac.core.domain;

public class Dependency {
    private String group;
    private String artifact;
    private Version version;

    public Dependency(String group, String artifact) {
        this.group = group;
        this.artifact = artifact;
    }

    public String getGroup() {
        return group;
    }

    public String getArtifact() {
        return artifact;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }
}

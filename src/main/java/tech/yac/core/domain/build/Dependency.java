package tech.yac.core.domain.build;

import java.util.Objects;

public class Dependency {
    private String group;
    private String artifact;
    private Version version;
    private DependencyScope scope;

    public Dependency(String group, String artifact) {
        this.group = group;
        this.artifact = artifact;
    }

    public Dependency(String group, String artifact, Version version) {
        this.group = group;
        this.artifact = artifact;
        this.version = version;
    }

    public Dependency(String group, String artifact, DependencyScope scope) {
        this.group = group;
        this.artifact = artifact;
        this.scope = scope;
    }

    public Dependency(String group, String artifact, Version version, DependencyScope scope) {
        this.group = group;
        this.artifact = artifact;
        this.version = version;
        this.scope = scope;
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

    public DependencyScope getScope() {
        return scope;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(group);
        result = prime * result + Objects.hashCode(artifact);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dependency other = (Dependency) obj;
        return Objects.equals(group, other.group) 
            && Objects.equals(artifact, other.artifact);
    }
}

package tech.yac.core.domain.build;

import java.util.Objects;

public class Plugin {
    private String group;
    private String artifact;

    public Plugin(String group, String artifact) {
        this.group = group;
        this.artifact = artifact;
    }

    public String getGroup() {
        return group;
    }

    public String getArtifact() {
        return artifact;
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
        Plugin other = (Plugin) obj;
        return Objects.equals(group, other.group) 
            && Objects.equals(artifact, other.artifact);
    }
}


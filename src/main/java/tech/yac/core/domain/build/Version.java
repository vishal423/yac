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


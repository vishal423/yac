package tech.yac.core.domain;

public class Version {
    private int major;
    private int minor;
    private Integer patch;

    public Version(int major, int minor) {
        this.major = major;
        this.minor = minor;
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


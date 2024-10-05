package tech.yac.core.domain.file;

public class YacFilePermission {

    private boolean execute;

    public static YacFilePermission standard() {
        return new YacFilePermission();
    }

    public YacFilePermission setExecutable() {
        this.execute = true;
        return this;
    }

    public boolean isExecute() {
        return execute;
    }
}

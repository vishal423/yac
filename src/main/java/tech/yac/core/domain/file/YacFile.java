package tech.yac.core.domain.file;

import java.util.Optional;

public class YacFile {
    private Optional<String> path = Optional.empty();
    private String name;
    private YacFilePermission permission;

    YacFile(String name) {
        this.name = name;
        this.permission = YacFilePermission.standard();
    }

    public static YacFile file(String name) {
        return new YacFile(name);
    }

    public YacFile parent(String path) {
        this.path = Optional.of(path);
        return this;
    }

    public YacFile executable() {
        this.permission.setExecutable();
        return this;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getPath() {
        return path;
    }

    public boolean isExecutable() {
        return permission.isExecute();
    }
}


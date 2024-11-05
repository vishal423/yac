package tech.yac.core.domain.build;

public enum DependencyScope {
    TEST("test");

    private String scope;

    DependencyScope(String scope) {
        this.scope = scope;
    }

    public String getScope() {
        return scope;
    }

    @Override
    public String toString() {
        return scope;
    }
}


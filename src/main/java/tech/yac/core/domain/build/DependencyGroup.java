package tech.yac.core.domain.build;

import java.util.LinkedList;
import java.util.List;

public class DependencyGroup {
    private List<Dependency> dependencies = new LinkedList<>();

    public List<Dependency> getDependencies() {
        return dependencies;
    }

    public void addDependency(Dependency dependency) {
        dependencies.add(dependency);
    }
}


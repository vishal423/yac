package tech.yac.core.domain.build;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Dependencies {
    private Set<Dependency> dependencies = new TreeSet<>(
        Comparator.nullsFirst(
            Comparator.comparing(Dependency::getScope))
        .thenComparing(
            Comparator.comparing(Dependency::getGroup)));

    public Set<Dependency> getDependencies() {
        return dependencies;
    }

    public void addDependency(Dependency dependency) {
        dependencies.add(dependency);
    }
}


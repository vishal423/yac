package tech.yac.core.domain.build;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Dependencies {
    private Set<Dependency> dependencies = new TreeSet<>(
            Comparator.comparing(Dependency::getGroup));
    private Set<Dependency> testDependencies = new TreeSet<>(
            Comparator.comparing(Dependency::getGroup));
    private Map<String, DependencyGroup> groupedDependencies = new LinkedHashMap<>();

    public Set<Dependency> getDependencies() {
        return dependencies;
    }

    public Set<Dependency> getTestDependencies() {
        return testDependencies;
    }

    public Map<String, DependencyGroup> getGroupedDependencies() {
        return groupedDependencies;
    }

    public void addDependency(Dependency dependency) {
        if(DependencyScope.TEST.equals(dependency.getScope())) {
            testDependencies.add(dependency);
        }

        dependencies.add(dependency);
    }

    public void addGroupedDependency(String group, Dependency dependency) {
        groupedDependencies.compute(group, (key, val) -> {
            if(val == null) {
                return new DependencyGroup();
            } else {
                val.addDependency(dependency);
                return val;
            }
        });
    }
}


package tech.yac.core.domain.build;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Plugins {
    private Set<Plugin> plugins = new TreeSet<>(
            Comparator.comparing(Plugin::getGroup));

    public Set<Plugin> getPlugins() {
        return plugins;
    }

    public void addPlugin(Plugin plugin) {
        plugins.add(plugin);
    }
}

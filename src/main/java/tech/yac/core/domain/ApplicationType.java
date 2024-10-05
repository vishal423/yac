package tech.yac.core.domain;

import java.util.List;

/**
 * Supported Application Types
 *
 * @author Vishal Mahajan
 */
public enum ApplicationType {
    BACKEND(List.of(FrameworkType.SPRING, FrameworkType.QUARKUS)), 
    FRONTEND(List.of(FrameworkType.REACT, FrameworkType.SVELTE));

    List<FrameworkType> frameworks;

    ApplicationType(List<FrameworkType> frameworks) {
        this.frameworks = frameworks;
    }

}

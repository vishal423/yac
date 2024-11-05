package tech.yac.core.domain.build;

/**
 * Represents a BuildTool instance supported by YAC
*
* @author Vishal Mahajan
*/
public interface BuildTool {

    /**
     * Build Tool type represented by an implementation
     */
    BuildToolType getType();

    void addDependency(Dependency dependency);
}

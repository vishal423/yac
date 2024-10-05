package tech.yac.core.domain;

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
}

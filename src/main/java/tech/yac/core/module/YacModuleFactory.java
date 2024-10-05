package tech.yac.core.module;

import tech.yac.core.domain.Application;

/**
 * YAC Module lifecycle
*
* @author Vishal Mahajan
*/
public interface YacModuleFactory {

    YacModule getModuleGraph(Application application);
}


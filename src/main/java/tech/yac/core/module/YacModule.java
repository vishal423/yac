package tech.yac.core.module;

import tech.yac.core.domain.Application;

/**
 * YAC Module lifecycle
*
* @author Vishal Mahajan
*/
public interface YacModule {

    YacModule composeWith(YacModule module);

    void configureOptions(Application application);

    void dryRun(Application application);

    void run(Application application);
}

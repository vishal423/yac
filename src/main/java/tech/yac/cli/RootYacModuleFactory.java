package tech.yac.cli;

import org.springframework.stereotype.Component;

import tech.yac.application.ApplicationYacModuleFactory;
import tech.yac.core.domain.Application;
import tech.yac.core.module.RootYacModule;
import tech.yac.core.module.YacModule;
import tech.yac.core.module.YacModuleFactory;

/**
 * YAC Module Factory
*
* @author Vishal Mahajan
*/
@Component
public class RootYacModuleFactory implements YacModuleFactory {
    private ApplicationYacModuleFactory applicationModuleFactory;

    public RootYacModuleFactory(ApplicationYacModuleFactory applicationModuleFactory) {
        this.applicationModuleFactory = applicationModuleFactory;
    }

    public YacModule getModuleGraph(Application application) {

        YacModule rootModule = getRootModule(application);

        YacModule applicationModule = applicationModuleFactory.getModuleGraph(application);
        rootModule.composeWith(applicationModule);

        return rootModule;
    }

    private YacModule getRootModule(Application application) {
        return new RootYacModule();
    }
}


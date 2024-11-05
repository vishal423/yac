package tech.yac.core.module;

import java.util.LinkedList;
import java.util.List;

import tech.yac.core.domain.Application;
import tech.yac.core.exception.YacException;

public class RootYacModule implements YacModule {

    private List<YacModule> modules = new LinkedList<>();

    @Override
    public YacModule composeWith(YacModule module) {
        if(modules.isEmpty()) {
            modules.add(module);
        } else {
            throw new YacException("Root module cannot be composed with more than one application module");
        }
        return this;
    }

    @Override
    public void configureOptions(Application application) {
        for(YacModule module: modules) {
            module.configureOptions(application);
        }
    }

    @Override
    public void dryRun(Application application) {
        for(YacModule module: modules) {
            module.dryRun(application);
        }
    }

    @Override
    public void run(Application application) {

        for(YacModule module: modules) {
            module.run(application);
        }
    }
}

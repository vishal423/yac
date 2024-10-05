package tech.yac.spring;

import java.util.Set;

import tech.yac.core.domain.Application;
import tech.yac.core.domain.YacTemplateConfig;
import tech.yac.core.module.CoreYacModule;
import tech.yac.core.module.YacModule;
import tech.yac.core.service.YacFileServiceFactory;
import tech.yac.core.service.YacTemplateServiceFactory;
import tech.yac.maven.MavenYacModule;

public class SpringYacModule extends CoreYacModule {

    public SpringYacModule(YacTemplateServiceFactory templateServiceFactory,
        YacFileServiceFactory fileServiceFactory) {
        super(templateServiceFactory, fileServiceFactory);
    }

    @Override
    protected Set<Class<? extends YacModule>> allowedComposeList() {
        return Set.of(MavenYacModule.class);
    }

    @Override
    protected YacTemplateConfig configure(Application application) {
        System.out.println("Configure template files ...");
        return new SpringYacTemplateConfig(application);
    }
}

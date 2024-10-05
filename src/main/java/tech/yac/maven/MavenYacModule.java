package tech.yac.maven;


import tech.yac.core.domain.Application;
import tech.yac.core.domain.YacTemplateConfig;
import tech.yac.core.module.CoreYacModule;
import tech.yac.core.service.YacFileServiceFactory;
import tech.yac.core.service.YacTemplateServiceFactory;

/**
 * Maven Codegen
 *
 * @author Vishal Mahajan
 */
public class MavenYacModule extends CoreYacModule {

    public MavenYacModule(YacTemplateServiceFactory templateServiceFactory,
        YacFileServiceFactory fileServiceFactory) {
        super(templateServiceFactory, fileServiceFactory);
    }

    @Override
    protected YacTemplateConfig configure(Application application) {
        System.out.println("Configure template files ...");
        return new MavenYacTemplateConfig(application);
    }
}

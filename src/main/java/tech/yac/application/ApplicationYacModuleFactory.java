package tech.yac.application;

import org.springframework.stereotype.Component;

import tech.yac.build.BuildYacModuleFactory;
import tech.yac.core.domain.Application;
import tech.yac.core.exception.YacException;
import tech.yac.core.module.YacModule;
import tech.yac.core.module.YacModuleFactory;
import tech.yac.core.service.YacFileServiceFactory;
import tech.yac.core.service.YacTemplateServiceFactory;
import tech.yac.spring.SpringYacModule;

@Component
public class ApplicationYacModuleFactory implements YacModuleFactory {

    private YacTemplateServiceFactory templateServiceFactory;
    private YacFileServiceFactory fileServiceFactory;
    private BuildYacModuleFactory buildModuleFactory;
    
    public ApplicationYacModuleFactory(
        YacTemplateServiceFactory templateServiceFactory, YacFileServiceFactory fileServiceFactory,
        BuildYacModuleFactory buildModuleFactory) {
        this.templateServiceFactory = templateServiceFactory;
        this.fileServiceFactory = fileServiceFactory;
        this.buildModuleFactory = buildModuleFactory;
    }

    public YacModule getModuleGraph(Application application) {
        YacModule applicationModule = getApplicationModule(application);

        YacModule buildModule = buildModuleFactory.getModuleGraph(application);
        applicationModule.composeWith(buildModule);

        return applicationModule;
    }

    private YacModule getApplicationModule(Application application) {

        if(application.getApplication() == null) {
            throw new YacException("Application configuration missing");
        }

        switch(application.getApplication().getType()) {
            case BACKEND:
                switch(application.getApplication().getFrameworkType()) {
                    case SPRING:
                        return new SpringYacModule(templateServiceFactory, fileServiceFactory);
                    default:
                        throw new YacException("not supported");
                }
            default:
                throw new YacException("not supported");
        }
    }
}


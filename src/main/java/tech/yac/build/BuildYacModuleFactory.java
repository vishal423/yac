package tech.yac.build;

import org.springframework.stereotype.Component;

import tech.yac.core.domain.Application;
import tech.yac.core.exception.YacException;
import tech.yac.core.module.YacModule;
import tech.yac.core.module.YacModuleFactory;
import tech.yac.core.service.YacFileServiceFactory;
import tech.yac.core.service.YacTemplateServiceFactory;
import tech.yac.maven.MavenYacModule;

@Component
public class BuildYacModuleFactory implements YacModuleFactory {

    private YacTemplateServiceFactory templateServiceFactory;
    private YacFileServiceFactory fileServiceFactory;
    
    public BuildYacModuleFactory(YacTemplateServiceFactory templateServiceFactory, YacFileServiceFactory fileServiceFactory) {
        this.templateServiceFactory = templateServiceFactory;
        this.fileServiceFactory = fileServiceFactory;
    }

    public YacModule getModuleGraph(Application application) {
        return getBuildModule(application);
    }

    public YacModule getBuildModule(Application application) {

        if(application.getApplication().getBuildTool() == null) {
            throw new YacException("Application build tool configuration missing");
        }

        switch(application.getApplication().getBuildTool().getType()) {
            case MAVEN:
                return new MavenYacModule(templateServiceFactory, fileServiceFactory);
            default:
                throw new YacException("not supported");
        }
    }
}

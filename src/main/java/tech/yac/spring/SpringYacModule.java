package tech.yac.spring;

import java.util.Set;

import tech.yac.core.domain.Application;
import tech.yac.core.domain.YacTemplateConfig;
import tech.yac.core.domain.build.Dependency;
import tech.yac.core.domain.build.DependencyScope;
import tech.yac.core.domain.build.Plugin;
import tech.yac.core.domain.build.Version;
import tech.yac.core.module.CoreYacModule;
import tech.yac.core.module.YacModule;
import tech.yac.core.service.YacFileServiceFactory;
import tech.yac.core.service.YacTemplateServiceFactory;
import tech.yac.maven.MavenYacModule;
import tech.yac.maven.domain.MavenBuildTool;

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
    protected void configureModuleOptions(Application application) {
        System.out.println("Configure spring module options ...");
        configureParentDependency(application);

        configureTestDependency(application);

        configurePlugins(application);
    }

    @Override
    protected YacTemplateConfig configureTemplates(Application application) {
        System.out.println("Configure spring template files ...");
        return new SpringYacTemplateConfig(application);
    }

    private void configureParentDependency(Application application) {
        if(application.getApplication().getBuildTool() instanceof MavenBuildTool buildTool) {
            if(!buildTool.containsParent()) {
                System.out.println("Configure default parent dependency ...");
                buildTool.setParent(new Dependency("org.springframework.boot",  "spring-boot-starter-parent", new Version(3, 3, 4)));
            }
        }
    }

    private void configureTestDependency(Application application) {
        if(application.getApplication().getBuildTool() instanceof MavenBuildTool buildTool) {
            System.out.println("Configure spring test dependency ...");
            buildTool.addDependency(new Dependency("org.springframework.boot",  "spring-boot-starter-test", DependencyScope.TEST));
        }
    }

    private void configurePlugins(Application application) {
        if(application.getApplication().getBuildTool() instanceof MavenBuildTool buildTool) {
            System.out.println("Configure spring boot plugins ...");
            buildTool.addPlugin(new Plugin("org.springframework.boot",  "spring-boot-maven-plugin"));
        }
    }
}

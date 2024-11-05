package tech.yac.core.module;

import static tech.yac.core.domain.FileServiceType.LOCAL;
import static tech.yac.core.domain.FileServiceType.LOG;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import tech.yac.core.domain.Application;
import tech.yac.core.domain.YacTemplateConfig;
import tech.yac.core.domain.YacTemplateModel;
import tech.yac.core.domain.file.YacFileContent;
import tech.yac.core.service.YacFileServiceFactory;
import tech.yac.core.service.YacTemplateServiceFactory;

/**
 * YAC Module lifecycle
*
* @author Vishal Mahajan
*/
public abstract class CoreYacModule implements YacModule {
    private List<YacModule> modules = new LinkedList<>();
    private YacTemplateServiceFactory templateServiceFactory;
    private YacFileServiceFactory fileServiceFactory;

    public CoreYacModule(YacTemplateServiceFactory templateServiceFactory,
        YacFileServiceFactory fileServiceFactory) {

        this.templateServiceFactory = templateServiceFactory;
        this.fileServiceFactory = fileServiceFactory;
    }

    protected void doDryRun(YacTemplateConfig templateConfig, Application application) {
        System.out.println("Generate files ...");
        fileStream(templateConfig, application)
            .forEach(file -> fileServiceFactory.getInstance(LOG).write(application.getLocation(), file));
    }

    public void doRun(YacTemplateConfig templateConfig, Application application) {
        System.out.println("Module code generation invoked");

        fileStream(templateConfig, application)
            .forEach(file -> fileServiceFactory.getInstance(LOCAL).write(application.getLocation(), file));
    }

    private Stream<YacFileContent> fileStream(YacTemplateConfig templateConfig, Application application) {
        return templateConfig.getTemplates().entrySet().stream()
            .map(entry -> new YacTemplateModel(templateConfig.getTemplateRoot(), entry.getKey(), entry.getValue(), application))
            .map(model -> templateServiceFactory.getInstance(model.getTemplateExtension()).process(model));
    }

    @Override
    public YacModule composeWith(YacModule module) {
        allowedComposeList()
            .stream()
            .filter(allowed -> allowed.equals(module.getClass()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException(module.getClass().getName() + " compose is not allowed"));

        modules.add(module);
        return this;
    }

    protected abstract void configureModuleOptions(Application application);

    @Override
    public void configureOptions(Application application) {
        configureModuleOptions(application);
        for(YacModule module: modules) {
            module.configureOptions(application);
        }
    }

    protected abstract YacTemplateConfig configureTemplates(Application application);

    @Override
    public void dryRun(Application application) {
        for(YacModule module: modules) {
            module.dryRun(application);
        }
        YacTemplateConfig templateConfig = configureTemplates(application);
        doDryRun(templateConfig, application);
    }

    @Override
    public void run(Application application) {
        for(YacModule module: modules) {
            module.run(application);
        }
        YacTemplateConfig templateConfig = configureTemplates(application);
        doRun(templateConfig, application);
    }

    protected Set<Class<? extends YacModule>> allowedComposeList() {
        return Set.of();
    }
}


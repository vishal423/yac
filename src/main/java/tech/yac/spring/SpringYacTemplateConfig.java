package tech.yac.spring;

import java.util.LinkedHashMap;
import java.util.Map;

import tech.yac.core.domain.Application;
import tech.yac.core.domain.YacTemplateConfig;
import tech.yac.core.domain.file.YacFile;
import tech.yac.spring.domain.SpringYacApplication;

public class SpringYacTemplateConfig implements YacTemplateConfig {

    private Map<YacFile, YacFile> templates = new LinkedHashMap<>();

    public SpringYacTemplateConfig(Application application) {
        configureTemplates(application);
    }

    private void configureTemplates(Application application) {
        SpringYacApplication springApplication = (SpringYacApplication) application.getApplication();

        addNestedTemplateFile("src/main/java/package", "Application.java",
            "src/main/java/" + springApplication.getRootPackagePath(), application.getName() + "Application.java");
        addNestedTemplateFile("src/main/resources", "application.yaml");
    }

    @Override
    public String getTemplateRoot() {
        return "spring";
    }

    @Override
    public Map<YacFile, YacFile> getTemplates() {
        return templates;
    }
}

package tech.yac.spring;

import java.util.LinkedHashMap;
import java.util.Map;

import tech.yac.core.domain.Application;
import tech.yac.core.domain.YacTemplateConfig;
import tech.yac.core.domain.file.YacFile;

public class SpringYacTemplateConfig implements YacTemplateConfig {

    private Map<YacFile, YacFile> templates = new LinkedHashMap<>();

    public SpringYacTemplateConfig(Application application) {
        configureTemplates(application);
    }

    private void configureTemplates(Application application) {
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

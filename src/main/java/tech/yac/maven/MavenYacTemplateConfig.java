package tech.yac.maven;

import java.util.LinkedHashMap;
import java.util.Map;

import tech.yac.core.domain.Application;
import tech.yac.core.domain.YacTemplateConfig;
import tech.yac.core.domain.file.YacFile;
import tech.yac.maven.domain.MavenBuildTool;

public class MavenYacTemplateConfig implements YacTemplateConfig {

    private Map<YacFile, YacFile> templates = new LinkedHashMap<>();

    public MavenYacTemplateConfig(Application application) {
        configureTemplates(application);
    }

    private void configureTemplates(Application application) {
        MavenBuildTool buildTool = (MavenBuildTool) application.getApplication().getBuildTool();

        if(buildTool.isWrapper()) {
            addFile("mvnw.cmd");
            addExecutableFile("mvnw");
            addNestedTemplateFile(".mvn/wrapper", "maven-wrapper.properties");
        }

        addTemplateFile("pom.xml");
    }

    @Override
    public String getTemplateRoot() {
        return "maven";
    }

    @Override
    public Map<YacFile, YacFile> getTemplates() {
        return templates;
    }
}


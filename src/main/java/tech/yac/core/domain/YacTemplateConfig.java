package tech.yac.core.domain;

import static tech.yac.core.domain.file.YacFile.file;
import static tech.yac.core.domain.file.YacTemplateFile.file;

import java.util.Map;

import tech.yac.core.domain.file.YacFile;

public interface YacTemplateConfig {

    String DEFAULT_TEMPLATE_EXTENSION = ".ftl";
    String[] SUPPORTED_TEMPLATE_EXTENSIONS = new String[] {".ftl"};

    String getTemplateRoot();

    Map<YacFile, YacFile> getTemplates();

    default void addTemplateFile(String name) {
        addTemplateFile(name, DEFAULT_TEMPLATE_EXTENSION);
    }

    default void addNestedTemplateFile(String path, String name) {
        addTemplateFile(path, name, DEFAULT_TEMPLATE_EXTENSION);
    }

    default void addTemplateFile(String path, String name, String templateExtension) {
        getTemplates().put(file(name, templateExtension).parent(path), file(name).parent(path));
    }

    default void addTemplateFile(String name, String templateExtension) {
        getTemplates().put(file(name, templateExtension), file(name));
    }

    default void addFile(String name) {
        getTemplates().put(file(name), file(name));
    }

    default void addExecutableFile(String name) {
        getTemplates().put(file(name), file(name).executable());
    }

}

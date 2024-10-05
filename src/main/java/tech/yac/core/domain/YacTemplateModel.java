package tech.yac.core.domain;

import java.util.Optional;

import tech.yac.core.domain.file.YacFile;
import tech.yac.core.domain.file.YacTemplateFile;

public class YacTemplateModel {

    private String templateRoot;
    private YacFile source;
    private YacFile destination;
    private Object model;

    public YacTemplateModel(String templateRoot, YacFile source, YacFile destination, Object model) {
        this.templateRoot = templateRoot;
        this.source = source;
        this.destination = destination;
        this.model = model;
    }

    public String getTemplateRoot() {
        return templateRoot;
    }

    public YacFile getSource() {
        return source;
    }

    public YacFile getDestination() {
        return destination;
    }

    public Optional<String> getTemplateExtension() {
        if(source instanceof YacTemplateFile) {
            return Optional.of(((YacTemplateFile) source).getTemplateExtension());
        }
        return Optional.empty();
    }

    public Object getModel() {
        return model;
    }
}

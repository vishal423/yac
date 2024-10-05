package tech.yac.core.domain.file;

public class YacTemplateFile extends YacFile {
    private String templateExtension;

    private YacTemplateFile(String path, String templateExtension) {
        super(path);
        this.templateExtension = templateExtension;
    }

    public static YacTemplateFile file(String filePath, String templateExtension) {
        return new YacTemplateFile(filePath, templateExtension);
    }

    public String getTemplateExtension() {
        return templateExtension;
    }
}

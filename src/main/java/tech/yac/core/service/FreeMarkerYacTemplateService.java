package tech.yac.core.service;

import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.nio.file.Paths;

import freemarker.template.Configuration;
import freemarker.template.Template;
import tech.yac.core.domain.YacTemplateModel;
import tech.yac.core.domain.file.YacFileContent;
import tech.yac.core.exception.YacTemplateException;

public class FreeMarkerYacTemplateService implements YacTemplateService {
    private Configuration configuration;

    public FreeMarkerYacTemplateService(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public YacFileContent process(YacTemplateModel templateModel) throws YacTemplateException {
        try {
            Template template = configuration.getTemplate(getTemplatePath(templateModel));
            String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, templateModel.getModel()); 
            return new YacFileContent(templateModel.getDestination(), content);
        } catch(Exception exception) {
            throw new YacTemplateException(exception);
        }
    }

    private String getTemplatePath(YacTemplateModel templateModel) {
        if(templateModel.getSource().getPath().isPresent()) {
            return Paths.get(
                templateModel.getTemplateRoot(),
                templateModel.getSource().getPath().get(),
                templateModel.getSource().getName() + templateModel.getTemplateExtension().get())
            .toString();

        }
        return Paths.get(
            templateModel.getTemplateRoot(),
            templateModel.getSource().getName() + templateModel.getTemplateExtension().get())
        .toString();
    }
}

package tech.yac.core.service;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Paths;

import tech.yac.core.domain.YacTemplateModel;
import tech.yac.core.domain.file.YacFileContent;
import tech.yac.core.exception.YacTemplateException;

public class NoopYacTemplateService implements YacTemplateService {

    @Override
    public YacFileContent process(YacTemplateModel templateModel) throws YacTemplateException {
        try {
            return new YacFileContent(templateModel.getDestination(),
                getTemplatePath(templateModel).getContentAsByteArray());
        } catch(Exception exception) {
            throw new YacTemplateException(exception);
        }
    }

    private ClassPathResource getTemplatePath(YacTemplateModel templateModel) throws IOException {
        if(templateModel.getSource().getPath().isPresent()) {
        return new ClassPathResource(
            Paths.get("templates",
                templateModel.getTemplateRoot(),
                templateModel.getSource().getPath().get(),
                templateModel.getSource().getName()).toString());
        }
        return new ClassPathResource(
            Paths.get("templates",
                templateModel.getTemplateRoot(),
                templateModel.getSource().getName()).toString());
    }
}


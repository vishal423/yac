package tech.yac.core.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Optional;

import tech.yac.core.domain.YacTemplateConfig;

public class YacTemplateServiceFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public YacTemplateService getInstance(Optional<String> templateExtension) {
        if(templateExtension.isPresent()) {
            if(YacTemplateConfig.DEFAULT_TEMPLATE_EXTENSION.equalsIgnoreCase(templateExtension.get())) {
                return applicationContext.getBean(FreeMarkerYacTemplateService.class.getSimpleName(), YacTemplateService.class);
            }
        }
        return applicationContext.getBean(NoopYacTemplateService.class.getSimpleName(), YacTemplateService.class);
    }
}

package tech.yac.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import tech.yac.core.service.FreeMarkerYacTemplateService;
import tech.yac.core.service.LocalYacFileService;
import tech.yac.core.service.LogYacFileService;
import tech.yac.core.service.NoopYacTemplateService;
import tech.yac.core.service.YacFileService;
import tech.yac.core.service.YacFileServiceFactory;
import tech.yac.core.service.YacTemplateService;
import tech.yac.core.service.YacTemplateServiceFactory;

@Configuration
class CoreYacModuleConfig {

    @Bean("FreeMarkerYacTemplateService")
    @Primary
    YacTemplateService templateService(freemarker.template.Configuration configuration) {
        return new FreeMarkerYacTemplateService(configuration);
    }

    @Bean("NoopYacTemplateService")
    YacTemplateService noopTemplateService() {
        return new NoopYacTemplateService();
    }

    @Bean
    YacTemplateServiceFactory templateFactory() {
        return new YacTemplateServiceFactory();
    }

    @Bean("LocalYacFileService")
    @Primary
    YacFileService fileService() {
        return new LocalYacFileService();
    }

    @Bean("LogYacFileService")
    YacFileService logFileService() {
        return new LogYacFileService();
    }

    @Bean
    YacFileServiceFactory fileServiceFactory() {
        return new YacFileServiceFactory();
    }
}

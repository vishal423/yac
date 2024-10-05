package tech.yac.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import tech.yac.core.service.YacFileServiceFactory;
import tech.yac.core.service.YacTemplateServiceFactory;
import tech.yac.spring.SpringYacModule;

@Configuration
class SpringYacModuleConfig {

    @Bean
    @Scope("prototype")
    SpringYacModule springYacModule(YacTemplateServiceFactory templateServiceFactory, YacFileServiceFactory fileServiceFactory) {
        return new SpringYacModule(templateServiceFactory, fileServiceFactory);
    }
}


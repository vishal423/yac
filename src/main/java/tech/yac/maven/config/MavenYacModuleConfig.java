package tech.yac.maven.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import tech.yac.core.service.YacFileServiceFactory;
import tech.yac.core.service.YacTemplateServiceFactory;
import tech.yac.maven.MavenYacModule;

@Configuration
class MavenYacModuleConfig {

    @Bean
    @Scope("prototype")
    MavenYacModule mavenYacModule(YacTemplateServiceFactory templateServiceFactory, YacFileServiceFactory fileServiceFactory) {
        return new MavenYacModule(templateServiceFactory, fileServiceFactory);
    }
}

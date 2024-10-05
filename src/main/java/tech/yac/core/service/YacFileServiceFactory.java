package tech.yac.core.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import tech.yac.core.domain.FileServiceType;

public class YacFileServiceFactory implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public YacFileService getInstance(FileServiceType fileServiceType) {
        if(FileServiceType.LOCAL.equals(fileServiceType)) {
            return applicationContext.getBean(LocalYacFileService.class.getSimpleName(), YacFileService.class);
        }
        return applicationContext.getBean(LogYacFileService.class.getSimpleName(), YacFileService.class);
    }
}


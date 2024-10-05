package tech.yac.core.service;

import tech.yac.core.domain.YacTemplateModel;
import tech.yac.core.domain.file.YacFileContent;

public interface YacTemplateService {

    YacFileContent process(YacTemplateModel templateModel);
}

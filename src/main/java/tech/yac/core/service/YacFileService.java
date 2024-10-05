package tech.yac.core.service;

import tech.yac.core.domain.file.YacFileContent;

public interface YacFileService {

    void write(String fileRoot, YacFileContent file);
}

package tech.yac.core.service;

import java.nio.file.Path;
import java.nio.file.Paths;

import tech.yac.core.domain.file.YacFileContent;
import tech.yac.core.exception.YacException;

public class LogYacFileService implements YacFileService {

    @Override
    public void write(String fileRoot, YacFileContent file) throws YacException {
        System.out.println("Writing " + getFilePath(fileRoot, file).toString());
    }

    private Path getFilePath(String fileRoot, YacFileContent file) {
        if(file.getFile().getPath().isPresent()) {
            return Paths.get(fileRoot, file.getFile().getPath().get(), file.getFile().getName());
        }
        return Paths.get(fileRoot, file.getFile().getName());
    }
}


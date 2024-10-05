package tech.yac.core.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import tech.yac.core.domain.file.YacFileContent;
import tech.yac.core.exception.YacException;

public class LocalYacFileService implements YacFileService {

    @Override
    public void write(String fileRoot, YacFileContent file) throws YacException {
        try {

            if(file.getFile().getPath().isPresent()) {
                Files.createDirectories(getDirectoryPath(fileRoot, file));
            }

            Path filePath = getFilePath(fileRoot, file);
            if(file.isBinary()) {
                Files.write(filePath, file.getBinaryContent());
            } else {
                Files.writeString(filePath, file.getContent());
            }
            if(file.getFile().isExecutable()) {
                setExecutePermission(filePath);
            }
        } catch(Exception exception) {
            throw new YacException(exception);
        }
    }

    private Path getFilePath(String fileRoot, YacFileContent file) {
        return Paths.get(getDirectoryPath(fileRoot, file).toString(), file.getFile().getName());
    }

    private Path getDirectoryPath(String fileRoot, YacFileContent file) {
        if(file.getFile().getPath().isPresent()) {
            return Paths.get(fileRoot, file.getFile().getPath().get());
        }
        return Paths.get(fileRoot);
    }

    private void setExecutePermission(Path path) {
        new File(path.toString()).setExecutable(true, false);
    }
}

package tech.yac.core.domain.file;

public class YacFileContent {
    private YacFile file;
    private String content;
    private byte[] binaryContent;
    private boolean binary;

    public YacFileContent(YacFile file, String content) {
        this.file = file;
        this.content = content;
        this.binary = false;
    }

    public YacFileContent(YacFile file, byte[] binaryContent) {
        this.file = file;
        this.binaryContent = binaryContent;
        this.binary = true;
    }

    public boolean isBinary() {
        return binary;
    }

    public YacFile getFile() {
        return file;
    }

    public String getContent() {
        return content;
    }

    public byte[] getBinaryContent() {
        return binaryContent;
    }
}

package tech.yac.core.exception;

public class YacTemplateException extends RuntimeException {

    public YacTemplateException(String message) {
        super(message);
    }

    public YacTemplateException(Throwable throwable) {
        super(throwable);
    }
}

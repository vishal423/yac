package tech.yac.core.exception;

public class YacException extends RuntimeException {

    public YacException(String message) {
        super(message);
    }

    public YacException(Throwable throwable) {
        super(throwable);
    }
}


package io.dodn.devgem.support.error;

public class InternalApiException extends RuntimeException {
    private final InternalErrorType errorType;
    private final Object data;

    public InternalApiException(InternalErrorType errorType, Object data) {
        super(errorType.getMessage());
        this.errorType = errorType;
        this.data = data;
    }

    public InternalErrorType getErrorType() {
        return errorType;
    }

    public Object getData() {
        return data;
    }
}

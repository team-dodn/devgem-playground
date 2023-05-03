package io.dodn.devgem.support.error;

public class InternalErrorMessage {
    private final String code;
    private final String message;
    private final Object data;

    public InternalErrorMessage(InternalErrorType errorType) {
        this.code = errorType.getCode().name();
        this.message = errorType.getMessage();
        this.data = null;
    }

    public InternalErrorMessage(InternalErrorType errorType, Object data) {
        this.code = errorType.getCode().name();
        this.message = errorType.getMessage();
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}

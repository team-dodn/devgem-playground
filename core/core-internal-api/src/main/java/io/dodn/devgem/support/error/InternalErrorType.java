package io.dodn.devgem.support.error;

import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;

public enum InternalErrorType {
    DEFAULT_ERROR(
            HttpStatus.INTERNAL_SERVER_ERROR,
            InternalErrorCode.E500,
            "An unexpected error has occurred.",
            LogLevel.ERROR);

    private final HttpStatus status;
    private final InternalErrorCode code;
    private final String message;
    private final LogLevel logLevel;

    InternalErrorType(
            HttpStatus status, InternalErrorCode code, String message, LogLevel logLevel) {

        this.status = status;
        this.code = code;
        this.message = message;
        this.logLevel = logLevel;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public InternalErrorCode getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }
}

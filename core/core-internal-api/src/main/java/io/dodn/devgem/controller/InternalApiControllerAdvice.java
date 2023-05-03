package io.dodn.devgem.controller;

import io.dodn.devgem.support.error.InternalApiException;
import io.dodn.devgem.support.error.InternalErrorType;
import io.dodn.devgem.support.response.InternalApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "")
public class InternalApiControllerAdvice {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(InternalApiException.class)
    public ResponseEntity<InternalApiResponse<?>> handleCoreApiException(InternalApiException e) {
        switch (e.getErrorType().getLogLevel()) {
            case ERROR -> log.error("CoreApiException : {}", e.getMessage(), e);
            case WARN -> log.warn("CoreApiException : {}", e.getMessage(), e);
            default -> log.info("CoreApiException : {}", e.getMessage(), e);
        }
        return new ResponseEntity<>(
                InternalApiResponse.error(e.getErrorType(), e.getData()),
                e.getErrorType().getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<InternalApiResponse<?>> handleException(Exception e) {
        log.error("Exception : {}", e.getMessage(), e);
        return new ResponseEntity<>(
                InternalApiResponse.error(InternalErrorType.DEFAULT_ERROR),
                InternalErrorType.DEFAULT_ERROR.getStatus());
    }
}

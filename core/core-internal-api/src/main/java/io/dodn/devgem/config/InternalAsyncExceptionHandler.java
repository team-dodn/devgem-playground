package io.dodn.devgem.config;

import io.dodn.devgem.support.error.InternalApiException;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class InternalAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void handleUncaughtException(Throwable e, Method method, Object... params) {
        if (e instanceof InternalApiException) {
            switch (((InternalApiException) e).getErrorType().getLogLevel()) {
                case ERROR -> log.error("CoreApiException : {}", e.getMessage(), e);
                case WARN -> log.warn("CoreApiException : {}", e.getMessage(), e);
                default -> log.info("CoreApiException : {}", e.getMessage(), e);
            }
        } else {
            log.error("Exception : {}", e.getMessage(), e);
        }
    }
}

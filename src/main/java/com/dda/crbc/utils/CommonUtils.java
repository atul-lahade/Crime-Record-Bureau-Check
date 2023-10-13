package com.dda.crbc.utils;

import com.dda.crbc.exception.ServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Common utilities.
 */
@Component
public class CommonUtils {

    @Value("${spring.application.name}")
    private String applicationName;

    private CommonUtils() {
    }

    /**
     * Utility to build service exception.
     *
     * @param errorCode
     * @param errorDescription
     * @param exception
     * @return {@code ServiceException}
     */
    public ServiceException buildServiceException(String errorCode, String errorDescription, Throwable exception) {
        return ServiceException.builder()
                .serviceName(applicationName)
                .errorCode(errorCode)
                .errorDescription(errorDescription)
                .exception(exception)
                .build();
    }

    /**
     * Utility to build service exception
     *
     * @param errorCode
     * @param errorDescription
     * @return
     */
    public ServiceException buildServiceException(String errorCode, String errorDescription) {
        return buildServiceException(errorCode, errorDescription, null);
    }
}

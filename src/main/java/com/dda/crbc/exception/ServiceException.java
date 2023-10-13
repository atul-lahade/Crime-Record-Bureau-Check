package com.dda.crbc.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Custom service exception class.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceException extends Exception {

    private static final long serialVersionUID = 3663950444600663161L;

    private String serviceName;
    private String errorCode;
    private String errorDescription;
    private Throwable exception;
}
package com.dda.crbc.exception;


import com.dda.crbc.beans.response.ValidationErrorResponse;
import com.dda.crbc.constants.CommonErrorCodes;
import com.dda.crbc.helper.LocalHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * AOP to provide common exception handling across services.
 */
@ControllerAdvice
@Slf4j
public class ServiceExceptionHandler {

    public static final String ERROR_MESSAGE = "Please enter valid data in all the fields";
    @Autowired
    LocalHelper localHelper;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ServiceException> handleGenericException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(handleException(e));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ServiceException> handleRunTimeException(RuntimeException e) {
        if (e.getCause() instanceof ServiceException) {
            return handleServiceException((ServiceException) e.getCause());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(handleException(e));
    }

    @ExceptionHandler({MaxUploadSizeExceededException.class})
    public ResponseEntity<ValidationErrorResponse> handleRunTimeException(
            MaxUploadSizeExceededException ex) {
        return ResponseEntity.badRequest().body(ValidationErrorResponse.builder()
                .status(Integer.valueOf(CommonErrorCodes.FILE_SIZE_EXCEEDED))
                .message("Maximum upload size exceeded.")
                .build());
    }

    @ExceptionHandler({BindException.class})
    public ResponseEntity<ValidationErrorResponse> handleRunTimeException(
            BindException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = Objects.nonNull(error.getDefaultMessage()) ? ObjectUtils.defaultIfNull(localHelper.getLocalMessage(error.getDefaultMessage()), error.getDefaultMessage()) : null;
            if (errors.containsKey(fieldName)) {
                errorMessage = errors.get(fieldName).concat(" | ").concat(ObjectUtils.defaultIfNull(errorMessage, ""));
            }
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(ValidationErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ERROR_MESSAGE)
                .errors(errors).build());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ValidationErrorResponse> handleMissingServletRequestParameterException(
            MissingServletRequestParameterException ex) {
        Map<String, String> errors = new HashMap<>();
        String fieldName = ex.getParameterName();
        String errorMessage = ex.getMessage();
        errors.put(fieldName, errorMessage);
        return ResponseEntity.badRequest().body(ValidationErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(CommonErrorCodes.FAILURE)
                .errors(errors).build());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ValidationErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String message = e.getMethod() + " Method is not supported";
        ValidationErrorResponse response = ValidationErrorResponse.builder()
                .status(HttpStatus.METHOD_NOT_ALLOWED.value())
                .message(message).build();
        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ServiceException> handleServiceException(ServiceException e) {
        if (CommonErrorCodes.UNAUTHORIZED.equals(e.getErrorCode())) {
            log.error("Unauthenticated user, Reason: {}", e.getErrorDescription());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e);
        } else if (CommonErrorCodes.FORBIDDEN.equals(e.getErrorCode())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<IllegalArgumentException> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e);
    }

    private ServiceException handleException(Exception e) {
        return ServiceException.builder()
                .errorDescription(e.getMessage())
                .exception(e)
                .build();
    }
}

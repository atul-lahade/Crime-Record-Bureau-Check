package com.dda.crbc.beans.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
@Builder
public class ValidationErrorResponse implements Serializable {

    private static final long serialVersionUID = -2523383345683052638L;
    private Integer status;
    private String message;
    private Map<String, String> errors;
}

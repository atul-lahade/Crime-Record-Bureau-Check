package com.dda.crbc.beans.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CrbUpdateRequest {
    private Long requestId;
    private String comment;
    private String status;
}

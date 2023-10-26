package com.dda.crbc.beans.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDetails {
    private String companyName;
    private String contactEmail;
    private String contactPersonName;
    private String contactPhone;
    private String industry;
}

package com.dda.crbc.beans.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignUpRequest {
    private String userType;
    private String fullName;
    private String contactNumber;
    private String dateOfBirth;
    private String gender;
    private String nationality;
    private String address;
    private String identificationNumber;
    private String passportNumber;
    private String email;
    private String password;
    private CompanyDetails companyDetails;
}

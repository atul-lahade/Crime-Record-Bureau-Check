package com.dda.crbc.beans.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class SignInResponse implements Serializable {

    private static final long serialVersionUID = 3410901347255362917L;

    private String userName;
    private String userType;
    private Long userId;
    private Long applicantId;
    private Long administratorId;

}

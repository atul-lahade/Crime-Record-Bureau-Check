package com.dda.crbc.beans.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class SignUpResponse implements Serializable {

    private static final long serialVersionUID = 3410901347252367917L;

    private Long userId;
    private Long applicantId;
    private Long administratorId;
}

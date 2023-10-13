package com.dda.crbc.beans.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerResponse implements Serializable {

    private static final long serialVersionUID = 3410901347252367987L;


    private List<Employer> employers;

    @Data
    @Builder
    @ToString
    public static class Employer implements Serializable {
        private static final long serialVersionUID = -722792142692312163L;
        private Long employerId;
        private CrbUserResponse.CrbUser user;
        private String companyName;
        private String industry;
        private String contactPersonName;
        private String contactEmail;
        private String contactPhone;
    }
}

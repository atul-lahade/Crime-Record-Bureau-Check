package com.dda.crbc.beans.response;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantResponse implements Serializable {

    private static final long serialVersionUID = 3410901347252367927L;
    private List<Applicant> applicants;

    @Data
    @Builder
    @ToString
    public static class Applicant implements Serializable {
        private static final long serialVersionUID = -723792142642311163L;
        private Long applicantId;
        private String fullName;
        private Date dateOfBirth;
        private String gender;
        private String nationality;
        private String contactNumber;
        private String address;
        private String identificationNumber;
        private String passportNumber;
        private CriminalRecord criminalRecord;
    }
}

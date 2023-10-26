package com.dda.crbc.beans.response;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CriminalRecordResponse implements Serializable {

    private static final long serialVersionUID = 3410901347252367967L;


    private List<CriminalRecord> criminalRecords;

    @Data
    @Builder
    @ToString
    public static class CriminalRecord implements Serializable {
        private static final long serialVersionUID = -723792132642412163L;
        private Long recordId;
        private ApplicantResponse.Applicant applicant;
        private String crimeDescription;
        private LocalDateTime convictionDate;
        private String severityLevel;
        private String judicialAuthority;
    }
}

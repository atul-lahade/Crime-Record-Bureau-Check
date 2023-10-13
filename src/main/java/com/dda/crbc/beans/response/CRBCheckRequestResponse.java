package com.dda.crbc.beans.response;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CRBCheckRequestResponse implements Serializable {
    private static final long serialVersionUID = 3410901347252367947L;

    private List<CRBCheckRequest> crbCheckRequests;

    @Data
    @Builder
    @ToString
    public static class CRBCheckRequest implements Serializable {
        private static final long serialVersionUID = -723792042642312163L;
        private Long requestId;
        private ApplicantResponse.Applicant applicant;
        private LocalDateTime requestDate;
        private String status;
        private AdministratorResponse.Administrator assignedTo;
        private String comments;
        private LocalDateTime completionDate;
        private LocalDateTime lastUpdated;
    }
}

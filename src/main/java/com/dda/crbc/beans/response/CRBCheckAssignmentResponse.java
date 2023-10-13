package com.dda.crbc.beans.response;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CRBCheckAssignmentResponse implements Serializable {

    private static final long serialVersionUID = 3410901347252367937L;


    private List<CRBCheckAssignment> crbCheckAssignments;

    @Data
    @Builder
    @ToString
    public static class CRBCheckAssignment implements Serializable {
        private static final long serialVersionUID = -723792132642612163L;
        private Long assignmentId;
        private CRBCheckRequestResponse.CRBCheckRequest crbCheckRequest;
        private EmployerResponse.Employer employer;
        private LocalDateTime assignDate;
        private LocalDateTime dueDate;
    }
}

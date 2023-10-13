package com.dda.crbc.beans.response;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackResponse implements Serializable {

    private static final long serialVersionUID = 3411901347252367997L;
    private Long feedbackId;
    private CRBCheckAssignmentResponse crbCheckAssignment;
    private AdministratorResponse administrator;
    private LocalDateTime feedbackDate;
    private String feedbackText;

    private List<ActivityLogResponse.ActivityLog> activityLogs;

    @Data
    @Builder
    @ToString
    public static class ActivityLog implements Serializable {
        private static final long serialVersionUID = -723772142342322163L;
        private Long feedbackId;
        private CRBCheckAssignmentResponse.CRBCheckAssignment crbCheckAssignment;
        private AdministratorResponse.Administrator administrator;
        private LocalDateTime feedbackDate;
        private String feedbackText;
    }
}

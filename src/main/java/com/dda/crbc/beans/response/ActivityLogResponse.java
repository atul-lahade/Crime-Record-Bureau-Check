package com.dda.crbc.beans.response;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityLogResponse implements Serializable {

    private static final long serialVersionUID = -1763990357851770326L;

    private List<ActivityLog> activityLogs;

    @Data
    @Builder
    @ToString
    public static class ActivityLog implements Serializable {
        private static final long serialVersionUID = -723792142642312163L;
        private Long logId;
        private CrbUserResponse.CrbUser user;
        private String activityType;
        private String activityDetails;
        private LocalDateTime activityTimestamp;
    }
}

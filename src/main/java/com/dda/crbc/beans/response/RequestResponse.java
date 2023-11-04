package com.dda.crbc.beans.response;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestResponse implements Serializable {
    private static final long serialVersionUID = 3410701317253367927L;
    private List<Request> requests;

    @Data
    @Builder
    @ToString
    public static class Request implements Serializable {
        private static final long serialVersionUID = -721792342542311163L;
        private Long requestId;
        private Long applicantId;
        private Date requestDate;
        private String status;
        private Long assignedTo;
        private String comments;
        private Date completionDate;
        private Date lastUpdated;
    }
}

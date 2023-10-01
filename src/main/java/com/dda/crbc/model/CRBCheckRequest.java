package com.dda.crbc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "crbcheckRequest")
public class CRBCheckRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long requestId;

    @ManyToOne
    @JoinColumn(name = "applicant_id", referencedColumnName = "applicant_id")
    private Applicant applicant;

    @Column(name = "request_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp requestDate;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @ManyToOne
    @JoinColumn(name = "assigned_to", referencedColumnName = "administrator_id")
    private Administrator assignedTo;

    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;

    @Column(name = "completion_date")
    private Timestamp completionDate;

    @Column(name = "last_updated", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp lastUpdated;

    public CRBCheckRequest() {
    }

    public CRBCheckRequest(Applicant applicant, Timestamp requestDate, String status, Administrator assignedTo, String comments, Timestamp completionDate, Timestamp lastUpdated) {
        this.applicant = applicant;
        this.requestDate = requestDate;
        this.status = status;
        this.assignedTo = assignedTo;
        this.comments = comments;
        this.completionDate = completionDate;
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "CRBCheckRequest{" +
                "requestId=" + requestId +
                ", applicant=" + applicant +
                ", requestDate=" + requestDate +
                ", status='" + status + '\'' +
                ", assignedTo=" + assignedTo +
                ", comments='" + comments + '\'' +
                ", completionDate=" + completionDate +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
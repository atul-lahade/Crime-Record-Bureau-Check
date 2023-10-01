package com.dda.crbc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "CRBCheckAssignment")
public class CRBCheckAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_id")
    private Long assignmentId;

    @ManyToOne
    @JoinColumn(name = "request_id", referencedColumnName = "request_id")
    private CRBCheckRequest crbCheckRequest;

    @ManyToOne
    @JoinColumn(name = "employer_id", referencedColumnName = "employer_id")
    private Employer employer;

    @Column(name = "assign_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp assignDate;

    @Column(name = "due_date")
    private Timestamp dueDate;

    public CRBCheckAssignment() {
    }

    public CRBCheckAssignment(CRBCheckRequest crbCheckRequest, Employer employer, Timestamp assignDate, Timestamp dueDate) {
        this.crbCheckRequest = crbCheckRequest;
        this.employer = employer;
        this.assignDate = assignDate;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "CRBCheckAssignment{" +
                "assignmentId=" + assignmentId +
                ", crbCheckRequest=" + crbCheckRequest +
                ", employer=" + employer +
                ", assignDate=" + assignDate +
                ", dueDate=" + dueDate +
                '}';
    }
}

package com.dda.crbc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "Feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Long feedbackId;

    @ManyToOne
    @JoinColumn(name = "assignment_id", referencedColumnName = "assignment_id")
    private CRBCheckAssignment crbCheckAssignment;

    @ManyToOne
    @JoinColumn(name = "administrator_id", referencedColumnName = "administrator_id")
    private Administrator administrator;

    @Column(name = "feedback_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp feedbackDate;

    @Column(name = "feedback_text", columnDefinition = "TEXT")
    private String feedbackText;

    public Feedback() {
    }

    public Feedback(CRBCheckAssignment crbCheckAssignment, Administrator administrator, Timestamp feedbackDate, String feedbackText) {
        this.crbCheckAssignment = crbCheckAssignment;
        this.administrator = administrator;
        this.feedbackDate = feedbackDate;
        this.feedbackText = feedbackText;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + feedbackId +
                ", crbCheckAssignment=" + crbCheckAssignment +
                ", administrator=" + administrator +
                ", feedbackDate=" + feedbackDate +
                ", feedbackText='" + feedbackText + '\'' +
                '}';
    }
}
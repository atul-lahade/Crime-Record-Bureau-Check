package com.dda.crbc.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
}
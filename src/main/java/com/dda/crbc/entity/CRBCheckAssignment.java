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
}

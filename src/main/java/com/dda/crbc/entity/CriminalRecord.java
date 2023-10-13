package com.dda.crbc.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "criminalrecord")
public class CriminalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long recordId;

    @ManyToOne
    @JoinColumn(name = "applicant_id", referencedColumnName = "applicant_id")
    private Applicant applicant;

    @Column(name = "crime_description", columnDefinition = "TEXT")
    private String crimeDescription;

    @Column(name = "conviction_date")
    private java.sql.Date convictionDate;

    @Column(name = "severity_level", length = 20)
    private String severityLevel;

    @Column(name = "judicial_authority", length = 100)
    private String judicialAuthority;
}

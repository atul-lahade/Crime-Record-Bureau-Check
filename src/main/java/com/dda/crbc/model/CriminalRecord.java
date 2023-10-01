package com.dda.crbc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
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

    public CriminalRecord() {
    }

    public CriminalRecord(Applicant applicant, String crimeDescription, Date convictionDate, String severityLevel, String judicialAuthority) {
        this.applicant = applicant;
        this.crimeDescription = crimeDescription;
        this.convictionDate = convictionDate;
        this.severityLevel = severityLevel;
        this.judicialAuthority = judicialAuthority;
    }

    @Override
    public String toString() {
        return "CriminalRecord{" +
                "recordId=" + recordId +
                ", applicant=" + applicant +
                ", crimeDescription='" + crimeDescription + '\'' +
                ", convictionDate=" + convictionDate +
                ", severityLevel='" + severityLevel + '\'' +
                ", judicialAuthority='" + judicialAuthority + '\'' +
                '}';
    }
}

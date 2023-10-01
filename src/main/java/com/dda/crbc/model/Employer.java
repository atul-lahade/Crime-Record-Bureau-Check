package com.dda.crbc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employer")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employer_id")
    private Long employerId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private CrbUser crbUser;

    @Column(name = "company_name", nullable = false, length = 100)
    private String companyName;

    @Column(name = "industry", length = 50)
    private String industry;

    @Column(name = "contact_person_name", length = 100)
    private String contactPersonName;

    @Column(name = "contact_email", length = 100)
    private String contactEmail;

    @Column(name = "contact_phone", length = 20)
    private String contactPhone;

    public Employer() {
    }

    public Employer(CrbUser crbUser, String companyName, String industry, String contactPersonName, String contactEmail, String contactPhone) {
        this.crbUser = crbUser;
        this.companyName = companyName;
        this.industry = industry;
        this.contactPersonName = contactPersonName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "employerId=" + employerId +
                ", crbUser=" + crbUser +
                ", companyName='" + companyName + '\'' +
                ", industry='" + industry + '\'' +
                ", contactPersonName='" + contactPersonName + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                '}';
    }
}
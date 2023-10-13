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
@Table(name = "applicant")
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicant_id")
    private Long applicantId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private CrbUser crbUser;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "date_of_birth", nullable = false)
    private java.sql.Date dateOfBirth;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "nationality", length = 50)
    private String nationality;

    @Column(name = "contact_number", length = 20)
    private String contactNumber;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

    @Column(name = "identification_number", length = 50)
    private String identificationNumber;

    @Column(name = "passport_number", length = 50)
    private String passportNumber;

}

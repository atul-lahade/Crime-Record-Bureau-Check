package com.dda.crbc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "administrator")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "administrator_id")
    private Long administratorId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private CrbUser crbUser;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "contact_number", length = 20)
    private String contactNumber;

    public Administrator() {
    }

    public Administrator(CrbUser crbUser, String fullName, String contactNumber) {
        this.crbUser = crbUser;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "administratorId=" + administratorId +
                ", crbUser=" + crbUser +
                ", fullName='" + fullName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}

package com.dda.crbc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "crb_users")
public class CrbUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password_hash", nullable = false, length = 100)
    private String passwordHash;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "user_type", nullable = false, length = 20)
    private String userType;

    public CrbUser(String username, String passwordHash, String email, String userType) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.userType = userType;
    }

    public CrbUser() {
    }

    @Override
    public String toString() {
        return "CrbUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", email='" + email + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}

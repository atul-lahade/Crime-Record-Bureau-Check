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
@Table(name = "ActivityLog")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private CrbUser crbUser;

    @Column(name = "activity_type", length = 50)
    private String activityType;

    @Column(name = "activity_details", columnDefinition = "TEXT")
    private String activityDetails;

    @Column(name = "activity_timestamp", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp activityTimestamp;

}
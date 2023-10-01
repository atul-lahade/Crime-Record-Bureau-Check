package com.dda.crbc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
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

    public ActivityLog() {
    }

    public ActivityLog(CrbUser crbUser, String activityType, String activityDetails, Timestamp activityTimestamp) {
        this.crbUser = crbUser;
        this.activityType = activityType;
        this.activityDetails = activityDetails;
        this.activityTimestamp = activityTimestamp;
    }

    @Override
    public String toString() {
        return "ActivityLog{" +
                "logId=" + logId +
                ", crbUser=" + crbUser +
                ", activityType='" + activityType + '\'' +
                ", activityDetails='" + activityDetails + '\'' +
                ", activityTimestamp=" + activityTimestamp +
                '}';
    }
}
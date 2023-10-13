package com.dda.crbc.service;

import com.dda.crbc.beans.response.ActivityLogResponse;
import com.dda.crbc.beans.response.CrbUserResponse;
import com.dda.crbc.entity.ActivityLog;
import com.dda.crbc.reepository.ActivityLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GetAllService {

    @Autowired
    private ActivityLogRepository activityLogRepository;

    public List<ActivityLogResponse.ActivityLog> getAllActivityLogs() {

        List<ActivityLog> activityLogs = activityLogRepository.findAll();

        List<ActivityLogResponse.ActivityLog> activityLogList = activityLogs.stream()
                .map(activityLog -> ActivityLogResponse.ActivityLog.builder()
                        .logId(activityLog.getLogId())
                        .user(CrbUserResponse.CrbUser.builder()
                                .userId(activityLog.getCrbUser().getUserId())
                                .email(activityLog.getCrbUser().getEmail())
                                .username(activityLog.getCrbUser().getUsername())
                                .userType(activityLog.getCrbUser().getUserType()).build())
                        .activityDetails(activityLog.getActivityDetails())
                        .activityType(activityLog.getActivityType())
                        .activityTimestamp(activityLog.getActivityTimestamp().toLocalDateTime()).build()).collect(Collectors.toList());
        return activityLogList;
    }
}

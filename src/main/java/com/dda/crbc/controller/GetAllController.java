package com.dda.crbc.controller;

import com.dda.crbc.beans.response.ActivityLogResponse;
import com.dda.crbc.beans.response.ApplicantResponse;
import com.dda.crbc.beans.response.Response;
import com.dda.crbc.constants.CommonErrorCodes;
import com.dda.crbc.service.GetAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class GetAllController {

    @Autowired
    private GetAllService getAllService;

    @GetMapping("/activity-logs")
    public ResponseEntity<Response<ActivityLogResponse>> getAllActivityLogs() {
        List<ActivityLogResponse.ActivityLog> activityLogs = getAllService.getAllActivityLogs();
        return ResponseEntity.ok(Response.<ActivityLogResponse>builder()
                .message(CommonErrorCodes.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(ActivityLogResponse.builder().activityLogs(activityLogs).build()).build());
    }

    @GetMapping("/get-all-applicants")
    public ResponseEntity<Response<ApplicantResponse>> getAllApplicants() {
        List<ApplicantResponse.Applicant> applicantList = getAllService.getAllApplicants();
        return ResponseEntity.ok(Response.<ApplicantResponse>builder()
                .message(CommonErrorCodes.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(ApplicantResponse.builder().applicants(applicantList).build()).build());
    }
}

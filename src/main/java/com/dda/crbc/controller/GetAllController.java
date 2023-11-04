package com.dda.crbc.controller;

import com.dda.crbc.beans.request.CrbUpdateRequest;
import com.dda.crbc.beans.response.ActivityLogResponse;
import com.dda.crbc.beans.response.ApplicantResponse;
import com.dda.crbc.beans.response.RequestResponse;
import com.dda.crbc.beans.response.Response;
import com.dda.crbc.constants.CommonErrorCodes;
import com.dda.crbc.entity.CrbCheckRequest;
import com.dda.crbc.service.GetAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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

    @GetMapping("/get-all-request/{adminId}")
    public ResponseEntity<Response<RequestResponse>> getAllRequests(@PathVariable("adminId") Long adminId) {
        List<RequestResponse.Request> requestList = getAllService.getAllRequests(adminId);
        return ResponseEntity.ok(Response.<RequestResponse>builder()
                .message(CommonErrorCodes.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(RequestResponse.builder().requests(requestList).build()).build());
    }

    @GetMapping("/get-all-applicant-request/{applicantId}")
    public ResponseEntity<Response<RequestResponse>> getAllRequestsApplicant(@PathVariable("applicantId") Long applicantId) {
        List<RequestResponse.Request> requestList = getAllService.getAllRequestsApplicant(applicantId);
        return ResponseEntity.ok(Response.<RequestResponse>builder()
                .message(CommonErrorCodes.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(RequestResponse.builder().requests(requestList).build()).build());
    }

    @GetMapping("/get-new-request/{adminId}")
    public ResponseEntity<Response<RequestResponse>> getAllNewRequests(@PathVariable("adminId") Long adminId) throws ParseException {
        List<RequestResponse.Request> requestList = getAllService.getAllNewRequests(adminId);
        return ResponseEntity.ok(Response.<RequestResponse>builder()
                .message(CommonErrorCodes.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(RequestResponse.builder().requests(requestList).build()).build());
    }

    @PostMapping("/update-request")
    public ResponseEntity<Response<Long>> updateCrbRequest(@RequestBody CrbUpdateRequest crbUpdateRequest) throws ParseException {
        CrbCheckRequest updatedCrbRequest = getAllService.updateCrbRequest(crbUpdateRequest);
        return ResponseEntity.ok(Response.<Long>builder()
                .message(CommonErrorCodes.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(updatedCrbRequest.getRequestId()).build());
    }
}

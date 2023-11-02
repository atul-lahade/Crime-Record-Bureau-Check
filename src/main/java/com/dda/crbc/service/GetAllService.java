package com.dda.crbc.service;

import com.dda.crbc.beans.response.ActivityLogResponse;
import com.dda.crbc.beans.response.ApplicantResponse;
import com.dda.crbc.beans.response.CrbUserResponse;
import com.dda.crbc.beans.response.CriminalRecord;
import com.dda.crbc.entity.ActivityLog;
import com.dda.crbc.entity.Applicant;
import com.dda.crbc.reepository.ActivityLogRepository;
import com.dda.crbc.reepository.ApplicantRepository;
import com.dda.crbc.reepository.CriminalRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GetAllService {

    @Autowired
    private ActivityLogRepository activityLogRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private CriminalRecordRepository criminalRecordRepository;

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

    public List<ApplicantResponse.Applicant> getAllApplicants() {
        List<Applicant> applicantList = applicantRepository.findAll();

        List<ApplicantResponse.Applicant> applicants = new ArrayList<>();

        for (Applicant applicant: applicantList) {
            CriminalRecord criminalRecord = constructCriminalRecord(applicant);
            applicants.add(ApplicantResponse.Applicant.builder()
                    .applicantId(applicant.getApplicantId())
                    .fullName(applicant.getFullName())
                    .dateOfBirth(applicant.getDateOfBirth())
                    .gender(applicant.getGender())
                    .nationality(applicant.getNationality())
                    .contactNumber(applicant.getContactNumber())
                    .address(applicant.getAddress())
                    .identificationNumber(applicant.getIdentificationNumber())
                    .passportNumber(applicant.getPassportNumber())
                    .criminalRecord(criminalRecord)
                    .build());
        }
        return applicants;
    }

    private CriminalRecord constructCriminalRecord(Applicant applicant) {
        Optional<com.dda.crbc.entity.CriminalRecord> criminalRecord = criminalRecordRepository.findByApplicant(applicant);
        if(!criminalRecord.isPresent()){
            return null;
        }
        return CriminalRecord.builder()
                .crimeDescription(criminalRecord.get().getCrimeDescription())
                .convictionDate(criminalRecord.get().getConvictionDate())
                .severityLevel(criminalRecord.get().getSeverityLevel())
                .judicialAuthority(criminalRecord.get().getJudicialAuthority())
                .build();
    }
}

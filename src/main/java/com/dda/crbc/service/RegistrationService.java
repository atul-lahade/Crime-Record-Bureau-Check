package com.dda.crbc.service;

import com.dda.crbc.beans.request.SignInRequest;
import com.dda.crbc.beans.request.SignUpRequest;
import com.dda.crbc.beans.response.SignInResponse;
import com.dda.crbc.beans.response.SignUpResponse;
import com.dda.crbc.constants.CommonErrorCodes;
import com.dda.crbc.constants.UserType;
import com.dda.crbc.entity.Administrator;
import com.dda.crbc.entity.Applicant;
import com.dda.crbc.entity.CrbUser;
import com.dda.crbc.entity.Employer;
import com.dda.crbc.exception.ServiceException;
import com.dda.crbc.reepository.AdministratorRepository;
import com.dda.crbc.reepository.ApplicantRepository;
import com.dda.crbc.reepository.CrbUserRepository;
import com.dda.crbc.reepository.EmployerRepository;
import com.dda.crbc.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Optional;
import java.util.TimeZone;

/**
 * Registration service
 */
@Slf4j
@Service
public class RegistrationService {

    @Autowired
    private CrbUserRepository crbUserRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private CommonUtils commonUtils;

    @Transactional(rollbackFor = {Exception.class})
    public SignUpResponse signUp(SignUpRequest signUpRequest) throws NoSuchAlgorithmException, InvalidKeySpecException, ParseException {
        log.info("Sign Up Request: {}", signUpRequest);
        Applicant applicant = Applicant.builder().build();
        Employer employer = Employer.builder().build();
        Administrator administrator = Administrator.builder().build();
        CrbUser crbUser = crbUserRepository.save(constructCrbUser(signUpRequest));
        if (signUpRequest.getUserType().equals(UserType.APPLICANT.getValue())) {
            applicant = applicantRepository.save(constructApplicant(signUpRequest, crbUser));
            employer = employerRepository.save(constructEmployer(signUpRequest, crbUser));
        } else {
            administrator = administratorRepository.save(Administrator.builder()
                    .crbUser(crbUser)
                    .fullName(signUpRequest.getFullName())
                    .contactNumber(signUpRequest.getContactNumber()).build());
        }
        return SignUpResponse.builder().administratorId(administrator.getAdministratorId()).applicantId(applicant.getApplicantId()).userId(crbUser.getUserId()).employerId(employer.getEmployerId()).build();
    }

    private Employer constructEmployer(SignUpRequest signUpRequest, CrbUser crbUser) {
        return Employer.builder()
                .crbUser(crbUser)
                .companyName(signUpRequest.getCompanyDetails().getCompanyName())
                .contactPersonName(signUpRequest.getCompanyDetails().getContactPersonName())
                .industry(signUpRequest.getCompanyDetails().getIndustry())
                .contactEmail(signUpRequest.getCompanyDetails().getContactEmail())
                .contactPhone(signUpRequest.getCompanyDetails().getContactPhone()).build();
    }

    private Applicant constructApplicant(SignUpRequest signUpRequest, CrbUser crbUser) throws ParseException {
        return Applicant.builder()
                .crbUser(crbUser)
                .fullName(signUpRequest.getFullName())
                .contactNumber(signUpRequest.getContactNumber())
                .dateOfBirth(getSqlDate(signUpRequest.getDateOfBirth()))
                .gender(signUpRequest.getGender())
                .nationality(signUpRequest.getNationality())
                .address(signUpRequest.getAddress())
                .identificationNumber(signUpRequest.getIdentificationNumber())
                .passportNumber(signUpRequest.getPassportNumber()).build();
    }

    private CrbUser constructCrbUser(SignUpRequest signUpRequest) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return CrbUser.builder()
                .userType(signUpRequest.getUserType())
                .username(signUpRequest.getEmail() == null ? null : signUpRequest.getEmail().split("@")[0])
                .email(signUpRequest.getEmail())
                .passwordHash(generatePasswordHash(signUpRequest.getPassword()))
                .build();
    }

    private String generatePasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();
        return hash.toString();
    }

    private Date getSqlDate(String dateString) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));

        java.util.Date date = format.parse(dateString);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }

    public SignInResponse signIn(SignInRequest signInRequest) throws ServiceException {
        log.info("Sign in Request: {}", signInRequest);
        Optional<CrbUser> crbUserOpt = crbUserRepository.findByEmail(signInRequest.getEmail());
        if (!crbUserOpt.isPresent()) {
            throw commonUtils.buildServiceException(CommonErrorCodes.USER_NOT_FOUND, "Error while fetching user");
        }
        Administrator administrator = administratorRepository.findByCrbUser(crbUserOpt.get());
        Applicant applicant = applicantRepository.findByCrbUser(crbUserOpt.get());

        return SignInResponse.builder()
                .userName(crbUserOpt.get().getUsername())
                .userType(crbUserOpt.get().getUserType())
                .userId(crbUserOpt.get().getUserId())
                .administratorId(administrator != null ? administrator.getAdministratorId() : null)
                .applicantId(applicant != null ? applicant.getApplicantId() : null).build();
    }
}

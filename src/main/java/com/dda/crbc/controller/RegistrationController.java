package com.dda.crbc.controller;

import com.dda.crbc.beans.request.SignInRequest;
import com.dda.crbc.beans.request.SignUpRequest;
import com.dda.crbc.beans.response.Response;
import com.dda.crbc.beans.response.SignInResponse;
import com.dda.crbc.beans.response.SignUpResponse;
import com.dda.crbc.constants.CommonErrorCodes;
import com.dda.crbc.exception.ServiceException;
import com.dda.crbc.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;

/**
 * Registration endpoints.
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/sign-up")
    public ResponseEntity<Response<SignUpResponse>> signUp(@RequestBody SignUpRequest signUpRequest) throws NoSuchAlgorithmException, InvalidKeySpecException, ParseException {
        SignUpResponse signUpResponse = registrationService.signUp(signUpRequest);
        return ResponseEntity.ok(Response.<SignUpResponse>builder()
                .message(CommonErrorCodes.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(signUpResponse).build());
    }

    @PostMapping("/sign-in")
    public ResponseEntity<Response<SignInResponse>> signUp(@RequestBody SignInRequest signInRequest) throws ServiceException {
        SignInResponse signInResponse = registrationService.signIn(signInRequest);
        return ResponseEntity.ok(Response.<SignInResponse>builder()
                .message(CommonErrorCodes.SUCCESS)
                .status(HttpStatus.OK.value())
                .data(signInResponse).build());
    }
}

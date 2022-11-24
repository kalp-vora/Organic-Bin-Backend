package com.organicbin.controller;


import com.organicbin.exception.AuthenticationException;
import com.organicbin.model.Login;
import com.organicbin.model.LoginResponse;
import com.organicbin.response.ResponseHandler;
import com.organicbin.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.organicbin.response.ResponseMessageConstants.badCredentials;
import static com.organicbin.response.ResponseMessageConstants.successAuthenticate;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
        LoginResponse loginResponse;
        try {
            loginResponse = authService.authenticateUser(login);
        } catch (AuthenticationException e) {
            return ResponseHandler.generateResponse(badCredentials, HttpStatus.UNAUTHORIZED, null);
        }
        return ResponseHandler.generateResponse(successAuthenticate, HttpStatus.OK, loginResponse);

    }

}

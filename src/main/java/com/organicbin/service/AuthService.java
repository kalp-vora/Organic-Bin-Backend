package com.organicbin.service;

import com.organicbin.entity.User;
import com.organicbin.exception.AuthenticationException;
import com.organicbin.model.Login;
import com.organicbin.model.LoginResponse;
import com.organicbin.repository.UserRepository;
import com.organicbin.security.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthService(UserRepository userRepository, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public LoginResponse authenticateUser(Login login) throws AuthenticationException {
        LoginResponse loginResponse;
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.email(), login.password()));
        } catch (org.springframework.security.core.AuthenticationException e) {
            throw new AuthenticationException("BAD CREDENTIALS");
        }

        Optional<User> optionalUser = userRepository.findByEmail(login.email());
        loginResponse = new LoginResponse(optionalUser.get().getId(), optionalUser.get().getEmail(), optionalUser.get().getRole(), tokenService.generateToken(authentication));

        return loginResponse;
    }
}

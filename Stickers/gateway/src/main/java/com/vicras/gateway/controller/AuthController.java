package com.vicras.gateway.controller;

import com.vicras.gateway.dto.CredentialsDTO;
import com.vicras.gateway.exception.AuthenticationException;
import com.vicras.gateway.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

/**
 * @author viktar hraskou
 */
@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody CredentialsDTO cred) {
        try {
            return ok(authService.login(cred));
        } catch (AuthenticationException e) {
            return status(NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody CredentialsDTO cred) {
        try {
            authService.signIn(cred);
            return ok().build();
        } catch (AuthenticationException e) {

            return status(HttpStatus.CONFLICT).body("Already exist");
        }
    }
}

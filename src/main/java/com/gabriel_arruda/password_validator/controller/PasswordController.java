package com.gabriel_arruda.password_validator.controller;

import com.gabriel_arruda.password_validator.dto.PasswordValidationRequest;
import com.gabriel_arruda.password_validator.dto.PasswordValidationResponse;
import com.gabriel_arruda.password_validator.service.PasswordValidatorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/passwords")
@RequiredArgsConstructor
public class PasswordController {
    
    private final PasswordValidatorService passwordValidatorService;

    @PostMapping("/validate")
    public ResponseEntity<PasswordValidationResponse> validatePassword(
            @Valid @RequestBody PasswordValidationRequest request) {

        try {
            log.info("Received password validation request");

            PasswordValidationResponse response = passwordValidatorService
                    .validatePassword(request.getPassword());

            log.info("Password validation completed - valid: {}", response.isValid());

            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            log.error("Error during password validation", ex);
            throw ex;
        }
    }
}

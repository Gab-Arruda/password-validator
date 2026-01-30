package com.gabriel_arruda.password_validator.service;

import com.gabriel_arruda.password_validator.dto.PasswordValidationResponse;

public interface PasswordValidatorService {
    PasswordValidationResponse validatePassword(String password);
}

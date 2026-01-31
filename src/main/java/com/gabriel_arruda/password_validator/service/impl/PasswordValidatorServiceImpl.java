package com.gabriel_arruda.password_validator.service.impl;

import com.gabriel_arruda.password_validator.dto.PasswordValidationResponse;
import com.gabriel_arruda.password_validator.service.PasswordValidatorService;
import com.gabriel_arruda.password_validator.validator.PasswordRule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PasswordValidatorServiceImpl implements PasswordValidatorService {
    
    private final List<PasswordRule> validationRules;

    @Override
    public PasswordValidationResponse validatePassword(String password) {
        List<String> errors = new ArrayList<>();

        for (PasswordRule rule : validationRules) {
            if (!rule.validate(password)) {
                errors.add(rule.getFailureMessage());
            }
        }
        if (!errors.isEmpty()) {
            log.info("Password validation failed: {}", String.join(", ", errors));
        } else {
            log.info("Password validation succeeded");
        }

        return new PasswordValidationResponse(errors.isEmpty());
    }
}

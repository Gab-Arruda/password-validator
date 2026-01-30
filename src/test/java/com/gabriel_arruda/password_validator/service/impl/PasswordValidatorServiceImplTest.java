package com.gabriel_arruda.password_validator.service.impl;

import com.gabriel_arruda.password_validator.dto.PasswordValidationResponse;
import com.gabriel_arruda.password_validator.validator.PasswordRule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorServiceImplTest {

    @Test
    void returns_false_when_any_rule_fails() {
        PasswordRule failingRule = new PasswordRule() {
            @Override
            public boolean validate(String password) {
                return false;
            }

            @Override
            public String getFailureMessage() {
                return "rule failed";
            }
        };

        PasswordRule passingRule = new PasswordRule() {
            @Override
            public boolean validate(String password) {
                return true;
            }

            @Override
            public String getFailureMessage() {
                return "rule failed";
            }
        };

        List<PasswordRule> rules = Arrays.asList(passingRule, failingRule);
        PasswordValidatorServiceImpl service = new PasswordValidatorServiceImpl(rules);

        PasswordValidationResponse response = service.validatePassword("styfgku");
        assertFalse(response.isValid());
    }

    @Test
    void retorns_true_when_all_rules_are_ok() {
        PasswordRule passingRule1 = new PasswordRule() {
            @Override
            public boolean validate(String password) { return true; }
            @Override
            public String getFailureMessage() { return "rule failed"; }
        };
        PasswordRule passingRule2 = new PasswordRule() {
            @Override
            public boolean validate(String password) { return true; }
            @Override
            public String getFailureMessage() { return "rule failed"; }
        };

        PasswordValidatorServiceImpl service = new PasswordValidatorServiceImpl(Arrays.asList(passingRule1, passingRule2));
        PasswordValidationResponse response = service.validatePassword("jholkjhd");
        assertTrue(response.isValid());
    }
}

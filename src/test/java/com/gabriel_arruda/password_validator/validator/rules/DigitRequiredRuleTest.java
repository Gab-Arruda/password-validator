package com.gabriel_arruda.password_validator.validator.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitRequiredRuleTest {

    private final DigitRequiredRule rule = new DigitRequiredRule();

    @Test
    void returns_true_when_password_contains_digit() {
        assertTrue(rule.validate("abc1"));
    }

    @Test
    void returns_false_when_password_does_not_contain_digit() {
        assertFalse(rule.validate("abc"));
    }
}

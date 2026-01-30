package com.gabriel_arruda.password_validator.validator.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumLengthRuleTest {

    private final MinimumLengthRule rule = new MinimumLengthRule();

    @Test
    void returns_true_when_minimum_length_exists() {
        assertTrue(rule.validate("123456789"));
    }

    @Test
    void returns_false_when_minimum_length_does_not_exist() {
        assertFalse(rule.validate("1234"));
    }
}

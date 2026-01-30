package com.gabriel_arruda.password_validator.validator.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotEmptyRequiredRuleTest {

    private final NotEmptyRequiredRule rule = new NotEmptyRequiredRule();

    @Test
    void returns_true_when_password_not_empty() {
        assertTrue(rule.validate("zxs"));
    }

    @Test
    void returns_false_when_password_empty() {
        assertFalse(rule.validate(""));
    }
}

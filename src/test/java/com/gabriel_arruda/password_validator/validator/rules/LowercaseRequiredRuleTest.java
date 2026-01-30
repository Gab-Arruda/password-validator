package com.gabriel_arruda.password_validator.validator.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowercaseRequiredRuleTest {

    private final LowercaseRequiredRule rule = new LowercaseRequiredRule();

    @Test
    void returns_true_when_password_contains_lowercase() {
        assertTrue(rule.validate("ABCd"));
    }

    @Test
    void returns_false_when_password_does_not_contain_lowercase() {
        assertFalse(rule.validate("ABC"));
    }
}

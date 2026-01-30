package com.gabriel_arruda.password_validator.validator.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UppercaseRequiredRuleTest {

    private final UppercaseRequiredRule rule = new UppercaseRequiredRule();

    @Test
    void returns_true_when_password_contains_uppercase() {
        assertTrue(rule.validate("Afgssd"));
    }

    @Test
    void returns_false_when_password_does_not_contain_uppercase() {
        assertFalse(rule.validate("asgeh"));
    }
}

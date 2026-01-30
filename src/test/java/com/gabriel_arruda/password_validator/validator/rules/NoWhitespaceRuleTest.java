package com.gabriel_arruda.password_validator.validator.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoWhitespaceRuleTest {

    private final NoWhitespaceRule rule = new NoWhitespaceRule();

    @Test
    void returns_true_when_password_does_not_contain_whitespaces() {
        assertTrue(rule.validate("sergt"));
    }

    @Test
    void returns_false_when_password_contains_whitespaces() {
        assertFalse(rule.validate("a bgyh"));
    }
}

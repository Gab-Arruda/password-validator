package com.gabriel_arruda.password_validator.validator.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialCharacterRequiredRuleTest {

    private final SpecialCharacterRequiredRule rule = new SpecialCharacterRequiredRule();

    @Test
    void returns_true_when_password_contains_special_character() {
        assertTrue(rule.validate("abc!"));
    }

    @Test
    void returns_false_when_password_does_not_contain_special_character() {
        assertFalse(rule.validate("abc"));
    }
}

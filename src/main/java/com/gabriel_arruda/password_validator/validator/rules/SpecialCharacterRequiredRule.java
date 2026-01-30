package com.gabriel_arruda.password_validator.validator.rules;

import com.gabriel_arruda.password_validator.validator.PasswordRule;

import java.util.Set;

public class SpecialCharacterRequiredRule implements PasswordRule {
    
    private static final Set<Character> SPECIAL_CHARACTERS = Set.of(
        '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'
    );
    
    @Override
    public boolean validate(String password) {
        return password.chars()
                .mapToObj(c -> (char) c)
                .anyMatch(SPECIAL_CHARACTERS::contains);
    }
    
    @Override
    public String getFailureMessage() {
        return "Password must contain at least one special character: " + SPECIAL_CHARACTERS;
    }
}

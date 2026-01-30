package com.gabriel_arruda.password_validator.validator.rules;

import com.gabriel_arruda.password_validator.validator.PasswordRule;

public class NoWhitespaceRule implements PasswordRule {
    
    @Override
    public boolean validate(String password) {
        return password.chars().noneMatch(Character::isWhitespace);
    }
    
    @Override
    public String getFailureMessage() {
        return "Password must not contain whitespace characters";
    }
}

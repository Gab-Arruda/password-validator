package com.gabriel_arruda.password_validator.validator.rules;

import com.gabriel_arruda.password_validator.validator.PasswordRule;

public class DigitRequiredRule implements PasswordRule {
    
    @Override
    public boolean validate(String password) {
        return password.chars().anyMatch(Character::isDigit);
    }
    
    @Override
    public String getFailureMessage() {
        return "Password must contain at least one digit (0-9)";
    }
}

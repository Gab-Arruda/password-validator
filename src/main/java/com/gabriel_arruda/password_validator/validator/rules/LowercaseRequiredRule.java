package com.gabriel_arruda.password_validator.validator.rules;

import com.gabriel_arruda.password_validator.validator.PasswordRule;

public class LowercaseRequiredRule implements PasswordRule {
    
    @Override
    public boolean validate(String password) {
        return password.chars().anyMatch(Character::isLowerCase);
    }
    
    @Override
    public String getFailureMessage() {
        return "Password must contain at least one lowercase letter (a-z)";
    }
}

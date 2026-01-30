package com.gabriel_arruda.password_validator.validator.rules;

import com.gabriel_arruda.password_validator.validator.PasswordRule;

public class MinimumLengthRule implements PasswordRule {
    
    private static final int MINIMUM_LENGTH = 9;
    
    @Override
    public boolean validate(String password) {
        return password.length() >= MINIMUM_LENGTH;
    }
    
    @Override
    public String getFailureMessage() {
        return "Password must have at least " + MINIMUM_LENGTH + " characters.";
    }
}

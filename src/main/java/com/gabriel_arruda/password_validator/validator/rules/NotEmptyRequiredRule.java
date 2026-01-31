package com.gabriel_arruda.password_validator.validator.rules;

import com.gabriel_arruda.password_validator.validator.PasswordRule;

public class NotEmptyRequiredRule implements PasswordRule {
    @Override
    public boolean validate(String password) {
        return !password.isEmpty();
    }

    @Override
    public String getFailureMessage() { return "Password must not be empty"; }
}

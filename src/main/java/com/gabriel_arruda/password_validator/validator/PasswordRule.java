package com.gabriel_arruda.password_validator.validator;


public interface PasswordRule {
    boolean validate(String password);

    String getFailureMessage();
}

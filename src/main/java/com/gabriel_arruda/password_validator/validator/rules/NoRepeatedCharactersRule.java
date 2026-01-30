package com.gabriel_arruda.password_validator.validator.rules;

import com.gabriel_arruda.password_validator.validator.PasswordRule;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatedCharactersRule implements PasswordRule {
    
    @Override
    public boolean validate(String password) {
        Set<Character> charactersAlreadyChecked = new HashSet<>();
        
        for (char c : password.toCharArray()) {
            if (!charactersAlreadyChecked.add(c)) {
                return false;
            }
        }
        
        return true;
    }
    
    @Override
    public String getFailureMessage() {
        return "Password cannot contain repeated characters";
    }
}

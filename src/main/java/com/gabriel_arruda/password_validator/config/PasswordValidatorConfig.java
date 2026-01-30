package com.gabriel_arruda.password_validator.config;

import com.gabriel_arruda.password_validator.validator.PasswordRule;
import com.gabriel_arruda.password_validator.validator.rules.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PasswordValidatorConfig {
    @Bean
    public List<PasswordRule> validationRules() {
        return List.of(
            new NotEmptyRequiredRule(),
            new MinimumLengthRule(),
            new DigitRequiredRule(),
            new LowercaseRequiredRule(),
            new UppercaseRequiredRule(),
            new SpecialCharacterRequiredRule(),
            new NoRepeatedCharactersRule(),
            new NoWhitespaceRule()
        );
    }
}

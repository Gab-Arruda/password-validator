package com.gabriel_arruda.password_validator.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordValidationRequest {
    
    @NotNull(message = "Password cannot be null")
    private String password;
}

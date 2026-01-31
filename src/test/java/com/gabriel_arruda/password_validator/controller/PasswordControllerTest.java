package com.gabriel_arruda.password_validator.controller;

import com.gabriel_arruda.password_validator.dto.PasswordValidationResponse;
import com.gabriel_arruda.password_validator.exception.GlobalExceptionHandler;
import com.gabriel_arruda.password_validator.service.PasswordValidatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PasswordControllerTest {

    private MockMvc mockMvc;
    private PasswordValidatorService passwordValidatorService;

    @BeforeEach
    void setup() {
        passwordValidatorService = mock(PasswordValidatorService.class);
        PasswordController controller = new PasswordController(passwordValidatorService);

        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.afterPropertiesSet();

        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new GlobalExceptionHandler())
                .setValidator(validator)
                .build();
    }

    @Test
    void returns_400_bad_request_when_password_is_null() throws Exception {
        String body = "{\"password\": null}";

        mockMvc.perform(post("/api/v1/password/validate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Password cannot be null"));
    }

    @Test
    void returns_false_for_invalid_password() throws Exception {
        when(passwordValidatorService.validatePassword(anyString()))
                .thenReturn(new PasswordValidationResponse(false));

        String body = "{\"password\": \"invalid\"}";

        mockMvc.perform(post("/api/v1/password/validate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(false));
    }

    @Test
    void returns_true_for_valid_password() throws Exception {
        when(passwordValidatorService.validatePassword(anyString()))
                .thenReturn(new PasswordValidationResponse(true));

        String body = "{\"password\": \"Abcd@12344\"}";

        mockMvc.perform(post("/api/v1/password/validate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.valid").value(true));
    }
}

package com.management.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LoginDTO {

    @Email(message = "Email must be valid")
    private String email;

    @Pattern(regexp = "/^(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_])[A-Za-z\\d\\W_]{6,}$/", message = "Password must have at least 6 characters, one symbol, one number, and one uppercase letter.")
    private String password;

}

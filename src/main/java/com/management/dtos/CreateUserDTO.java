package com.management.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateUserDTO {

    @NotEmpty(message = "Names cannot be empty")
    private String names;

    @Email(message = "Email must be valid")
    private String email;

    @Pattern(regexp = "/^\\+250\\d{9}$/", message = "Telephone starts with +250 and has 9 digits after.")
    private String telephone;

    @Pattern(regexp = "/^(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_])[A-Za-z\\d\\W_]{6,}$/", message = "Password must have at least 6 characters, one symbol, one number, and one uppercase letter.")
    private String password;

}

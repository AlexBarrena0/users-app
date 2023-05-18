package edu.uoc.abarrena.users.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    @NotBlank(message = "Username is required")
    @Max(value = 20, message = "Username must be less than 20 characters")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;
}

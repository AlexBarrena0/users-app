package edu.uoc.abarrena.users.infrastructure.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateCompanyDto extends CreateUserDto {

    @NotBlank(message = "CIF is required")
    @Max(value = 9, message = "CIF must be 9 characters")
    @Min(value = 9, message = "CIF must be 9 characters")
    private String CIF;

    @NotBlank(message = "Name is required")
    @Max(value = 50, message = "Name must be less than 50 characters")
    private String name;

    @NotBlank(message = "Address is required")
    @Max(value = 255, message = "Address must be less than 255 characters")
    private String address;

    @Max(value = 5000, message = "Description must be less than 5000 characters")
    private String description;

    @Max(value = 9, message = "Phone must be 9 characters")
    private String phone;

    @Email(message = "Email should be valid")
    @Max(value = 50, message = "Email must be less than 50 characters")
    private String email;
}

package edu.uoc.abarrena.users.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDiveDiaryDto {

    @NotBlank(message = "Date is required")
    private LocalDate date;
    @NotBlank(message = "Time is required")
    private LocalTime time;
    @NotBlank(message = "Spot is required")
    @Max(value = 50, message = "Spot must be less than 50 characters")
    private String spot;
    @Min(value = 0, message = "Max depth must be greater than 0")
    private Double maxDepth;
    private Double temperature;
    @Min(value = 0, message = "Visibility must be greater than 0")
    private Integer visibility;
    @Min(value = 0, message = "O2 percentage must be greater than 0")
    private Integer o2Percentage;
    @Min(value = 0, message = "Air in must be greater than 0")
    private Integer airIn;
    @Min(value = 0, message = "Air out must be greater than 0")
    private Integer airOut;
    private String comment;
    private Long travelerId;
}

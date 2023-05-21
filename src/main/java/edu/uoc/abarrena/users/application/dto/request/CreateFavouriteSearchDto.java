package edu.uoc.abarrena.users.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFavouriteSearchDto {
    private String startDate;
    private String endDate;
    private Long destinationId;
    @NotBlank(message = "Traveler id is required")
    private Long travelerId;
}

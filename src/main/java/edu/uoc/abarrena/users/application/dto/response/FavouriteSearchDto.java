package edu.uoc.abarrena.users.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FavouriteSearchDto {

    private Long id;
    private String startDate;
    private String endDate;
    private Long destinationId;
}

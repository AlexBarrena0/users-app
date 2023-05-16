package edu.uoc.abarrena.users.infrastructure.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDiveDiaryDto {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private String spot;
    private Double maxDepth;
    private Double temperature;
    private Integer visibility;
    private Integer o2Percentage;
    private Integer airIn;
    private Integer airOut;
    private String comment;
    private Long travelerId;
}

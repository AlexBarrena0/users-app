package edu.uoc.abarrena.users.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiveDiary {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private String spot;
    private Integer duration;
    private Double maxDepth;
    private Double temperature;
    private Integer visibility;
    private Integer o2Percentage;
    private Integer airIn;
    private Integer airOut;
    private String comment;
    private Traveler traveler;
    private List<Long> imagesIds;
}

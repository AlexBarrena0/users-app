package edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity;

import edu.uoc.abarrena.users.domain.model.Traveler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteSearchEntity {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long destinationId;
    private Traveler traveler;
}

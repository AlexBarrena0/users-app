package edu.uoc.abarrena.users.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteSearch {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long destinationId;
    private Traveler traveler;

    public FavouriteSearch(LocalDate startDate, LocalDate endDate, Long destinationId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.destinationId = destinationId;
    }
}

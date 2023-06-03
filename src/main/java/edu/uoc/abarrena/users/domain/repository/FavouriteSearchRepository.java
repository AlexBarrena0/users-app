package edu.uoc.abarrena.users.domain.repository;

import edu.uoc.abarrena.users.domain.model.FavouriteSearch;

import java.util.List;

public interface FavouriteSearchRepository {

    Long save(FavouriteSearch favouriteSearch);

    List<FavouriteSearch> findByUserId(Long id);

    void delete(Long id);

    List<Long> findUsersByDestinationIdAndDates(FavouriteSearch favouriteSearch);
}

package edu.uoc.abarrena.users.domain.repository;

import edu.uoc.abarrena.users.domain.model.FavouriteSearch;

public interface FavouriteSearchRepository {

    public Long save(FavouriteSearch favouriteSearch);

    public void delete(Long id);
}

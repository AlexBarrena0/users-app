package edu.uoc.abarrena.users.domain.repository;

import edu.uoc.abarrena.users.domain.model.FavouriteSearch;

import java.util.List;

public interface FavouriteSearchRepository {

    public Long save(FavouriteSearch favouriteSearch);

    public List<FavouriteSearch> findByUserId(Long id);

    public void delete(Long id);
}

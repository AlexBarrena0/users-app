package edu.uoc.abarrena.users.application;

import edu.uoc.abarrena.users.domain.model.FavouriteSearch;

import java.util.List;

public interface FavouriteSearchService {

    /**
     * Creates a new favourite search
     * @param favouriteSearch to create
     * @return the id of the created favourite search
     */
    public Long createFavouriteSearch(FavouriteSearch favouriteSearch);

    /**
     * Finds a favourite search by its user id
     * @param id of the user to find
     * @return the list of favourite search with the given user id
     */
    public List<FavouriteSearch> findFavouriteSearchByUserId(Long id);

    /**
     * Removes a favourite search
     * @param id of the favourite search to remove
     */
    public void removeFavouriteSearch(Long id);
}

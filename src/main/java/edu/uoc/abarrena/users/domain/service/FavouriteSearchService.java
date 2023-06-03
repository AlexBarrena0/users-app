package edu.uoc.abarrena.users.domain.service;

import edu.uoc.abarrena.users.domain.exceptions.EntityNotFoundException;
import edu.uoc.abarrena.users.domain.model.FavouriteSearch;

import java.util.List;

public interface FavouriteSearchService {

    /**
     * Creates a new favourite search
     *
     * @param favouriteSearch to create
     * @return the id of the created favourite search
     */
    Long createFavouriteSearch(FavouriteSearch favouriteSearch) throws EntityNotFoundException;

    /**
     * Finds a favourite search by its user id
     *
     * @param id of the user to find
     * @return the list of favourite search with the given user id
     */
    List<FavouriteSearch> findFavouriteSearchByUserId(Long id);

    /**
     * Removes a favourite search
     *
     * @param id of the favourite search to remove
     */
    void deleteFavouriteSearch(Long id);

    /**
     * Finds a favourite search by its parameters
     *
     * @param favouriteSearch to find
     * @return the list of favourite search with the given parameters
     */
    List<Long> findFavouriteSearchUsersByDestinationIdAndDates(FavouriteSearch favouriteSearch);
}

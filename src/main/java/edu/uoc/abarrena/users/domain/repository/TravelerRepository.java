package edu.uoc.abarrena.users.domain.repository;

import edu.uoc.abarrena.users.domain.model.Traveler;

public interface TravelerRepository {

    /**
     * Save a traveler
     *
     * @param traveler to save
     * @return the id of the saved traveler
     */
    Long save(Traveler traveler);

    /**
     * Update a traveler
     *
     * @param traveler the traveler to update
     */
    void update(Traveler traveler);

    /**
     * Finds a traveler by its id
     *
     * @param id of the traveler to find
     * @return the traveler with the given id
     */
    Traveler findById(Long id);
}

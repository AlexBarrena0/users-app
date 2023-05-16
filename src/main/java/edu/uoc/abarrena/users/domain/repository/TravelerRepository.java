package edu.uoc.abarrena.users.domain.repository;

import edu.uoc.abarrena.users.domain.model.Traveler;

public interface TravelerRepository {

    /**
     * Save a traveler
     * @param traveler to save
     * @return the id of the saved traveler
     */
    public Long save(Traveler traveler);

    /**
     * Finds a traveler by its id
     * @param id of the traveler to find
     * @return the traveler with the given id
     */
    public Traveler findById(Long id);
}

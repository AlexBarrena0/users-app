package edu.uoc.abarrena.users.application;

import edu.uoc.abarrena.users.domain.exceptions.DuplicateUserException;
import edu.uoc.abarrena.users.domain.model.Traveler;
import edu.uoc.abarrena.users.domain.model.User;

public interface TravelerService {

    /**
     * Creates a new traveler
     * @param traveler to create
     * @return the id of the created traveler
     */
    public Long createTraveler(Traveler traveler) throws DuplicateUserException;

    /**
     * Finds a traveler by its id
     * @param id of the traveler to find
     * @return the traveler with the given id
     */
    public Traveler findTravelerById(Long id);

    /**
     * Updates a traveler
     * @param traveler the traveler to update
     */
    public void updateTraveler(Traveler traveler);
}

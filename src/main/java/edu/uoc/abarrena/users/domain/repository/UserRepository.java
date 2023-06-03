package edu.uoc.abarrena.users.domain.repository;

import edu.uoc.abarrena.users.domain.model.User;

public interface UserRepository {

    /**
     * Finds a user by its username
     *
     * @param username of the user to find
     * @return the user with the given username
     */
    User findByUsername(String username);

    /**
     * Deletes a user
     *
     * @param id of the user to delete
     */
    void delete(Long id);
}

package edu.uoc.abarrena.users.domain.service;

import edu.uoc.abarrena.users.domain.model.User;

public interface UserService {

    /**
     * Login a user
     *
     * @param user to login
     * @return the token of the user
     */
    String login(User user);

    /**
     * Finds a user by its username
     *
     * @param username of the user to find
     * @return the user with the given username
     */
    User findUserByUsername(String username);

    /**
     * Deletes a user
     *
     * @param id of the user to delete
     */
    void deleteUser(Long id);
}

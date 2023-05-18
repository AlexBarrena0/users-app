package edu.uoc.abarrena.users.domain.service;

import edu.uoc.abarrena.users.domain.exceptions.DuplicateUserException;
import edu.uoc.abarrena.users.domain.model.Company;
import edu.uoc.abarrena.users.domain.model.User;

public interface CompanyService {

    /**
     * Creates a new company
     * @param company to create
     * @return the id of the created company
     */
    public Long createCompany(Company company) throws DuplicateUserException;

    /**
     * Updates a company
     * @param company the company to update
     */
    public void updateCompany(Company company);
}

package edu.uoc.abarrena.users.domain.service;

import edu.uoc.abarrena.users.domain.exceptions.DuplicateUserException;
import edu.uoc.abarrena.users.domain.model.Company;

public interface CompanyService {

    /**
     * Creates a new company
     *
     * @param company to create
     * @return the id of the created company
     */
    Long createCompany(Company company) throws DuplicateUserException;

    /**
     * Finds a company by its id
     *
     * @param id the id of the company to find
     * @return the company or null if not found
     */
    Company findCompanyById(Long id);

    /**
     * Updates a company
     *
     * @param company the company to update
     */
    void updateCompany(Company company);
}

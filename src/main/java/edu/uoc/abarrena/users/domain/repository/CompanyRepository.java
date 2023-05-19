package edu.uoc.abarrena.users.domain.repository;

import edu.uoc.abarrena.users.domain.model.Company;

public interface CompanyRepository {

    /**
     * Save a company
     * @param company to save
     * @return the id of the saved company
     */
    public Long save(Company company);

    /**
     * Find a company by id
     * @param id the id of the company
     * @return the company
     */
    public Company findById(Long id);

    /**
     * Updates a company
     * @param company the company to update
     */
    public void update(Company company);
}

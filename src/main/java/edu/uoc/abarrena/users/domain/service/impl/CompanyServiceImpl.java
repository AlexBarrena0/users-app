package edu.uoc.abarrena.users.domain.service.impl;

import edu.uoc.abarrena.users.domain.exceptions.DuplicateUserException;
import edu.uoc.abarrena.users.domain.model.Company;
import edu.uoc.abarrena.users.domain.model.Role;
import edu.uoc.abarrena.users.domain.model.User;
import edu.uoc.abarrena.users.domain.repository.CompanyRepository;
import edu.uoc.abarrena.users.domain.service.CompanyService;
import edu.uoc.abarrena.users.domain.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final UserService userService;

    public CompanyServiceImpl(CompanyRepository companyRepository, UserService userService) {
        this.companyRepository = companyRepository;
        this.userService = userService;
    }

    @Override
    public Long createCompany(Company company) throws DuplicateUserException {
        User user = userService.findUserByUsername(company.getUsername());
        if (user != null) {
            throw new DuplicateUserException();
        }
        company.setRole(Role.COMPANY.name());
        return companyRepository.save(company);
    }

    @Override
    public Company findCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public void updateCompany(Company company) {
        companyRepository.update(company);
    }
}

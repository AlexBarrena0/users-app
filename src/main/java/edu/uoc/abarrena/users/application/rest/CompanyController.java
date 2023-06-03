package edu.uoc.abarrena.users.application.rest;

import edu.uoc.abarrena.users.application.dto.request.CreateCompanyDto;
import edu.uoc.abarrena.users.application.dto.request.UpdateCompanyDto;
import edu.uoc.abarrena.users.application.dto.response.CompanyDto;
import edu.uoc.abarrena.users.application.dto.response.Result;
import edu.uoc.abarrena.users.domain.converter.CompanyConverter;
import edu.uoc.abarrena.users.domain.service.CompanyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Log4j2
@RestController
@RequestMapping(CompanyController.BASE_PATH)
public class CompanyController {

    public static final String BASE_PATH = "/companies";

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public Result<Long> createCompany(@Valid @RequestBody CreateCompanyDto createCompanyDto) {
        log.trace("Creating company " + createCompanyDto);

        Long companyId = companyService.createCompany(CompanyConverter.INSTANCE.toDomain(createCompanyDto));

        return new Result<Long>(companyId, "Company created successfully");
    }

    @GetMapping("/{id}")
    public Result<CompanyDto> findCompanyById(@PathVariable Long id) {
        log.trace("Finding company by id " + id);

        CompanyDto companyDto = CompanyConverter.INSTANCE.toDto(companyService.findCompanyById(id));

        return new Result<CompanyDto>(companyDto, "Company found successfully");
    }

    @PutMapping("/{id}")
    public Result<Boolean> updateCompany(@Valid @RequestBody UpdateCompanyDto updateCompanyDto) {
        log.trace("Updating company " + updateCompanyDto);

        companyService.updateCompany(CompanyConverter.INSTANCE.toDomain(updateCompanyDto));

        return new Result<Boolean>(true, "Company updated successfully");
    }
}

package edu.uoc.abarrena.users.application.rest;

import edu.uoc.abarrena.users.application.dto.request.CreateCompanyDto;
import edu.uoc.abarrena.users.domain.service.CompanyService;
import edu.uoc.abarrena.users.domain.converter.CompanyConverter;
import edu.uoc.abarrena.users.application.dto.response.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result<Long> createCompany(@RequestBody CreateCompanyDto createCompanyDto) {
        log.trace("Creating company " + createCompanyDto);

        Long companyId = companyService.createCompany(CompanyConverter.INSTANCE.toDomain(createCompanyDto));

        return new Result<Long>(companyId, "Company created successfully");
    }
}

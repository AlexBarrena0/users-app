package edu.uoc.abarrena.users.domain.converter;

import edu.uoc.abarrena.users.application.dto.request.UpdateCompanyDto;
import edu.uoc.abarrena.users.application.dto.response.CompanyDto;
import edu.uoc.abarrena.users.domain.model.Company;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.CompanyEntity;
import edu.uoc.abarrena.users.application.dto.request.CreateCompanyDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyConverter {

    public static final CompanyConverter INSTANCE = Mappers.getMapper(CompanyConverter.class);

    Company toDomain(CreateCompanyDto createCompanyDto);
    Company toDomain(UpdateCompanyDto updateCompanyDto);
    Company toDomain(CompanyEntity companyEntity);
    CompanyEntity toEntity(Company company);
    CompanyDto toDto(Company company);

}

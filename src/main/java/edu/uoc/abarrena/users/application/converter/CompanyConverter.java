package edu.uoc.abarrena.users.application.converter;

import edu.uoc.abarrena.users.domain.model.Company;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.CompanyEntity;
import edu.uoc.abarrena.users.infrastructure.rest.dto.request.CreateCompanyDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyConverter {

    public static final CompanyConverter INSTANCE = Mappers.getMapper(CompanyConverter.class);

    Company toDomain(CreateCompanyDto createCompanyDto);
    CompanyEntity toEntity(Company company);

}

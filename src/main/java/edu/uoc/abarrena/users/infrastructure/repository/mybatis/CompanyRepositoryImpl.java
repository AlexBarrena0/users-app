package edu.uoc.abarrena.users.infrastructure.repository.mybatis;

import edu.uoc.abarrena.users.domain.converter.CompanyConverter;
import edu.uoc.abarrena.users.domain.model.Company;
import edu.uoc.abarrena.users.domain.repository.CompanyRepository;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.CompanyEntity;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.mapper.CompanyMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {

    private final CompanyMapper companyMapper;

    public CompanyRepositoryImpl(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }

    @Override
    public Long save(Company company) {
        CompanyEntity companyEntity = CompanyConverter.INSTANCE.toEntity(company);
        companyMapper.save(companyEntity);
        return companyEntity.getId();
    }

    @Override
    public Company findById(Long id) {
        return CompanyConverter.INSTANCE.toDomain(companyMapper.findById(id));
    }

    @Override
    public void update(Company company) {
        CompanyEntity companyEntity = CompanyConverter.INSTANCE.toEntity(company);
        companyMapper.update(companyEntity);
    }
}

package edu.uoc.abarrena.users.infrastructure.repository.mybatis.mapper;

import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.CompanyEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CompanyMapper {

    @Insert("INSERT INTO COMPANY(ROLE, USERNAME, PASSWORD, CIF, NAME, ADDRESS, DESCRIPTION, PHONE, EMAIL) " +
            "VALUES (#{role}, #{username}, #{password}, #{cif}, #{name}, #{address}, #{description}, #{phone}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void save(CompanyEntity companyEntity);

    @Select("SELECT * FROM COMPANY WHERE ID = #{id}")
    CompanyEntity findById(Long id);

    @Update("UPDATE COMPANY SET CIF = #{cif}, NAME = #{name}, ADDRESS = #{address}, DESCRIPTION = #{description}, PHONE = #{phone}, EMAIL = #{email} WHERE ID = #{id}")
    void update(CompanyEntity companyEntity);
}

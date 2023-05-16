package edu.uoc.abarrena.users.infrastructure.repository.mybatis.mapper;

import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.CompanyEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CompanyMapper {

    @Insert("INSERT INTO COMPANY(ROLE, USERNAME, PASSWORD, CIF, NAME, ADDRESS, DESCRIPTION, PHONE, EMAIL) " +
            "VALUES (#{role}, #{username}, #{password}, #{CIF}, #{name}, #{address}, #{description}, #{phone}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public void save(CompanyEntity companyEntity);

    @Update("UPDATE COMPANY SET CIF = #{CIF}, NAME = #{name}, ADDRESS = #{address}, DESCRIPTION = #{description}, PHONE = #{phone}, EMAIL = #{email} WHERE ID = #{id}")
    public void update(CompanyEntity companyEntity);
}

package edu.uoc.abarrena.users.infrastructure.repository.mybatis.mapper;

import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.TravelerEntity;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.provider.TravelerEntitySqlProvider;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TravelerMapper {

    @Insert("INSERT INTO TRAVELER(ROLE, USERNAME, PASSWORD) VALUES (#{role}, #{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void save(TravelerEntity travelerEntity);

    @UpdateProvider(type = TravelerEntitySqlProvider.class, method = "update")
    void update(TravelerEntity travelerEntity);

    @Results(id = "travelerResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "divingCertificationId", column = "diving_certification_id"),
            @Result(property = "divingInsuranceId", column = "diving_insurance_id"),
            @Result(property = "medicalCertificateId", column = "medical_certificate_id")
    })
    @Select("SELECT * FROM TRAVELER WHERE ID = #{id}")
    TravelerEntity findById(Long id);

}

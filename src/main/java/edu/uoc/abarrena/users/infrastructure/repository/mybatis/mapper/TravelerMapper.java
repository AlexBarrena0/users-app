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

    @Select("SELECT * FROM TRAVELER WHERE ID = #{id}")
    TravelerEntity findById(Long id);

}

package edu.uoc.abarrena.users.infrastructure.repository.mybatis.mapper;

import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.TravelerEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TravelerMapper {

    @Insert("INSERT INTO TRAVELER(ROLE, USERNAME, PASSWORD) VALUES (#{role}, #{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public void save(TravelerEntity travelerEntity);

    @Select("SELECT * FROM TRAVELER WHERE ID = #{id}")
    public TravelerEntity findById(Long id);

}

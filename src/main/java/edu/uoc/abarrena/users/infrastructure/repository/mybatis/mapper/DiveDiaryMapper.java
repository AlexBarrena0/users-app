package edu.uoc.abarrena.users.infrastructure.repository.mybatis.mapper;

import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.DiveDiaryEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DiveDiaryMapper {
    @Insert("INSERT INTO DIVE_DIARY(DATE, TIME, SPOT, MAX_DEPTH, TEMPERATURE, VISIBILITY, O2_PERCENTAGE, AIR_IN, AIR_OUT, COMMENT, TRAVELER_ID) " +
        "VALUES (#{date}, #{time}, #{spot}, #{maxDepth}, #{temperature}, #{visibility}, #{o2Percentage}, #{airIn}, #{airOut}, #{comment}, #{traveler.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public void save(DiveDiaryEntity diveDiaryEntity);

    @Select("SELECT * FROM DIVE_DIARY WHERE TRAVELER_ID = #{id}")
    public List<DiveDiaryEntity> findByUserId(Long id);
}

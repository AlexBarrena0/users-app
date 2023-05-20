package edu.uoc.abarrena.users.infrastructure.repository.mybatis.mapper;

import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.DiveDiaryEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DiveDiaryMapper {
    @Insert("INSERT INTO DIVE_DIARY(DATE, TIME, SPOT, MAX_DEPTH, TEMPERATURE, VISIBILITY, O2_PERCENTAGE, AIR_IN, AIR_OUT, COMMENT, TRAVELER_ID) " +
        "VALUES (#{date}, #{time}, #{spot}, #{maxDepth}, #{temperature}, #{visibility}, #{o2Percentage}, #{airIn}, #{airOut}, #{comment}, #{traveler.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public void save(DiveDiaryEntity diveDiaryEntity);

    @Results(id = "diveDiaryResultMap", value = {
        @Result(property = "id", column = "id"),
        @Result(property = "date", column = "date"),
        @Result(property = "time", column = "time"),
        @Result(property = "spot", column = "spot"),
        @Result(property = "maxDepth", column = "max_depth"),
        @Result(property = "temperature", column = "temperature"),
        @Result(property = "visibility", column = "visibility"),
        @Result(property = "o2Percentage", column = "o2_percentage"),
        @Result(property = "airIn", column = "air_in"),
        @Result(property = "airOut", column = "air_out"),
        @Result(property = "comment", column = "comment")
    })
    @Select("SELECT * FROM DIVE_DIARY WHERE TRAVELER_ID = #{id}")
    public List<DiveDiaryEntity> findByUserId(Long id);
}

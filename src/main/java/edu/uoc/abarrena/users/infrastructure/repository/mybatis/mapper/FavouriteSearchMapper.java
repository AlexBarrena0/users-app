package edu.uoc.abarrena.users.infrastructure.repository.mybatis.mapper;

import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.FavouriteSearchEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FavouriteSearchMapper {

    @Insert("INSERT INTO FAVOURITE_SEARCH (START_DATE, END_DATE, DESTINATION_ID, TRAVELER_ID) VALUES (#{startDate}, #{endDate}, #{destinationId}, #{traveler.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public void save(FavouriteSearchEntity favouriteSearchEntity);

    @Results(id = "favouriteSearchResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "startDate", column = "start_date"),
            @Result(property = "endDate", column = "end_date"),
            @Result(property = "destinationId", column = "destination_id"),
            @Result(property = "traveler.id", column = "traveler_id")
    })
    @Select("SELECT * FROM FAVOURITE_SEARCH WHERE TRAVELER_ID = #{id}")
    public List<FavouriteSearchEntity> findByUserId(Long id);

    @Delete("DELETE FROM FAVOURITE_SEARCH WHERE ID = #{id}")
    public void delete(Long id);
}

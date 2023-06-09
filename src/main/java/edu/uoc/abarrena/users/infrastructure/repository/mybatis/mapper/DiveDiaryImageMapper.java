package edu.uoc.abarrena.users.infrastructure.repository.mybatis.mapper;

import edu.uoc.abarrena.users.infrastructure.repository.mybatis.provider.DiveDiaryImageEntitySqlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface DiveDiaryImageMapper {

    @InsertProvider(type = DiveDiaryImageEntitySqlProvider.class, method = "save")
    void save(HashMap<String, Object> params);

    @Select("SELECT IMAGE_ID FROM DIVE_DIARY_IMAGE WHERE DIVE_DIARY_ID = #{diveDiaryId}")
    List<Long> findByDiveDiaryId(Long diveDiaryId);
}

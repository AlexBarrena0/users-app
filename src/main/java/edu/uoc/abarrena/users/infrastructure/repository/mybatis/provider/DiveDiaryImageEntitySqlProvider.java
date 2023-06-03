package edu.uoc.abarrena.users.infrastructure.repository.mybatis.provider;

import java.util.HashMap;
import java.util.List;

public class DiveDiaryImageEntitySqlProvider {

    public String save(HashMap<String, Object> params) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO DIVE_DIARY_IMAGE (DIVE_DIARY_ID, IMAGE_ID) VALUES ");
        for (int i = 0; i < ((List<Long>) params.get("imagesIds")).size(); i++) {
            sql.append("(#{diveDiaryId}, #{imagesIds[" + i + "]})");
            if (i < ((List<Long>) params.get("imagesIds")).size() - 1) {
                sql.append(", ");
            }
        }
        return sql.toString();
    }
}

package edu.uoc.abarrena.users.infrastructure.repository.mybatis.mapper;

import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM APP_USER WHERE USERNAME = #{username}")
    UserEntity findUserByUsername(String username);

    @Select("DELETE FROM APP_USER WHERE ID = #{id}")
    void delete(Long id);
}

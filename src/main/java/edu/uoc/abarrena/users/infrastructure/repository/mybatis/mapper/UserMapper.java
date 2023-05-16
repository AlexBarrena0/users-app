package edu.uoc.abarrena.users.infrastructure.repository.mybatis.mapper;

import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE USERNAME = #{username}")
    public UserEntity findUserByUsername(String username);

    @Select("DELETE FROM USER WHERE ID = #{id}")
    public void delete(Long id);
}

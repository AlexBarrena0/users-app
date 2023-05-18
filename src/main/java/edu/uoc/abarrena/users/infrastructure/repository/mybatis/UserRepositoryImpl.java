package edu.uoc.abarrena.users.infrastructure.repository.mybatis;

import edu.uoc.abarrena.users.domain.converter.UserConverter;
import edu.uoc.abarrena.users.domain.model.User;
import edu.uoc.abarrena.users.domain.repository.UserRepository;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.mapper.UserMapper;

public class UserRepositoryImpl implements UserRepository {

    private final UserMapper userMapper;

    public UserRepositoryImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findByUsername(String username) {
        return UserConverter.INSTANCE.toDomain(userMapper.findUserByUsername(username));
    }

    @Override
    public void delete(Long id) {
        userMapper.delete(id);
    }
}

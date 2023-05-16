package edu.uoc.abarrena.users.application.converter;

import edu.uoc.abarrena.users.domain.model.User;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserConverter {

    public static final UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);
    User toDomain(UserEntity userEntity);
}

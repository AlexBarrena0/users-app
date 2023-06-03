package edu.uoc.abarrena.users.domain.converter;

import edu.uoc.abarrena.users.application.dto.request.LoginDto;
import edu.uoc.abarrena.users.domain.model.User;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    User toDomain(LoginDto loginDto);

    User toDomain(UserEntity userEntity);
}

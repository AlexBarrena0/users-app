package edu.uoc.abarrena.users.domain.converter;

import edu.uoc.abarrena.users.domain.model.DiveDiary;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.DiveDiaryEntity;
import edu.uoc.abarrena.users.application.dto.request.CreateDiveDiaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiveDiaryConverter {

    public static final DiveDiaryConverter INSTANCE = Mappers.getMapper(DiveDiaryConverter.class);

    @Mapping(target = "traveler.id", source = "travelerId")
    DiveDiary toDomain(CreateDiveDiaryDto createDiveDiaryDto);

    List<DiveDiary> toDomain(List<DiveDiaryEntity> diveDiaryEntity);

    DiveDiaryEntity toEntity(DiveDiary diveDiary);

}

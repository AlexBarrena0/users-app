package edu.uoc.abarrena.users.application.converter;

import edu.uoc.abarrena.users.domain.model.Traveler;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.TravelerEntity;
import edu.uoc.abarrena.users.infrastructure.rest.dto.request.CreateTravelerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TravelerConverter {

    public static final TravelerConverter INSTANCE = Mappers.getMapper(TravelerConverter.class);

    Traveler toDomain(CreateTravelerDto createTravelerDto);

    Traveler toDomain(TravelerEntity travelerEntity);

    TravelerEntity toEntity(Traveler traveler);
}

package edu.uoc.abarrena.users.domain.converter;

import edu.uoc.abarrena.users.application.dto.request.CreateTravelerDto;
import edu.uoc.abarrena.users.application.dto.request.UpdateTravelerDto;
import edu.uoc.abarrena.users.application.dto.response.TravelerDto;
import edu.uoc.abarrena.users.domain.model.Traveler;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.TravelerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TravelerConverter {

    TravelerConverter INSTANCE = Mappers.getMapper(TravelerConverter.class);

    Traveler toDomain(CreateTravelerDto createTravelerDto);

    Traveler toDomain(UpdateTravelerDto updateTravelerDto);

    Traveler toDomain(TravelerEntity travelerEntity);

    TravelerEntity toEntity(Traveler traveler);

    TravelerDto toDto(Traveler traveler);
}

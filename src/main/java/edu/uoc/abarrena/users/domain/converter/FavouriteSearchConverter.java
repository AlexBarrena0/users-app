package edu.uoc.abarrena.users.domain.converter;

import edu.uoc.abarrena.users.application.dto.request.CreateFavouriteSearchDto;
import edu.uoc.abarrena.users.application.dto.response.FavouriteSearchDto;
import edu.uoc.abarrena.users.domain.model.FavouriteSearch;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.FavouriteSearchEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FavouriteSearchConverter {

    FavouriteSearchConverter INSTANCE = Mappers.getMapper(FavouriteSearchConverter.class);

    FavouriteSearchEntity toEntity(FavouriteSearch favouriteSearch);

    List<FavouriteSearch> toDomain(List<FavouriteSearchEntity> favouriteSearchEntity);

    @Mapping(target = "traveler.id", source = "travelerId")
    FavouriteSearch toDomain(CreateFavouriteSearchDto createFavouriteSearchDto);

    List<FavouriteSearchDto> toDto(List<FavouriteSearch> favouriteSearch);
}

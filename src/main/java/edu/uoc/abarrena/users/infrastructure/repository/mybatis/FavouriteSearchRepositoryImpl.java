package edu.uoc.abarrena.users.infrastructure.repository.mybatis;

import edu.uoc.abarrena.users.domain.converter.FavouriteSearchConverter;
import edu.uoc.abarrena.users.domain.model.FavouriteSearch;
import edu.uoc.abarrena.users.domain.repository.FavouriteSearchRepository;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.FavouriteSearchEntity;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.mapper.FavouriteSearchMapper;

import java.util.List;

public class FavouriteSearchRepositoryImpl implements FavouriteSearchRepository {

    private final FavouriteSearchMapper favouriteSearchMapper;

    public FavouriteSearchRepositoryImpl(FavouriteSearchMapper favouriteSearchMapper) {
        this.favouriteSearchMapper = favouriteSearchMapper;
    }

    @Override
    public Long save(FavouriteSearch favouriteSearch) {
        FavouriteSearchEntity favouriteSearchEntity = FavouriteSearchConverter.INSTANCE.toEntity(favouriteSearch);
        favouriteSearchMapper.save(favouriteSearchEntity);
        return favouriteSearchEntity.getId();
    }

    @Override
    public List<FavouriteSearch> findByUserId(Long id) {
        return FavouriteSearchConverter.INSTANCE.toDomain(favouriteSearchMapper.findByUserId(id));
    }

    @Override
    public void delete(Long id) {
        favouriteSearchMapper.delete(id);
    }
}

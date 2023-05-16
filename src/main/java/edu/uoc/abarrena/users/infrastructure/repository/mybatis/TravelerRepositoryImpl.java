package edu.uoc.abarrena.users.infrastructure.repository.mybatis;

import edu.uoc.abarrena.users.application.converter.TravelerConverter;
import edu.uoc.abarrena.users.domain.model.Traveler;
import edu.uoc.abarrena.users.domain.repository.TravelerRepository;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.TravelerEntity;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.mapper.TravelerMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TravelerRepositoryImpl implements TravelerRepository {

    private final TravelerMapper travelerMapper;

    public TravelerRepositoryImpl(TravelerMapper travelerMapper) {
        this.travelerMapper = travelerMapper;
    }

    @Override
    public Long save(Traveler traveler) {
        TravelerEntity travelerEntity = TravelerConverter.INSTANCE.toEntity(traveler);
        travelerMapper.save(travelerEntity);
        return travelerEntity.getId();
    }

    @Override
    public Traveler findById(Long id) {
        return TravelerConverter.INSTANCE.toDomain(travelerMapper.findById(id));
    }
}

package edu.uoc.abarrena.users.infrastructure.repository.mybatis;

import edu.uoc.abarrena.users.domain.converter.DiveDiaryConverter;
import edu.uoc.abarrena.users.domain.model.DiveDiary;
import edu.uoc.abarrena.users.domain.repository.DiveDiaryRepository;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.entity.DiveDiaryEntity;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.mapper.DiveDiaryMapper;

import java.util.List;

public class DiveDiaryRepositoryImpl implements DiveDiaryRepository {

    private final DiveDiaryMapper diveDiaryMapper;

    public DiveDiaryRepositoryImpl(DiveDiaryMapper diveDiaryMapper){
        this.diveDiaryMapper = diveDiaryMapper;
    }
    @Override
    public Long save(DiveDiary diveDiary) {
        DiveDiaryEntity diveDiaryEntity = DiveDiaryConverter.INSTANCE.toEntity(diveDiary);
        diveDiaryMapper.save(diveDiaryEntity);
        return diveDiaryEntity.getId();
    }

    @Override
    public List<DiveDiary> findByUserId(Long id) {
        return DiveDiaryConverter.INSTANCE.toDomain(diveDiaryMapper.findByUserId(id));
    }
}

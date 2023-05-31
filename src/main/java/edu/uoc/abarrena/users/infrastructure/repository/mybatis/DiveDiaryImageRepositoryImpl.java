package edu.uoc.abarrena.users.infrastructure.repository.mybatis;

import edu.uoc.abarrena.users.domain.repository.DiveDiaryImageRepository;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.mapper.DiveDiaryImageMapper;

import java.util.HashMap;
import java.util.List;

public class DiveDiaryImageRepositoryImpl implements DiveDiaryImageRepository {

    private final DiveDiaryImageMapper diveDiaryImageMapper;

    public DiveDiaryImageRepositoryImpl(DiveDiaryImageMapper diveDiaryImageMapper) {
        this.diveDiaryImageMapper = diveDiaryImageMapper;
    }

    @Override
    public void save(Long diveDiaryId, List<Long> imagesIds) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("diveDiaryId", diveDiaryId);
        params.put("imagesIds", imagesIds);
        diveDiaryImageMapper.save(params);
    }

    @Override
    public List<Long> findByDiveDiaryId(Long diveDiaryId) {
        return diveDiaryImageMapper.findByDiveDiaryId(diveDiaryId);
    }
}

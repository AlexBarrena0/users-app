package edu.uoc.abarrena.users.domain.repository;

import edu.uoc.abarrena.users.domain.model.DiveDiary;

import java.util.List;

public interface DiveDiaryRepository {

    public Long save(DiveDiary diveDiary);

    public List<DiveDiary> findByUserId(Long id);
}

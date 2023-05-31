package edu.uoc.abarrena.users.domain.repository;

import edu.uoc.abarrena.users.domain.model.DiveDiary;

import java.util.List;

public interface DiveDiaryRepository {

    /**
     * Save a dive diary
     * @param diveDiary to save
     * @return the id of the saved dive diary
     */
    public Long save(DiveDiary diveDiary);

    /**
     * Find dive diaries by traveler id
     * @param id the id of the traveler
     * @return the dive diaries of the traveler
     */
    public List<DiveDiary> findByTravelerId(Long id);
}

package edu.uoc.abarrena.users.domain.repository;

import java.util.List;

public interface DiveDiaryImageRepository {

    /**
     * Save the images of a dive diary
     *
     * @param diveDiaryId dive diary id
     * @param imagesIds   images ids
     */
    void save(Long diveDiaryId, List<Long> imagesIds);

    /**
     * Find the images of a traveler
     *
     * @param diveDiaryId dive diary id
     * @return images ids
     */
    List<Long> findByDiveDiaryId(Long diveDiaryId);
}

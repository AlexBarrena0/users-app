package edu.uoc.abarrena.users.application;

import edu.uoc.abarrena.users.domain.exceptions.EntityNotFoundException;
import edu.uoc.abarrena.users.domain.model.DiveDiary;

import java.util.List;

public interface DiveDiaryService {

    /**
     * Creates a new dive diary
     * @param diveDiary to create
     * @return the id of the created dive diary
     */
    public Long createDiveDiary(DiveDiary diveDiary) throws EntityNotFoundException;

    /**
     * Finds a dive diary by its user id
     * @param id of the user to find
     * @return the list of dive diary with the given user id
     */
    public List<DiveDiary> findDiveDiaryByUserId(Long id) throws EntityNotFoundException;
}

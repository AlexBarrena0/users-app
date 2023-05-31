package edu.uoc.abarrena.users.domain.service.impl;

import edu.uoc.abarrena.users.domain.repository.DiveDiaryImageRepository;
import edu.uoc.abarrena.users.domain.service.DiveDiaryService;
import edu.uoc.abarrena.users.domain.service.TravelerService;
import edu.uoc.abarrena.users.domain.exceptions.EntityNotFoundException;
import edu.uoc.abarrena.users.domain.model.DiveDiary;
import edu.uoc.abarrena.users.domain.model.Traveler;
import edu.uoc.abarrena.users.domain.repository.DiveDiaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiveDiaryServiceImpl implements DiveDiaryService {

    private final DiveDiaryRepository diveDiaryRepository;

    private final TravelerService travelerService;

    private final DiveDiaryImageRepository diveDiaryImageRepository;

    public DiveDiaryServiceImpl(DiveDiaryRepository diveDiaryRepository, TravelerService travelerService, DiveDiaryImageRepository diveDiaryImageRepository) {
        this.diveDiaryRepository = diveDiaryRepository;
        this.travelerService = travelerService;
        this.diveDiaryImageRepository = diveDiaryImageRepository;
    }

    @Override
    public Long createDiveDiary(DiveDiary diveDiary) throws EntityNotFoundException {
        Traveler traveler = travelerService.findTravelerById(diveDiary.getTraveler().getId());
        if (traveler == null) {
            throw new EntityNotFoundException("Traveler not found");
        }
        if (diveDiary.getImagesIds() != null && !diveDiary.getImagesIds().isEmpty()) {
            diveDiaryImageRepository.save(diveDiary.getId(), diveDiary.getImagesIds());
        }
        return diveDiaryRepository.save(diveDiary);
    }

    @Override
    public List<DiveDiary> findDiveDiaryByUserId(Long id) throws EntityNotFoundException {
        Traveler traveler = travelerService.findTravelerById(id);
        if (traveler == null) {
            throw new EntityNotFoundException("Traveler not found");
        }
        return diveDiaryRepository.findByTravelerId(id);
    }
}

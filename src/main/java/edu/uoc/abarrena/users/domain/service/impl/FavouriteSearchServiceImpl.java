package edu.uoc.abarrena.users.domain.service.impl;

import edu.uoc.abarrena.users.domain.exceptions.EntityNotFoundException;
import edu.uoc.abarrena.users.domain.model.FavouriteSearch;
import edu.uoc.abarrena.users.domain.model.Traveler;
import edu.uoc.abarrena.users.domain.repository.FavouriteSearchRepository;
import edu.uoc.abarrena.users.domain.service.FavouriteSearchService;
import edu.uoc.abarrena.users.domain.service.TravelerService;
import edu.uoc.abarrena.users.domain.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteSearchServiceImpl implements FavouriteSearchService {

    private final FavouriteSearchRepository favouriteSearchRepository;

    private final TravelerService travelerService;

    public FavouriteSearchServiceImpl(FavouriteSearchRepository favouriteSearchRepository, TravelerService travelerService) {
        this.favouriteSearchRepository = favouriteSearchRepository;
        this.travelerService = travelerService;
    }

    @Override
    public Long createFavouriteSearch(FavouriteSearch favouriteSearch) throws EntityNotFoundException {
        Traveler traveler = travelerService.findTravelerById(favouriteSearch.getTraveler().getId());
        if (traveler == null) {
            throw new EntityNotFoundException("Traveler not found");
        }
        return favouriteSearchRepository.save(favouriteSearch);
    }

    @Override
    public List<FavouriteSearch> findFavouriteSearchByUserId(Long id) {
        return favouriteSearchRepository.findByUserId(id);
    }

    @Override
    public void deleteFavouriteSearch(Long id) {
        favouriteSearchRepository.delete(id);
    }
}

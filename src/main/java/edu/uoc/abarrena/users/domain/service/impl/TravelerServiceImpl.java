package edu.uoc.abarrena.users.domain.service.impl;

import edu.uoc.abarrena.users.domain.exceptions.DuplicateUserException;
import edu.uoc.abarrena.users.domain.model.Role;
import edu.uoc.abarrena.users.domain.model.Traveler;
import edu.uoc.abarrena.users.domain.model.User;
import edu.uoc.abarrena.users.domain.repository.TravelerRepository;
import edu.uoc.abarrena.users.domain.service.TravelerService;
import edu.uoc.abarrena.users.domain.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class TravelerServiceImpl implements TravelerService {

    private final TravelerRepository travelerRepository;

    private final UserService userService;

    public TravelerServiceImpl(TravelerRepository travelerRepository, UserService userService) {
        this.travelerRepository = travelerRepository;
        this.userService = userService;
    }

    @Override
    public Long createTraveler(Traveler traveler) throws DuplicateUserException {
        User user = userService.findUserByUsername(traveler.getUsername());
        if (user != null) {
            throw new DuplicateUserException();
        }
        traveler.setRole(Role.TRAVELER.name());
        return travelerRepository.save(traveler);
    }

    @Override
    public Traveler findTravelerById(Long id) {
        return travelerRepository.findById(id);
    }

    @Override
    public void updateTraveler(Traveler traveler) {
        travelerRepository.update(traveler);
    }
}

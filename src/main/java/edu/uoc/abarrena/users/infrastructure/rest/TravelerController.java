package edu.uoc.abarrena.users.infrastructure.rest;

import edu.uoc.abarrena.users.application.TravelerService;
import edu.uoc.abarrena.users.application.converter.TravelerConverter;
import edu.uoc.abarrena.users.infrastructure.rest.dto.request.CreateTravelerDto;
import edu.uoc.abarrena.users.infrastructure.rest.dto.response.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(TravelerController.BASE_PATH)
public class TravelerController {

    public static final String BASE_PATH = "/travelers";

    private final TravelerService travelerService;

    public TravelerController(TravelerService travelerService) {
        this.travelerService = travelerService;
    }

    @PostMapping
    public Result<Long> createTraveler(@RequestBody CreateTravelerDto createTravelerDto) {
        log.trace("Creating traveler " + createTravelerDto);

        Long travelerId = travelerService.createTraveler(TravelerConverter.INSTANCE.toDomain(createTravelerDto));

        return new Result<Long>(travelerId, "Traveler created successfully");
    }
}

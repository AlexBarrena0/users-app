package edu.uoc.abarrena.users.application.rest;

import edu.uoc.abarrena.users.application.dto.request.CreateTravelerDto;
import edu.uoc.abarrena.users.application.dto.response.Result;
import edu.uoc.abarrena.users.application.dto.response.TravelerDto;
import edu.uoc.abarrena.users.domain.service.TravelerService;
import edu.uoc.abarrena.users.domain.converter.TravelerConverter;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Result<TravelerDto> findTravelerById(@PathVariable Long id) {
        log.trace("Finding traveler by id " + id);

        TravelerDto travelerDto = TravelerConverter.INSTANCE.toDto(travelerService.findTravelerById(id));

        return new Result<TravelerDto>(travelerDto, "Traveler found successfully");
    }
}

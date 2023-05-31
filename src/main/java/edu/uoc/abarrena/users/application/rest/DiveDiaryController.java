package edu.uoc.abarrena.users.application.rest;

import edu.uoc.abarrena.users.application.dto.request.CreateDiveDiaryDto;
import edu.uoc.abarrena.users.application.dto.response.DiveDiaryDto;
import edu.uoc.abarrena.users.domain.service.DiveDiaryService;
import edu.uoc.abarrena.users.domain.converter.DiveDiaryConverter;
import edu.uoc.abarrena.users.application.dto.response.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
@RequestMapping(DiveDiaryController.BASE_PATH)
public class DiveDiaryController {

    public static final String BASE_PATH = "/dive-diary";

    private final DiveDiaryService diveDiaryService;

    public DiveDiaryController(DiveDiaryService diveDiaryService) {
        this.diveDiaryService = diveDiaryService;
    }

    @PostMapping
    public Result<Long> createDiveDiary(@Valid @RequestBody CreateDiveDiaryDto createDiveDiaryDto) {
        log.trace("Creating dive diary " + createDiveDiaryDto);

        Long diveDiaryId = diveDiaryService.createDiveDiary(DiveDiaryConverter.INSTANCE.toDomain(createDiveDiaryDto));

        return new Result<Long>(diveDiaryId, "Dive diary created successfully");
    }

    @GetMapping
    public Result<List<DiveDiaryDto>> getDiveDiaryByTravelerId(@RequestParam Long travelerId) {
        log.trace("Finding dive diary by traveler id " + travelerId);

        List<DiveDiaryDto> diveDiaryDtoList = DiveDiaryConverter.INSTANCE.toDto(diveDiaryService.findDiveDiaryByUserId(travelerId));

        return new Result<List<DiveDiaryDto>>(diveDiaryDtoList, null);
    }

}

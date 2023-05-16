package edu.uoc.abarrena.users.infrastructure.rest;

import edu.uoc.abarrena.users.application.DiveDiaryService;
import edu.uoc.abarrena.users.application.converter.DiveDiaryConverter;
import edu.uoc.abarrena.users.infrastructure.rest.dto.request.CreateDiveDiaryDto;
import edu.uoc.abarrena.users.infrastructure.rest.dto.response.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result<Long> createDiveDiary(@RequestBody CreateDiveDiaryDto createDiveDiaryDto) {
        log.trace("Creating dive diary " + createDiveDiaryDto);

        Long diveDiaryId = diveDiaryService.createDiveDiary(DiveDiaryConverter.INSTANCE.toDomain(createDiveDiaryDto));

        return new Result<Long>(diveDiaryId, "Dive diary created successfully");
    }
}

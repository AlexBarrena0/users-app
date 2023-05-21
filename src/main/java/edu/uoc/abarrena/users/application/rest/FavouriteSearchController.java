package edu.uoc.abarrena.users.application.rest;

import edu.uoc.abarrena.users.application.dto.request.CreateFavouriteSearchDto;
import edu.uoc.abarrena.users.application.dto.response.FavouriteSearchDto;
import edu.uoc.abarrena.users.application.dto.response.Result;
import edu.uoc.abarrena.users.domain.converter.FavouriteSearchConverter;
import edu.uoc.abarrena.users.domain.service.FavouriteSearchService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
@RequestMapping(FavouriteSearchController.BASE_PATH)
public class FavouriteSearchController {

    public static final String BASE_PATH = "/favourite-searches";

    private final FavouriteSearchService favouriteSearchService;

    public FavouriteSearchController(FavouriteSearchService favouriteSearchService) {
        this.favouriteSearchService = favouriteSearchService;
    }

    @PostMapping
    public Result<Long> createFavouriteSearch(@Valid @RequestBody CreateFavouriteSearchDto createFavouriteSearchDto) {
        log.trace("Creating favourite search " + createFavouriteSearchDto);

        Long favouriteSearchId = favouriteSearchService.createFavouriteSearch(FavouriteSearchConverter.INSTANCE.toDomain(createFavouriteSearchDto));

        return new Result<Long>(favouriteSearchId, "Favourite search created successfully");
    }

    @GetMapping
    public Result<List<FavouriteSearchDto>> findFavouriteSearchByUserId(@RequestParam Long userId) {
        log.trace("Finding favourite search by user id " + userId);

        List<FavouriteSearchDto> favouriteSearchDto = FavouriteSearchConverter.INSTANCE.toDto(favouriteSearchService.findFavouriteSearchByUserId(userId));

        return new Result<List<FavouriteSearchDto>>(favouriteSearchDto, null);
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> deleteFavouriteSearch(@PathVariable Long id) {
        log.trace("Deleting favourite search by id " + id);

        favouriteSearchService.deleteFavouriteSearch(id);

        return new Result<Boolean>(true, "Favourite search deleted successfully");
    }
}

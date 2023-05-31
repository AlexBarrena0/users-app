package edu.uoc.abarrena.users.domain.config;

import edu.uoc.abarrena.users.domain.repository.*;
import edu.uoc.abarrena.users.domain.service.*;
import edu.uoc.abarrena.users.domain.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    public CompanyService companyService(CompanyRepository companyRepository, UserService userService) {
        return new CompanyServiceImpl(companyRepository, userService);
    }

    @Bean
    public TravelerService travelerService(TravelerRepository travelerRepository, UserService userService) {
        return new TravelerServiceImpl(travelerRepository, userService);
    }

    @Bean
    public DiveDiaryService diveDiaryService(DiveDiaryRepository diveDiaryRepository, TravelerService travelerService, DiveDiaryImageRepository diveDiaryImageRepository) {
        return new DiveDiaryServiceImpl(diveDiaryRepository, travelerService, diveDiaryImageRepository);
    }

    @Bean
    public FavouriteSearchService favouriteSearchService(FavouriteSearchRepository favouriteSearchRepository, TravelerService travelerService) {
        return new FavouriteSearchServiceImpl(favouriteSearchRepository, travelerService);
    }
}

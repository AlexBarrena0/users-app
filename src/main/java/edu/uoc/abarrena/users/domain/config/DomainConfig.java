package edu.uoc.abarrena.users.domain.config;

import edu.uoc.abarrena.users.domain.service.CompanyService;
import edu.uoc.abarrena.users.domain.service.DiveDiaryService;
import edu.uoc.abarrena.users.domain.service.TravelerService;
import edu.uoc.abarrena.users.domain.service.UserService;
import edu.uoc.abarrena.users.domain.repository.CompanyRepository;
import edu.uoc.abarrena.users.domain.repository.DiveDiaryRepository;
import edu.uoc.abarrena.users.domain.repository.TravelerRepository;
import edu.uoc.abarrena.users.domain.repository.UserRepository;
import edu.uoc.abarrena.users.domain.service.impl.CompanyServiceImpl;
import edu.uoc.abarrena.users.domain.service.impl.DiveDiaryServiceImpl;
import edu.uoc.abarrena.users.domain.service.impl.TravelerServiceImpl;
import edu.uoc.abarrena.users.domain.service.impl.UserServiceImpl;
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
    public DiveDiaryService diveDiaryService(DiveDiaryRepository diveDiaryRepository, TravelerService travelerService) {
        return new DiveDiaryServiceImpl(diveDiaryRepository, travelerService);
    }
}

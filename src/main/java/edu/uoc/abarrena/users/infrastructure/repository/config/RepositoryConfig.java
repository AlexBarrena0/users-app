package edu.uoc.abarrena.users.infrastructure.repository.config;

import edu.uoc.abarrena.users.domain.repository.*;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.*;
import edu.uoc.abarrena.users.infrastructure.repository.mybatis.mapper.*;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "edu.uoc.abarrena.users.infrastructure.repository.mybatis.mapper")
public class RepositoryConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
    }

    @Bean
    public DiveDiaryRepository diveDiaryRepository(DiveDiaryMapper diveDiaryMapper) {
        return new DiveDiaryRepositoryImpl(diveDiaryMapper);
    }

    @Bean
    public CompanyRepository companyRepository(CompanyMapper companyMapper) {
        return new CompanyRepositoryImpl(companyMapper);
    }

    @Bean
    TravelerRepository travelerRepository(TravelerMapper travelerMapper) {
        return new TravelerRepositoryImpl(travelerMapper);
    }

    @Bean
    UserRepository userRepository(UserMapper userMapper) {
        return new UserRepositoryImpl(userMapper);
    }

    @Bean
    FavouriteSearchRepository favouriteSearchRepository(FavouriteSearchMapper favouriteSearchMapper) {
        return new FavouriteSearchRepositoryImpl(favouriteSearchMapper);
    }
}

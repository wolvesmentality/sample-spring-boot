package com.wolvesmentality.repository.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wolvesmentality.repository.custom.BookRepository;
import com.wolvesmentality.repository.custom.RatingRepository;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {BookRepository.class, RatingRepository.class})
@ImportAutoConfiguration(LiquibaseAutoConfiguration.class)
public class RepositoryTestConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}

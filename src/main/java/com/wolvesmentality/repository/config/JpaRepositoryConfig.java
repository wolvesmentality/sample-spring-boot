package com.wolvesmentality.repository.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.wolvesmentality.repository.jpa"})
@EnableTransactionManagement
public class JpaRepositoryConfig {
}

package com.ecommerce.prices.test.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.ecommerce.prices.repository")
@EntityScan(basePackages = "com.ecommerce.prices.model")
public class TestConfig {
}


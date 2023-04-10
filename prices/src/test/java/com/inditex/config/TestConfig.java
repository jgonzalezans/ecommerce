package com.inditex.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.inditex.repository")
@EntityScan(basePackages = "com.inditex.model")
public class TestConfig {
}


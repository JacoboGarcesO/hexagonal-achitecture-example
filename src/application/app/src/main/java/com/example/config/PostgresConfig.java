package com.example.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@ComponentScan(basePackages = "co.example.adapters")
@EnableR2dbcRepositories(basePackages = "co.example.repositories")
@EntityScan(basePackages = "co.example.entities")
public class PostgresConfig {
}

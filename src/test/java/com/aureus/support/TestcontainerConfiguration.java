package com.aureus.support;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.postgresql.PostgreSQLContainer;

@TestConfiguration(proxyBeanMethods = false)
public class TestcontainerConfiguration {

    @Bean
    @ServiceConnection
    PostgreSQLContainer postgreContainer() {
        return new PostgreSQLContainer("postgres:17")
                .withDatabaseName("aureus_test")
                .withUsername("aureus")
                .withPassword("test");
    }
}

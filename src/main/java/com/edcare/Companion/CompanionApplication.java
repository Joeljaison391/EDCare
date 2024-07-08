package com.edcare.Companion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication

@EnableMongoRepositories(basePackages = "com.edcare.Companion.repository")
public class CompanionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanionApplication.class, args);
    }
}

package ru.ezikvice.springotus.homework13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Homework13Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework13Application.class);
    }
}

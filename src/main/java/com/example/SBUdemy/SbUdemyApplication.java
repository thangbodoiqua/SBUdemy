package com.example.SBUdemy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SbUdemyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SbUdemyApplication.class, args);
        System.out.println("http://localhost:2025");
    }
    @Bean
    public CommandLineRunner commandLinerRunner(String[] args) {

        return runner -> {
            System.out.println("Hello World");
        };

    }
}
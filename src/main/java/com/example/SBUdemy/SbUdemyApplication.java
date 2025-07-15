package com.example.SBUdemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class SbUdemyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SbUdemyApplication.class, args);
        System.out.println("http://localhost:2025");
    }
}


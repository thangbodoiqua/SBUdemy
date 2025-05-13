package com.example.SBUdemy.SpringCore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"com.example.SBUdemy.util", "com.example.SBUdemy.SpringCore", "com.example.SBUdemy.Controller"}
)
public class SbUdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbUdemyApplication.class, args);
		System.out.println("cc");
	}


}

package com.example.SBUdemy.config;

import com.example.SBUdemy.SpringCore.Common.Coach;
import com.example.SBUdemy.SpringCore.Common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}

package com.example.SBUdemy.SpringCore.Common;

import org.springframework.stereotype.Component;

@Component
public class TenisCoach implements Coach {
    public String getDailyWorkout(){
        String content = "CricketCoach";
        return content;
    }
}

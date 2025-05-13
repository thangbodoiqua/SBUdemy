package com.example.SBUdemy.SpringCore.Common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    public String getDailyWorkout(){
        String content = "BaseballCoach";
        return content;
    }
}

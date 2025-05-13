package com.example.SBUdemy.SpringCore.Common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    public BaseballCoach() {
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    public String getDailyWorkout(){
        String content = "BaseballCoach";
        return content;
    }
}

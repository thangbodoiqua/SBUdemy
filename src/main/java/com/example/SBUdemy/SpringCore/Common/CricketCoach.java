package com.example.SBUdemy.SpringCore.Common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        String content = "CricketCoach";
        return content;
    }

}

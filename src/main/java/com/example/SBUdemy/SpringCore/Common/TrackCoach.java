package com.example.SBUdemy.SpringCore.Common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TrackCoach {
    public TrackCoach() {
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }
    public String getDailyWorkout(){
        String content = "TrackCoach";
        return content;
    }
}

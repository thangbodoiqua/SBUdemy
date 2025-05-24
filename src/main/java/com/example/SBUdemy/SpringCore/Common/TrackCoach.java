package com.example.SBUdemy.SpringCore.Common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach {
    public TrackCoach() {
    }
    public String getDailyWorkout(){
        String content = "TrackCoach";
        return content;
    }
}

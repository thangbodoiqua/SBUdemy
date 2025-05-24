package com.example.SBUdemy.SpringCore.Common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    public CricketCoach() {
    }

    @Override
    public String getDailyWorkout(){
        String content = "CricketCoach";
        return content;
    }

}

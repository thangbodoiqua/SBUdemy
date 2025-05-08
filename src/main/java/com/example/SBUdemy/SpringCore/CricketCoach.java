package com.example.SBUdemy.SpringCore;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        String content = "<h1 title=\"cc\">F8 - Học lập trình để đi làm</h1>\n" +
                "    <p>\n" +
                "      Truy cập <a>fullstack.edu.vn</a> để học lập trình miễn phí các bạn nhé!!!\n" +
                "    </p>\n" +
                "    <script src=\"jav.js\"></script>";
        return content;
    }

}

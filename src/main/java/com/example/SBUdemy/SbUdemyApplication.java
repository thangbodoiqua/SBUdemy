package com.example.SBUdemy;

import com.example.SBUdemy.DAO.AppDAO;
import com.example.SBUdemy.entity.Instructor;
import com.example.SBUdemy.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SbUdemyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SbUdemyApplication.class, args);
        System.out.println("http://localhost:2025");
    }
    @Bean
    public CommandLineRunner commandLinerRunner(AppDAO appDAO) {

        return runner -> {
            createInstructor(appDAO);
        };

    }

    public void createInstructor(AppDAO appDAO) {
        Instructor tempInstructor = new Instructor("Chad", "Darby", "dluy2406@gmail.com");

        InstructorDetail tempInstructorDetail = new InstructorDetail("fuck", "liongold");

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        System.out.println("saving instructor: " + tempInstructor);
        //also save tempInstructorDetail bcz CasecadeType = All
        appDAO.save(tempInstructor);

        System.out.println("Done!");

    }
}
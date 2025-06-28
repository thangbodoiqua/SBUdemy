package com.example.SBUdemy;

import com.example.SBUdemy.DAO.AppDAO;
import com.example.SBUdemy.entity.Course;
import com.example.SBUdemy.entity.Instructor;
import com.example.SBUdemy.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

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
            createInstructorWithCourses(appDAO);
        };

    }
    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor instructor1 = new Instructor("Linh", "Nguyen", "linh.nguyen@example.com");
        InstructorDetail detail1 = new InstructorDetail("LinhTube", "Piano");
        instructor1.setInstructorDetail(detail1);

// 2
        Instructor instructor2 = new Instructor("Huy", "Tran", "huy.tran@example.com");
        InstructorDetail detail2 = new InstructorDetail("HuyVlogs", "Chess");
        instructor2.setInstructorDetail(detail2);
        Course tempCourse1 = new Course("Air Guitar");
        Course tempCourse2 = new Course("Masterclass");


        instructor1.addCourse(tempCourse1);
        instructor1.addCourse(tempCourse2);
        appDAO.save(instructor1);
        System.out.println("Instructor after add courses: " + instructor1);

    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId = 3;
        appDAO.deleteInstructorDetailById((theId));
        System.out.println("Instructor deleted");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int theId = 3;
        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
        System.out.println("tempInstructorDetail: " + tempInstructorDetail);
        System.out.println("tempInstructor" + tempInstructorDetail.getInstructor());
    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        appDAO.deleteInstructorById(theId);
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding the Instructor Id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);

        System.out.println("The associated instructorDetail only: " + tempInstructor.getInstructorDetail());

    }

    public void createInstructor(AppDAO appDAO) {
        // 1
        Instructor instructor1 = new Instructor("Linh", "Nguyen", "linh.nguyen@example.com");
        InstructorDetail detail1 = new InstructorDetail("LinhTube", "Piano");
        instructor1.setInstructorDetail(detail1);
        appDAO.save(instructor1);

// 2
        Instructor instructor2 = new Instructor("Huy", "Tran", "huy.tran@example.com");
        InstructorDetail detail2 = new InstructorDetail("HuyVlogs", "Chess");
        instructor2.setInstructorDetail(detail2);
        appDAO.save(instructor2);

// 3
        Instructor instructor3 = new Instructor("Trang", "Phung", "trang.phung@example.com");
        InstructorDetail detail3 = new InstructorDetail("TravelWithTrang", "Photography");
        instructor3.setInstructorDetail(detail3);
        appDAO.save(instructor3);

// 4
        Instructor instructor4 = new Instructor("Minh", "Le", "minh.le@example.com");
        InstructorDetail detail4 = new InstructorDetail("LeCodes", "Hiking");
        instructor4.setInstructorDetail(detail4);
        appDAO.save(instructor4);

// 5
        Instructor instructor5 = new Instructor("An", "Vo", "an.vo@example.com");
        InstructorDetail detail5 = new InstructorDetail("AnCooking", "Baking");
        instructor5.setInstructorDetail(detail5);
        appDAO.save(instructor5);

// 6
        Instructor instructor6 = new Instructor("Hoa", "Pham", "hoa.pham@example.com");
        InstructorDetail detail6 = new InstructorDetail("HoaArt", "Sketching");
        instructor6.setInstructorDetail(detail6);
        appDAO.save(instructor6);

// 7
        Instructor instructor7 = new Instructor("Quang", "Do", "quang.do@example.com");
        InstructorDetail detail7 = new InstructorDetail("DoGaming", "Board Games");
        instructor7.setInstructorDetail(detail7);
        appDAO.save(instructor7);

// 8
        Instructor instructor8 = new Instructor("Nga", "Bui", "nga.bui@example.com");
        InstructorDetail detail8 = new InstructorDetail("NgaFitness", "Yoga");
        instructor8.setInstructorDetail(detail8);
        appDAO.save(instructor8);

// 9
        Instructor instructor9 = new Instructor("Tuan", "Hoang", "tuan.hoang@example.com");
        InstructorDetail detail9 = new InstructorDetail("TuanTech", "Robotics");
        instructor9.setInstructorDetail(detail9);
        appDAO.save(instructor9);

// 10
        Instructor instructor10 = new Instructor("Mai", "Ngoc", "mai.ngoc@example.com");
        InstructorDetail detail10 = new InstructorDetail("MaiMusic", "Guitar");
        instructor10.setInstructorDetail(detail10);
        appDAO.save(instructor10);

    }
}
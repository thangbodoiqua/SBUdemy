package com.example.SBUdemy;

import com.example.SBUdemy.DAO.AppDAO;
import com.example.SBUdemy.entity.*;
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
            deleteStudent(appDAO);

        };

    }

    private void deleteStudent(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleting student with id: " + theId);
        appDAO.deleteStudentById(theId);
        System.out.println("Done!");
    }

    private void addMoreCoursesForStudents(AppDAO appDAO) {
        int theId = 2;
        Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

        Course tempCourse1 = new Course("Rbik'Cube - how to speed cube");
        Course tempCourse2 = new Course("Atari 2600 - Game Development");

        tempStudent.addCourse(tempCourse1);
        tempStudent.addCourse(tempCourse2);

        System.out.println("Updating course: " + tempStudent);
        System.out.println("Courses: " + tempStudent.getCourses());
        appDAO.update(tempCourse1);
        System.out.println("Done!");

    }

    private void findStudentAndCourses(AppDAO appDAO) {
        int theId = 2;
        Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);
        System.out.println("Loaded Student: " + tempStudent);
        System.out.println("Courses: " + tempStudent.getCourses());
    }

    private void findCourseAndStudents(AppDAO appDAO) {
        int theId = 10;
        Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);
        System.out.println("Loaded Course: " + tempCourse);
        System.out.println("Students: " + tempCourse.getStudents());
        System.out.println("Done!");
    }

    private void createCoursesAndStudents(AppDAO appDAO) {
        Course tempCourse = new Course("Pacman - How to score 1 milion points");
        Student tempStudent1 = new Student("Dinh", "Thang", "dluy2406@gmail.com");
        Student tempStudent2 = new Student("Ngoc", "Dac", "Dac@gmail.com");
        tempCourse.addStudent(tempStudent1);
        tempCourse.addStudent(tempStudent2);

        System.out.println("Saving the course: " + tempCourse);
        System.out.println("associated students: " + tempCourse.getStudents());

        appDAO.save(tempCourse);

        System.out.println("Done");


    }

    private void deleteCourseAndReviews(AppDAO appDAO) {
        int theId = 10;
        System.out.println("Deleting the course with id: "+ theId);
        appDAO.deleteCourseById(theId);
        System.out.println("Deleted");
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {
        System.out.println("Retrieving the course and reviews");
        int theId = 10;
        Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

        System.out.println("The course: " + tempCourse);
        System.out.println("The reviews: "+ tempCourse.getReviews());

    }

    private void createCourseAndReviews(AppDAO appDAO) {
        Course tempCourse = new Course("Cai loz");

        tempCourse.addReview(new Review("Great Course, Hate it"));
        tempCourse.addReview(new Review("Shit course, Love it"));
        tempCourse.addReview(new Review("I dont know"));

        System.out.println("Saving the course: " + tempCourse);
        System.out.println("The reviews: " + tempCourse.getReviews());

        appDAO.save(tempCourse);

        System.out.println("Done!");


    }

    private void deleteCourse(AppDAO appDAO) {
        int theId = 11;
        System.out.println("Deleting Course with id: " + theId);
        appDAO.deleteCourseById(theId);
        System.out.println("Done!");
    }

    private void updateCourse(AppDAO appDAO) {
        int theId = 10;
        System.out.println("Find the Course with id: " + theId);
        Course tempCourse = appDAO.findCourseById(theId);
        System.out.println("Update course with id: " + theId);
        tempCourse.setTitle("No love no life");
        appDAO.update(tempCourse);
        System.out.println("Done!");

    }

    private void updateInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Find the instructor with id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("Update instructor with id: " + theId);
        tempInstructor.setLastName("Thang");

        appDAO.update(tempInstructor);
        System.out.println("Done!");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int theId = 1;

        System.out.println("finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("tempInstructor: " + tempInstructor);

        System.out.println("Associated Courses: " + tempInstructor.getCourses());



    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);

        List<Course> courses = appDAO.findCoursesByInstructorId(theId);

        tempInstructor.setCourses(courses);
        System.out.println("The associated courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("The associated courses: " + tempInstructor.getCourses());
        System.out.println("Done!");
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
        System.out.println("deleting instructor with id: " + theId);
        appDAO.deleteInstructorById(theId);
        System.out.println("Done!");
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
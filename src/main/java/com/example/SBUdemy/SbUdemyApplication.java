package com.example.SBUdemy;

import com.example.SBUdemy.DAO.StudentDAO;
import com.example.SBUdemy.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SbUdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbUdemyApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createMultipleStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student");
		Student tempStudent = new Student("Smith", "John", "JohnSmith@gmail.com");

		System.out.println("Saving new student");
		studentDAO.save(tempStudent);

		System.out.println("Saved new student with id: " + tempStudent.getId());
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating students");
		Student tempStudent1 = new Student("Dinh", "Thang", "thang@gmail.com");
		Student tempStudent2 = new Student("Ngoc", "Dac", "dac@gmail.com");
		Student tempStudent3 = new Student("Cong", "Doan", "doan@gmail.com");

		System.out.println("Saving students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved multiple students");
	}

}

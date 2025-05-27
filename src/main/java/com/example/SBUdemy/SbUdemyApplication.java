package com.example.SBUdemy;

import com.example.SBUdemy.DAO.StudentDAO;
import com.example.SBUdemy.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class SbUdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbUdemyApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			deleteAllStudents(studentDAO);
		};
	}
	private void deleteAllStudents(StudentDAO StudentDAO) {
		StudentDAO.deleteAll();
	}
	private void deleteStudent(StudentDAO StudentDAO) {
		StudentDAO.delete(1);
	}

	private void updateStudent(StudentDAO StudentDAO) {
		Student student = StudentDAO.findById(1);
		student.setFirstName("John");
		StudentDAO.update(student);
	}

	private void queryForStudentsByLastName(StudentDAO StudentDAO) {
		List<Student> students = StudentDAO.findByLastName("Dinh");
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}

	private void queryForStudents(StudentDAO StudentDAO) {
		List<Student> students = StudentDAO.findAll();
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Finding Student: ");
		Student student = studentDAO.findById(1);
		System.out.println("Student found: " + student.toString());

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

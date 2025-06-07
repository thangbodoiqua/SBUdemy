package com.example.SBUdemy.rest;

import com.example.SBUdemy.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
         theStudents = new ArrayList<>();
        theStudents.add(new Student("Poornimaa", "Patel"));
        theStudents.add(new Student("Mario", "Rossi"));
        theStudents.add(new Student("Mary", "Smith"));
    }

    @GetMapping("/students")
    public List<Student> getStudent() {
        return theStudents;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {

        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found " + studentId);
        }

        return theStudents.get(studentId);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException e) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(Exception e) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

package com.example.SBUdemy.rest;

import com.example.SBUdemy.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return theStudents.get(studentId);
    }
}

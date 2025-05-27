package com.example.SBUdemy.DAO;
import com.example.SBUdemy.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer theId);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student theStudent);
    void delete(Integer theId);
    int deleteAll();
}

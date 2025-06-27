package com.example.SBUdemy.DAO;

import com.example.SBUdemy.entity.Instructor;
import com.example.SBUdemy.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);
}

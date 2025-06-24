package com.example.SBUdemy.dao;

import com.example.SBUdemy.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!
    public List<Employee> findAllByOrderByLastName();
}

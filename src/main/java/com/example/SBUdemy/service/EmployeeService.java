package com.example.SBUdemy.service;

import java.util.List;

import com.example.SBUdemy.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
	
}

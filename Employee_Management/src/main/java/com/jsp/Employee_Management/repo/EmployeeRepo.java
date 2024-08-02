package com.jsp.Employee_Management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Employee_Management.entity.Employee;



public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	

}

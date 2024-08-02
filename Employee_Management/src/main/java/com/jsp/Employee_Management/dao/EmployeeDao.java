package com.jsp.Employee_Management.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Employee_Management.entity.Employee;
import com.jsp.Employee_Management.repo.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepo repo;
	
	public Employee saveEmployee(Employee e) {
		return repo.save(e);
	}
}

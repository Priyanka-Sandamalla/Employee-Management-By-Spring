package com.jsp.Employee_Management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Employee_Management.dto.EmployeeLogin;
import com.jsp.Employee_Management.entity.Employee;
import com.jsp.Employee_Management.repo.EmployeeRepo;


@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepo repo;
	
	public Employee saveEmployee(Employee e) {
		return repo.save(e);
	}
	


	public Employee fetchById(int id) {
		 Optional<Employee> ei = repo.findById(id);
		 if(ei.isPresent()) {
			return  ei.get();
		 }else {
			 return null;
		 }
	}
	
	public Employee deleteEmployee(int id) {
		Optional<Employee> u = repo.findById(id);
		repo.delete(u.get());
		return u.get();
	}
}

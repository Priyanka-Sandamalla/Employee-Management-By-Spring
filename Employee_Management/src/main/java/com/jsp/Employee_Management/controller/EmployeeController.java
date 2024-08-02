package com.jsp.Employee_Management.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Employee_Management.clone.EmployeeClone;
import com.jsp.Employee_Management.entity.Employee;
import com.jsp.Employee_Management.service.EmployeeService;


@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;
	@Autowired
	ModelMapper mapper;
	@PostMapping("/register")
	public EmployeeClone register(@RequestBody Employee e) {
		Employee register = service.saveEmp(e);
		try {
			 
			return m1(register); 
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
	
	@PostMapping("/emp")
	public EmployeeClone m1(@RequestBody Employee e) {
		
		 EmployeeClone c = mapper.map(e, EmployeeClone.class);
		return c;
		
	}
	 @PostMapping("/sendhtml")
		public String sendHtml(@RequestBody Employee emp) {
			try {
				service.sendHtmlEmail(emp);
				return "msg send successfully";
				
			}catch(Exception e){
				return "internal issue try again";
			}
		}
	

}

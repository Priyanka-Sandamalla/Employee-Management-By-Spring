package com.jsp.Employee_Management;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jsp.Employee_Management.entity.Employee;

@SpringBootApplication
public class EmployeeManagementApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
	@Bean
	public ModelMapper m1() {
		return new ModelMapper();
	}

}

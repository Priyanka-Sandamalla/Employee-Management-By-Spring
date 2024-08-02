package com.jsp.Employee_Management.clone;

import java.util.Date;

import lombok.Data;
@Data
public class EmployeeClone {
	 private int empId;
	 private String firstName;
	 private String lastName;
	 private Date dateOfBirth;
	 private String gender;
	 private int age;
	 private long phoneNumber;
	 private String email;
	 private String address;

}

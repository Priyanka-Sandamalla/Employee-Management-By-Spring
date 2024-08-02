package com.jsp.Employee_Management.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int empId;
	 private String firstName;
	 private String lastName;
	 private Date dateOfBirth;
	 private String gender;
	 private int age;
	 private long phoneNumber;
	 private String email;
	 private String password;
	 private String address;
	 @Lob
	@Column(columnDefinition = "LONGBLOB",length = 99999)
	 byte[] image;
	 @OneToMany(cascade = CascadeType.ALL)
	private List<EducationDetails> edu;
	 @OneToMany(cascade = CascadeType.ALL)
	 private List<Experience> exp;
	 
	 
	 
	

}

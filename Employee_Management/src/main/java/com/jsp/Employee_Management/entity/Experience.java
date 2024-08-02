package com.jsp.Employee_Management.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Experience {
	@Id
	private String experienceId;
    private String companyName;
    private String designation;
    private int yearsOfExperience;
    private int monthsOfExperience;
    
    

}

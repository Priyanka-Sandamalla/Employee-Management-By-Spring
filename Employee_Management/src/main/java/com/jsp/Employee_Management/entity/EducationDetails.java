package com.jsp.Employee_Management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class EducationDetails {
	@Id
	private int educationId;
    private String degree;
    private String stream;
    private String collegeName;
    private int yearOfPassing;
    private double percentage;
   

}

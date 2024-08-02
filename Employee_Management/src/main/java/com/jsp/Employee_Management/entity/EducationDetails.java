package com.jsp.Employee_Management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class EducationDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int educationId;
    private String degree;
    private String stream;
    private String collegeName;
    private int yearOfPassing;
    private double percentage;
   

}

package com.jsp.Employee_Management.util;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ResponseStructure<T> {
	private int stateCode;
	private  String message;
	private T data;
	private LocalDateTime time =LocalDateTime.now();
}

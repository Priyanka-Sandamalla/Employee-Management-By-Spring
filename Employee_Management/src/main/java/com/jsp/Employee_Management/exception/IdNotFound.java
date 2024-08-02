package com.jsp.Employee_Management.exception;

public class IdNotFound extends RuntimeException {
	String msg="id not found";

	public IdNotFound() {
		super();
	}

	public IdNotFound(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	
	

}

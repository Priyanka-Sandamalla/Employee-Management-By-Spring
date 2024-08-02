package com.jsp.Employee_Management.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.Employee_Management.util.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandlingForEmployee {
	 @ExceptionHandler(IdNotFound.class)
	    public ResponseEntity<ResponseStructure<String>> userNotFound(IdNotFound e) {
	        ResponseStructure<String> rs = new ResponseStructure<>();
	        rs.setStateCode(HttpStatus.NOT_FOUND.value());
	        rs.setData(e.getMsg());
	        rs.setMessage("id not found, please try again with new data..!");
	        return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
	    }
	

}

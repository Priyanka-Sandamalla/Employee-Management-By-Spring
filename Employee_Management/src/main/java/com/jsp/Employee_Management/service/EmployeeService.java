package com.jsp.Employee_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jsp.Employee_Management.dao.EmployeeDao;
import com.jsp.Employee_Management.entity.Employee;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
@Service
public class EmployeeService {
	@Autowired
	EmployeeDao dao;
	@Autowired
	JavaMailSender mailsender;
	
	public Employee saveEmp(Employee e) {
		return dao.saveEmployee(e);
	}
	
	public void sendHtmlEmail(Employee emp) throws MessagingException {
	    MimeMessage message = mailsender.createMimeMessage();

	    message.setFrom(new InternetAddress("priyankasandamalla3@gmail.com"));
	    message.setRecipients(MimeMessage.RecipientType.TO, "sandamallapriyanka@gmail.com");
	    message.setSubject("Test email from Spring");

	    String htmlContent = "<h1>This is a test Spring Boot email</h1>" +
	                         "<p>It can contain <strong>HTML</strong> content.</p>";
	    message.setContent(htmlContent, "text/html; charset=utf-8");

	    mailsender.send(message);
	}

}

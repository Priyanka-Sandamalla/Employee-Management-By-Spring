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
		Employee savedEmployee = dao.saveEmployee(e);
		 try {
	            sendHtmlEmail(e); 
	        } catch (MessagingException ex) {
	            ex.printStackTrace(); 
	        }
	        return savedEmployee;
	        
	}
	
	public void sendHtmlEmail(Employee emp) throws MessagingException {
	    MimeMessage message = mailsender.createMimeMessage();

	    message.setFrom(new InternetAddress("priyankasandamalla3@gmail.com"));
	    message.setRecipients(MimeMessage.RecipientType.TO, "sandamallapriyanka@gmail.com");
	    message.setSubject("Test email from Spring");

	    String htmlContent = "<h1>Hi...,</h1>" +
                "<p>Thank you for your interest in the <strong>Software Engineer</strong> position at <strong>Tech Mahindra</strong>. " +
                "We have received your application and appreciate the time you took to apply. " +
                "Our team will review your qualifications and get back to you if your profile matches our needs. " +
                "Thank you once again for considering a career with us. We encourage you to visit our <a href=\"[Careers Page URL]\">careers page</a> for future opportunities.</p>" +
                "<p><img src=\"https://e7.pngegg.com/pngimages/230/998/png-clipart-mahindra-mahindra-tech-mahindra-logo-mahindra-group-brand-tech-support-text-logo.png\" alt=\"Tech Mahindra Logo\" style=\"width: 150px; height: auto;\"></p>";

	    message.setContent(htmlContent, "text/html; charset=utf-8");

	    mailsender.send(message);
	}

}

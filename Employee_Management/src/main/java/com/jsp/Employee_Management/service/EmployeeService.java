package com.jsp.Employee_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jsp.Employee_Management.dao.EmployeeDao;
import com.jsp.Employee_Management.entity.Employee;
import com.jsp.Employee_Management.exception.IdNotFound;
import com.jsp.Employee_Management.util.ResponseStructure;


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
	    message.setRecipients(MimeMessage.RecipientType.TO, emp.getEmail());
	    message.setSubject("Test email from Spring");

	    String htmlContent = "<h1>Hi " +emp.getFirstName()+",</h1>"+
                "<p>Thank you for your interest in the <strong>Software Engineer</strong> position at <strong>Tech Mahindra</strong>. " +
                "We have received your application and appreciate the time you took to apply. " +
                "Our team will review your qualifications and get back to you if your profile matches our needs. " +
                "Thank you once again for considering a career with us. We encourage you to visit our <a href=\"[Careers Page URL]\">careers page</a> for future opportunities.</p>" +
                "<p><img src=\"https://e7.pngegg.com/pngimages/230/998/png-clipart-mahindra-mahindra-tech-mahindra-logo-mahindra-group-brand-tech-support-text-logo.png\" alt=\"Tech Mahindra Logo\" style=\"width: 150px; height: auto;\"></p>";

	    message.setContent(htmlContent, "text/html; charset=utf-8");

	    mailsender.send(message);
	}
	
	public ResponseEntity<ResponseStructure<Employee>> findById(int id){
		Employee db = dao.fetchById(id);
		if(db!=null) {
		ResponseStructure<Employee> rs = new ResponseStructure<Employee>();
		rs.setStateCode(HttpStatus.CREATED.value());
		rs.setData(dao.fetchById(id));
		rs.setMessage("id   find  Sucessfully..!");
		return new ResponseEntity<ResponseStructure<Employee>>(rs,HttpStatus.CREATED);
		}else {
			throw new IdNotFound();
		}
	}
	
	
	public ResponseEntity<ResponseStructure<Employee>> delete(int id) {
		
		ResponseStructure<Employee> rs = new ResponseStructure<Employee>();
		rs.setStateCode(HttpStatus.CREATED.value());
		rs.setData(dao.fetchById(id));
		rs.setMessage("id find  Sucessfully..!");
		return new ResponseEntity<ResponseStructure<Employee>>(rs,HttpStatus.CREATED);
	}
}

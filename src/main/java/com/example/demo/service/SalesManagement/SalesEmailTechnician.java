package com.example.demo.service.SalesManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.EmployeeManagement.Employee;
import com.example.demo.model.SalesManagement.Sales;

@Service
public class SalesEmailTechnician {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public SalesEmailTechnician(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	

	
	public void sendNotification(Sales tech) {
		SimpleMailMessage mail =  new SimpleMailMessage();
		
		
		//mail.setTo("isuriathapaththu@gmail.com");
		mail.setTo(tech.getEmail());
		
		System.out.print("Get email is working:"+tech.getEmail());
		mail.setFrom("springTestItp@gmail.com");
		mail.setSubject("You are Assinged for an order");
		mail.setText("This is a cool notification1234");
		//mail.setText(tech.getAvailability());
		System.out.println("Email send method");
		javaMailSender.send(mail);
	}
}

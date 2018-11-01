package com.example.demo.service.SalesManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.EmployeeManagement.Employee;
import com.example.demo.model.SalesManagement.Sales;

@Service
public class SalesEmailDriver {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public SalesEmailDriver(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	

	
	public void sendNotification(Sales driv) {
		SimpleMailMessage mail =  new SimpleMailMessage();
		
		
		//mail.setTo("isuriathapaththu@gmail.com");
		mail.setTo(driv.getEmail());
		
		System.out.print("Get email is working:"+driv.getEmail());
		mail.setFrom("springTestItp@gmail.com");
		mail.setSubject("You are Assinged for an order as a driver");
		mail.setText("This is a cool mail for a driver");
		//mail.setText(tech.getAvailability());
		System.out.println("Email send method Driver");
		javaMailSender.send(mail);
	}
}


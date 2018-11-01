package com.example.demo.service.VisitorManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.VisitorManagement.Visitor;

@Service
public class MailService {


	private JavaMailSender javaMailSender;
	
	
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendMail(Visitor visitor) {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(visitor.getMail());
		mail.setFrom("springboottest124@gmail.com");
		mail.setSubject("Confirmation Mail for Appointment");
		mail.setText("Dear Sir/Madam ,Your appointment has been confirmed");
		
		javaMailSender.send(mail);
		
		}
}

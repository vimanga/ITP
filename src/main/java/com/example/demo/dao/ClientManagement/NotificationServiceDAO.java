package com.example.demo.dao.ClientManagement;
/*package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.example.demo.model.User;

public class NotificationServiceDAO {

	private JavaMailSender javamailsender;
	
	@Autowired
	public NotificationServiceDAO(JavaMailSender javamailsender) {
		
		this.javamailsender = javamailsender;
	}
	
	public void sendNotification(User user) throws MailException {
		//send email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setFrom("");
		mail.setSubject("");
		mail.setText("");
		
		javamailsender.send(mail);
		
	}
}*/

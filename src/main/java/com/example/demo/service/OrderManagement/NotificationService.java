package com.example.demo.service.OrderManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.OrderManagement.ClientOrder;

@Service
public class NotificationService {

	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;
	}
	
	public void sendNotification(ClientOrder clientOrder) throws MailException{
		//send mail
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(clientOrder.getEmail());
		mail.setFrom("vimanga97@gmail.com");
		mail.setSubject("Automated Barcode Solutions");
		mail.setText("order placed");
		
		javaMailSender.send(mail);
	}
}

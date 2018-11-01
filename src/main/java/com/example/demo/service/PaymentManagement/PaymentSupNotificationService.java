package com.example.demo.service.PaymentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import com.example.demo.model.PaymentManagement.SupplierPayment;

@Service
public class PaymentSupNotificationService {

	
private JavaMailSender javaMailSender;
	
	@Autowired
	public void NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;
	}
	
	public void sendNotification(SupplierPayment supplierpayment) throws MailException{
		//send mail
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(supplierpayment.getEmail());
		mail.setFrom("deshanshehantha@gmail.com");
		mail.setSubject("Automated Barcode Solutions");
		mail.setText("Payment Issued! Thank You!");
		
		javaMailSender.send(mail);
	}
	
	
}

package com.example.demo.controller.ClientManagement;
/*package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.NotificationServiceDAO;
import com.example.demo.model.User;

@RestController
public class EmailController {

	@Autowired
	private NotificationServiceDAO notificationServicedao;
	
	@RequestMapping("/signup")
	public String signup() {
		
		return "";
	}
	
	@RequestMapping("/signup-success")
	public String signupSuccess() {
	
		//create the user
		User user = new User();
		user.setFirstName("Sandali");
		user.setLastName("Upeka");
		user.setEmailAddress("sandaliupeka96@gmail.com");
		
		
		//send a notification
		try {
			notificationServicedao.sendNotification(user);
		}catch(MailException e) {
			//catch error
		}
		
		return "";
		
	}
}*/

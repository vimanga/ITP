package com.example.demo.controller.OrderManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class OrderDashboardController {

	
	
			@RequestMapping("/dashboard")
			public String SignIn() 
				{
					return "/OrderManagement/OrderManagementDashboard";
				}
		
		
			
			
}

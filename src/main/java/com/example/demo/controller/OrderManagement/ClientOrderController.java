package com.example.demo.controller.OrderManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.OrderManagement.ClientOrderDao;
import com.example.demo.model.OrderManagement.ClientOrder;
import com.example.demo.service.OrderManagement.NotificationService;

@Controller
public class ClientOrderController {
	
	@Autowired
	private NotificationService notificationService;

//	@RequestMapping("ClientOrder")
//	public String SignIn() 
//  	{
//			return "ClientOrder.jsp";
//		}
	
	@Autowired
	public ClientOrderDao clientorderdao;
	
	@RequestMapping(value="/ClientOrder",method=RequestMethod.GET)
	public String register(ModelMap model) {
	
		ClientOrder clientorder = new ClientOrder();
		model.addAttribute("clientorder",clientorder);
		return "/OrderManagement/ClientOrder";
	}
	
	@RequestMapping(value="/submit",method=RequestMethod.POST)
	public String enterData(@Valid ClientOrder clientorder,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
		System.out.println("id............."+ clientorder.getId());
		System.out.println("location............."+ clientorder.getLocation());
		System.out.println("item............."+ clientorder.getItem());
		System.out.println("quantity............."+ clientorder.getQuantity());
		System.out.println("date............."+ clientorder.getExdate());
		///////////////////////////////////////
		try {
			notificationService.sendNotification(clientorder);
		}catch(MailException e){
			
		}
//		if(result.hasErrors()) {
//			
//			return "ClientOrder.jsp";
//		}
		clientorderdao.save(clientorder);
		List<ClientOrder> list= clientorderdao.getClientOrder();
		model.addAttribute("list", list);
		return "/OrderManagement/ViewClientOrder";
		}
	
	
//	@RequestMapping(value="/new",method=RequestMethod.GET)
//	public String done() {
	
//		return "ClientOrder.jsp";
//	}
	
	
}

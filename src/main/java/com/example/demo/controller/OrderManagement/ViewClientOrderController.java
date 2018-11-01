package com.example.demo.controller.OrderManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.OrderManagement.ClientOrderDao;
import com.example.demo.model.OrderManagement.ClientOrder;
@Controller
public class ViewClientOrderController {
	
	
	@Autowired
	public ClientOrderDao clientorderdao;
	
	@RequestMapping(value="/ViewClientOrder",method=RequestMethod.GET)
	public ModelAndView editProfile() 
		{
			List<ClientOrder> list= clientorderdao.getClientOrder();
			
			return new ModelAndView("/OrderManagement/ViewClientOrder","list",list);
		}
}

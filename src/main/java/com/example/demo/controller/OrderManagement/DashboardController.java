package com.example.demo.controller.OrderManagement;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.OrderManagement.ClientOrderDao;
import com.example.demo.dao.OrderManagement.DashboardDao;
import com.example.demo.model.OrderManagement.ClientOrder;
import com.example.demo.model.OrderManagement.DashboardCount;
@Controller
public class DashboardController {

	@Autowired
	public DashboardDao dashboardDao;
	
	@Autowired
	public ClientOrderDao clientorderdao;
	

	
	@RequestMapping(value="/orderdashboard",method=RequestMethod.GET)
	public ModelAndView viewdashboard() 
		{
			List<DashboardCount> list= dashboardDao.Dashboard();
			List<ClientOrder> list1= dashboardDao.Dashboard2();
			

		ModelAndView mv = new ModelAndView("/OrderManagement/OrderManagementDashboard");
	    
	   mv.addObject("list", list);
	   mv.addObject("list1", list1);
		
		return mv;
		}
	
		
}

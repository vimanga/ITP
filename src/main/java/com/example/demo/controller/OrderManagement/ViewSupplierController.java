package com.example.demo.controller.OrderManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.OrderManagement.SupplierDao;
import com.example.demo.model.OrderManagement.Supplier;

@Controller
public class ViewSupplierController {

	@Autowired
	public SupplierDao supplierDao;
	
	@RequestMapping(value="/ViewSupplier",method=RequestMethod.GET)
	public ModelAndView ViewOrders() {
		List<Supplier> list = supplierDao.getSupplier();
		
		return new ModelAndView("/OrderManagement/ViewSuppliers","list",list);
	}
}

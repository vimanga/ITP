package com.example.demo.controller.OrderManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.OrderManagement.SupplierOrderDao;
import com.example.demo.model.PaymentManagement.SupplierOrder;

@Controller
public class ViewSupplierOrderController {

	@Autowired
	public SupplierOrderDao supplierOrderDao;
	
	@RequestMapping(value="/ViewSupplierOrder",method=RequestMethod.GET)
	public ModelAndView ViewOrders() {
		List<SupplierOrder> list = supplierOrderDao.getSupplierOrder();
		
		return new ModelAndView("/OrderManagement/ViewSupplierOrder","list",list);
	}
	
}

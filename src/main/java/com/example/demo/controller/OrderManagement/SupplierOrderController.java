package com.example.demo.controller.OrderManagement;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.OrderManagement.SupplierOrderDao;
import com.example.demo.model.PaymentManagement.SupplierOrder;

@Controller
public class SupplierOrderController {

//	@RequestMapping("SupplierOrder")
//	public String SignIn() 
//		{
//			return "SupplierOrder.jsp";
//		}
	
	@Autowired
	public SupplierOrderDao supplierorderdao;
	
	@RequestMapping(value="/SupplierOrder",method=RequestMethod.GET)
	public String register(ModelMap model) {
		SupplierOrder supplierorder = new SupplierOrder();
		model.addAttribute("supplierorder",supplierorder);
		return "/OrderManagement/SupplierOrder";
	}
	
	@RequestMapping(value="/submit1",method=RequestMethod.POST)
	public String enterData(@Valid SupplierOrder supplierorder,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
		System.out.println("id............."+ supplierorder.getId());
		System.out.println("location............."+ supplierorder.getLocation());
		System.out.println("item............."+ supplierorder.getItem());
		System.out.println("quantity............."+ supplierorder.getQuantity());
		System.out.println("date............."+ supplierorder.getDate());
		///////////////////////////////////////
//		if(result.hasErrors()) {
//			
//			return "ClientOrder.jsp";
//		}
		supplierorderdao.save(supplierorder);
		List<SupplierOrder> list= supplierorderdao.getSupplierOrder();
		model.addAttribute("list", list);
		return "/OrderManagement/ViewSupplierOrder";
//		return "SignIn.jsp";
		}
	
}

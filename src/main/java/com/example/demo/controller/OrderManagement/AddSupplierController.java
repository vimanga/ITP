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

import com.example.demo.dao.OrderManagement.SupplierDao;
import com.example.demo.model.OrderManagement.Supplier;

@Controller
public class AddSupplierController {


	
//	@RequestMapping("AddSupplier")
//	public String AddSupplier() 
//  	{
//			return "AddSupplier.jsp";
//		}
	
	@Autowired
	public SupplierDao supplierDao;
	
	@RequestMapping(value="/AddSupplier",method=RequestMethod.GET)
	public String register(ModelMap model) {
	
		Supplier supplier = new Supplier();
		model.addAttribute("supplier",supplier);
		return "/OrderManagement/AddSupplier";
	}
	
	
	@RequestMapping(value="/suppliersubmit",method=RequestMethod.POST)
	public String enterData(@Valid Supplier supplier,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
	
//		if(result.hasErrors()) {
//			
//			return "ClientOrder.jsp";
//		}
		supplierDao.save(supplier);
		List<Supplier> list= supplierDao.getSupplier();
		model.addAttribute("list", list);
		return "/OrderManagement/ViewSuppliers";
		}
	
}

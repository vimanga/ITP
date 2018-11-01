package com.example.demo.controller.OrderManagement;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.OrderManagement.SupplierDao;
import com.example.demo.model.OrderManagement.Supplier;

@Controller
public class EditSupplierController {

	@Autowired
	public SupplierDao supplierDao;
	
	@RequestMapping(value="/EditSupplier",method=RequestMethod.GET)
	public String Editsupplier(@RequestParam("id") int id, ModelMap model) 
		{
		Supplier supplier = supplierDao.EditSupplier(id);
		System.out.println(supplier);
		model.addAttribute("supplier", supplier);
			return "/OrderManagement/EditSupplier";
		}
	
	@RequestMapping(value="/editsuppliersubmit",method=RequestMethod.POST)
	public String enterData(@Valid Supplier supplier,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
		
//		if(result.hasErrors()) {
//			
//			return "ClientOrder.jsp";
//		}
		supplierDao.update(supplier);
		List<Supplier> list= supplierDao.getSupplier();
		model.addAttribute("list", list);
		return "/OrderManagement/ViewSuppliers";
		}
	@RequestMapping(value="/supplierDelete")
	public String deleteData(@RequestParam("id") int id, ModelMap model) {
//		if(result.hasErrors()) {
//			
//			return "ClientOrder.jsp";
//		}
		supplierDao.delete(id);
		List<Supplier> list= supplierDao.getSupplier();
		model.addAttribute("list", list);
		return "/OrderManagement/ViewSuppliers";
		}
	
}


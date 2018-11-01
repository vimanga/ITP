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

import com.example.demo.dao.OrderManagement.SupplierOrderDao;
import com.example.demo.model.OrderManagement.ClientOrder;
import com.example.demo.model.PaymentManagement.SupplierOrder;

@Controller
public class EditSupplierOrderController {
	
	@Autowired
	public SupplierOrderDao supplierOrderDao;

	@RequestMapping(value="/EditSupplierOrder",method=RequestMethod.GET)
	public String Editsupporder(@RequestParam("id") int id, ModelMap model) 
		{
		SupplierOrder supplierOrder = supplierOrderDao.EditSupplierOrder(id);
		System.out.println(supplierOrder);
		model.addAttribute("supplierOrder", supplierOrder);
			return "/OrderManagement/EditSupplierOrder";
		}
	
	@RequestMapping(value="/supOrdEditSubmit",method=RequestMethod.POST)
	public String enterData(@Valid SupplierOrder supplierOrder,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
		System.out.println("id............."+ supplierOrder.getId());
		System.out.println("location............."+ supplierOrder.getLocation());
		System.out.println("item............."+ supplierOrder.getItem());
		System.out.println("quantity............."+ supplierOrder.getQuantity());
		System.out.println("date............."+ supplierOrder.getDate());
//		if(result.hasErrors()) {
//			
//			return "ClientOrder.jsp";
//		}
		supplierOrderDao.update(supplierOrder);
		List<SupplierOrder> list= supplierOrderDao.getSupplierOrder();
		model.addAttribute("list", list);
		return "/OrderManagement/ViewSupplierOrder";
		}
	
	@RequestMapping(value="/supOrderDelete")
	public String deleteData(@RequestParam("id") int id, ModelMap model) {
//		if(result.hasErrors()) {
//			
//			return "ClientOrder.jsp";
//		}
		supplierOrderDao.delete(id);
		List<SupplierOrder> list= supplierOrderDao.getSupplierOrder();
		model.addAttribute("list", list);
		return "/OrderManagement/ViewSupplierOrder";
		}
	
	@RequestMapping(value="/proceedPayments")
	public String confirm(@RequestParam("id") int id, ModelMap model) {
		
		supplierOrderDao.payment(id);
		List<SupplierOrder> list= supplierOrderDao.getSupplierOrder();
		model.addAttribute("list", list);
		return "/OrderManagement/ViewSupplierOrder";
		}
}

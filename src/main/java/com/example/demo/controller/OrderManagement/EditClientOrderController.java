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

import com.example.demo.dao.OrderManagement.ClientOrderDao;
import com.example.demo.model.OrderManagement.ClientOrder;
@Controller
public class EditClientOrderController {
	
	@Autowired
	public ClientOrderDao clientorderdao;

	@RequestMapping(value="/EditClientOrder",method=RequestMethod.GET)
	public String SignIn(@RequestParam("id") int id, ModelMap model) 
		{
			ClientOrder clientOrder = clientorderdao.EditClientOrder(id);
			System.out.println(clientOrder);
			model.addAttribute("clientOrder", clientOrder);
			return "/OrderManagement/EditClientOrder";
		}
	
	
	@RequestMapping(value="/editSubmit",method=RequestMethod.POST)
	public String enterData(@Valid ClientOrder clientorder,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
		System.out.println("id............."+ clientorder.getId());
		System.out.println("location............."+ clientorder.getLocation());
		System.out.println("item............."+ clientorder.getItem());
		System.out.println("quantity............."+ clientorder.getQuantity());
		System.out.println("date............."+ clientorder.getExdate());
//		if(result.hasErrors()) {
//			
//			return "ClientOrder.jsp";
//		}
		clientorderdao.update(clientorder);
		List<ClientOrder> list= clientorderdao.getClientOrder();
		model.addAttribute("list", list);
		return "/OrderManagement/ViewClientOrder";
		}
	
	@RequestMapping(value="/delete")
	public String deleteData(@RequestParam("id") int id, ModelMap model) {
//		if(result.hasErrors()) {
//			
//			return "ClientOrder.jsp";
//		}
		clientorderdao.delete(id);
		List<ClientOrder> list= clientorderdao.getClientOrder();
		model.addAttribute("list", list);
		return "/OrderManagement/ViewClientOrder";
		}
	
	@RequestMapping(value="/confirmClientOrder")
	public String confirm(@RequestParam("id") int id, @RequestParam("item") int item, @RequestParam("quantity") int quantity, ModelMap model) {
		
		clientorderdao.confirm(id, item, quantity);
		List<ClientOrder> list= clientorderdao.getClientOrder();
		model.addAttribute("list", list);
		return "/OrderManagement/ViewClientOrder";
		}
	
	@RequestMapping(value="/pdfOrder")
	public String profilePdf() {
	
		return "/OrderManagement/report1";
	}
	
}

package com.example.demo.controller.InventoryManagement;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.InventoryManagement.InventoryDAO;
import com.example.demo.model.InventoryManagament.Inventory;

@Controller
public class InventoryController {
	@Autowired
	public InventoryDAO indao;
	
	@RequestMapping("editin")
	public String editDevice() {
		return "InventoryManagement/UpdateInventory";
	}
	
	@RequestMapping(value="iform",method=RequestMethod.GET)
	public String reg(ModelMap model) {
	
		Inventory inv = new Inventory();
		model.addAttribute("inventory",inv);
		return "InventoryManagement/InventoryForm";
	}	
	
	
	
	@RequestMapping(value="/iregister",method=RequestMethod.POST)
	public String enterDevice(@Valid Inventory inv,BindingResult result,ModelMap inventory,RedirectAttributes redirectAttributes) {
		
		//if(result.hasErrors()) {
			
			
		//}
		indao.save(inv);
		return "redirect:/iview";
		//return "redirect:/new";
		}
	
	@RequestMapping(value="/iview",method=RequestMethod.GET)  	
    public ModelAndView view(){  
        List<Inventory> list=indao.getAllInventory();
        return new ModelAndView("/InventoryManagement/ViewDevice","list",list);  
    } 
	
	@RequestMapping(value="/editin/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable int id, ModelMap model) {
		
		Inventory inv = indao.getInventoryById(id);
		System.out.println(id);
		System.out.println(inv.getInventoryID());
		model.addAttribute("inventory", inv);
		return "InventoryManagement/UpdateInventory";
	}
	
	@RequestMapping(value="/ieditsave",method=RequestMethod.POST)
	public ModelAndView editSave(@ModelAttribute("inventory") Inventory inv) {
		indao.update(inv);
		return new ModelAndView("redirect:/iview");
	}
	
	@RequestMapping(value="deletein/{id}")
	public String delete(@PathVariable int id) {
		indao.delete(id);
		return "redirect:/iview";
	}
	
	@RequestMapping(value="/inreport")
    public String reportone() {
    	return "/InventoryManagement/GeneralReport";
    }
	
	@RequestMapping(value="/invdash",method=RequestMethod.GET)
	public ModelAndView inventoryDashboard() {
		List<Inventory> CriticalList = indao.getCriticalInventory();
		return new ModelAndView("/InventoryManagement/InventoryDashboard", "CriticalList", CriticalList);
	}
}


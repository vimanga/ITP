package com.example.demo.controller.InventoryManagement;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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

import com.example.demo.dao.InventoryManagement.DeviceDAO;
import com.example.demo.model.InventoryManagament.Device;

@Controller
public class DeviceController {
	
	@Autowired
	public DeviceDAO devdao;
	
	@RequestMapping("editdev")
	public String editDevice() {
		return "/InventoryManagement/UpdateDevice";
	}
	
	@RequestMapping(value="/dform",method=RequestMethod.GET)
	public String reg(ModelMap model) {
	
		Device device = new Device();
		model.addAttribute("device",device);
		return "/InventoryManagement/DeviceRegistration";
	}	
	
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String enterDevice(@Valid Device dev,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
		
		//if(result.hasErrors()) {
			
			
		//}
		devdao.save(dev);
		return "redirect:/view";
		//return "redirect:/new";
		}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)  	
    public ModelAndView view(){  
        List<Device> list=devdao.getAllDevices();
        return new ModelAndView("/InventoryManagement/ViewInventory","list",list);  
    } 
	
	@RequestMapping(value="editdev/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable int id, ModelMap model) {
		
		Device dev = devdao.getDeviceById(id);
		System.out.println(id);
		model.addAttribute("device", dev);
		System.out.println(id);
		return "/InventoryManagement/UpdateDevice";
	}
	
	@RequestMapping(value="/editsaveinv",method=RequestMethod.POST)
	public ModelAndView editSave(@ModelAttribute("device") Device dev, BindingResult bindingResult) {
		devdao.update(dev);
		return new ModelAndView("redirect:/view");
	}
	
	@RequestMapping(value="deletedev/{id}")
	public String delete(@PathVariable int id, HttpServletResponse response) throws IOException {
		
		PrintWriter pw = response.getWriter();
		try {
			devdao.delete(id);
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert(\"Record in Inventory must be deleted first!\")");
			pw.println("location='/view'");
			pw.println("</script>");
		}
		
		return "redirect:/view";
	}
	
	
}


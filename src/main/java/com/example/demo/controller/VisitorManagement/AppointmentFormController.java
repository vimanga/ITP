package com.example.demo.controller.VisitorManagement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.VisitorManagement.VisitorDAO;
import com.example.demo.model.VisitorManagement.Visitor;
import com.example.demo.service.VisitorManagement.MailService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;

@Controller
public class AppointmentFormController 
{
	
	@Autowired 
	private MailService mailService;
	
	@Autowired
    public VisitorDAO visitordao;
	
   @RequestMapping(value="/appform",method=RequestMethod.GET)
   public String addapp(ModelMap model) {
   
   Visitor visitor = new Visitor();
   model.addAttribute("visitor",visitor);
   return "VisitorManagement/AppointmntForm";
   
   }
   
   @RequestMapping(value="/addapp",method=RequestMethod.POST)
   public String enterData(@Valid @ModelAttribute("visitor") Visitor visitor,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
	
//	   if(result.hasErrors()) {
//		   
//		   return "AppointmntForm.jsp";
//		   
//			
//		}
		visitordao.save(visitor);
		
		try {
			mailService.sendMail(visitor);
		    
		}catch(MailException e) {
			e.printStackTrace();
		}
		
	
		
		return "redirect:/alog";
		
		}
	
    

  
 
   	@RequestMapping("applog")
   	public String AppointmentLog() 
   	{
   		return "VisitorManagement/AppLog";
   	}
   	
	@RequestMapping("edit")
   	public String editform() 
   	{
   		return "VisitorManagement/EditForm";
   	}
   	

    @RequestMapping(value="/alog",method=RequestMethod.GET)
   public ModelAndView viewapps() {
    	ModelAndView modelview = new ModelAndView("VisitorManagement/AppLog");
    	List<Visitor> list =visitordao.getAllAppointments();
    	modelview.addObject("appointmnets",list);
    	return modelview;
    }
    	
   
   @RequestMapping(value="/alog/{pageid}")
   public ModelAndView view(@PathVariable int pageid) {
	     int total = 10;
	     if(pageid==1) {}
	     else {
	    	 pageid=(pageid-1) * total+1;
	     }
	     
	     List<Visitor> list = visitordao.getAllAppointmentsbypage(pageid,total);
	     
	     return new ModelAndView("alog","appointmnets",list);
   }
   

   
    
    
    @RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
    public String edapp(@PathVariable String id,ModelMap model) {
    
    Visitor visitor = visitordao.getAllAppointmentsbyid(id);
    model.addAttribute("edvisitor",visitor);
    return "VisitorManagement/EditForm";
    
    }
    
   
    
    @RequestMapping(value="/editapp",method=RequestMethod.POST)
    public ModelAndView editData(@ModelAttribute("edvisitor") Visitor v,BindingResult result,ModelMap model){
 	
 
 		visitordao.edit(v);
 		
 		return new ModelAndView("redirect:/alog");
 		
 	}
 	
    @RequestMapping(value = "/deleteapp/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable String id){
    	visitordao.deleteapp(id);
    	return new ModelAndView("redirect:/alog");
    }
    
   

   	@RequestMapping("vhome")
   	public String VisHome() 
   	{
   		return "VisitorManagement/HomeGraph";
   	}
   	

   	@RequestMapping("eventlog")
   	public String EventLog() 
   	{
   		return "VisitorManagement/EventLog";
   	}

    @RequestMapping(value="/evelog",method=RequestMethod.GET)
   public ModelAndView viewlog() {
    	ModelAndView modelview = new ModelAndView("VisitorManagement/EventLog");
    	List<Visitor> list =visitordao.getCount();
    	modelview.addObject("events",list);
    	return modelview;
    }
 
	@RequestMapping("monthlyrep")
   	public String report() 
   	{
   		return "VisitorManagement/VisitorPDF";
   	}

    
}




   




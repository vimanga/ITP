package com.example.demo.controller.FaultManagement;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.FaultManagement.FaultDao;
import com.example.demo.dao.FaultManagement.ServiceCallDao;
import com.example.demo.model.FaultManagement.Fault;
import com.example.demo.model.FaultManagement.ServiceCall;
import com.example.demo.model.FaultManagement.Technicianfault;

@Controller
public class ServiceCallController {

	
	@Autowired
	public ServiceCallDao servdao;
	
	@Autowired
	public FaultDao fadao;
	
	@RequestMapping("servicall")
	public String servcall() {
    	System.out.println("hbsdb");
		return "FaultManagementJsps/servicecallform";
	}
	
	@RequestMapping(value="/servicall/{id}",method=RequestMethod.GET)
	public String sercall(@PathVariable int id, ModelMap mod) {
		
		
		Fault fa= fadao.getFaultById(id);
		int cusid= fa.getCliID();
		ServiceCall sc = new ServiceCall(id, cusid);
		System.out.println(id);
		System.out.println(cusid);
		System.out.println(sc.getFauid());
		System.out.println(sc.getServiceID());
		System.out.println(sc.getFaultDesc());
		mod.addAttribute("sc", sc);
		return "FaultManagementJsps/servicecallform";
	}
	
	
	 
	/* It updates record for the given id in editfault page and redirects to /detail */  
	 @RequestMapping(value="/addto",method = RequestMethod.POST)  
	    public String savesercall(@Valid ServiceCall sca,BindingResult result, Model model,RedirectAttributes redirectAttributes){  
	    	System.out.println("id is"+sca.getFauid());
	    	
	    	servdao.save(sca);  
	    	return "redirect:/detail";  
	    } 
	 
	 
	 
	 @RequestMapping("servicedetailscom")
		public String servicedetail() {
			return "FaultManagementJsps/servicedetails";
		}
		
		@RequestMapping(value="/servicedetailscom/{id}",method=RequestMethod.GET)
		public String viewservice(@PathVariable int id, ModelMap model) {
			
			ServiceCall service= servdao.getServCallById(id);
			
			model.addAttribute("service", service);
			return "FaultManagementJsps/servicedetails";
		}
	 
		
		@RequestMapping("editservice")
		public String editformserv() {
			return "FaultManagementJsps/editserviceform";
		}
		
		@RequestMapping(value="/editservice/{servid}",method=RequestMethod.GET)
		public String editserv(@PathVariable int servid, ModelMap model) {
			
			ServiceCall edserv= servdao.getServCallById(servid);
			model.addAttribute("edserv", edserv);
			return "FaultManagementJsps/editserviceform";
		}
		 
		/* It updates record for the given id in editfault page and redirects to /detail */  
		 @RequestMapping(value="/editsaveserv",method = RequestMethod.POST)  
		    public ModelAndView editsaveserv(@Valid @ModelAttribute("edserv") ServiceCall edserv,BindingResult result, Model model){  
		    	System.out.println("id is"+edserv.getFauid());
		    	
		    	//if ( result.hasErrors()) {
		    		//return new ModelAndView("form");
		    	//}
		    	servdao.update(edserv);;  
		        return new ModelAndView("redirect:/detail");  
		    }
		 
		 @RequestMapping(value="servicecallPdf", method=RequestMethod.GET)
			public String servicePdf() {
			
				return "FaultManagementJsps/servicecallPDF";
			}
		 
}

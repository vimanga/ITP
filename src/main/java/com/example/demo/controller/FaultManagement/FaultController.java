package com.example.demo.controller.FaultManagement;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.FaultManagement.FaultDao;
import com.example.demo.dao.FaultManagement.ServiceCallDao;
import com.example.demo.dao.FaultManagement.Technician_faultDao;
import com.example.demo.model.FaultManagement.Fault;
import com.example.demo.model.FaultManagement.ServiceCall;
import com.example.demo.model.FaultManagement.Technicianfault;
import com.example.demo.service.FaultManagement.SendEmailClient;
import com.example.demo.service.FaultManagement.SendEmailTechnician;


@Controller
public class FaultController {

//	@RequestMapping("form")
//	public String SignIn() 
//		{
//			return "Form.jsp";
//		}
//	
	@Autowired
	public FaultDao faultdao;
	@Autowired
	public Technician_faultDao techdao;
	
	@Autowired
	public ServiceCallDao servdao;
	
	@Autowired
	public SendEmailTechnician sendemail;
	
	@Autowired
	public SendEmailClient sendclient;
	
	
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String register(ModelMap model) {
	
		Fault fault = new Fault();
		model.addAttribute("fault",fault);
		return "FaultManagementJsps/reportFault";
	}	
	@RequestMapping(value="/report",method=RequestMethod.POST)
	public String enterData(@Valid Fault fault,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
		
		//if(result.hasErrors()) {
			
			
		//}
		faultdao.save(fault);
		return "redirect:/detail";
		//return "redirect:/new";
		}
	
	//@RequestMapping("/viewdetails")
	//public String vdetails() {
		//return "viewdetails.jsp";
	//}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)  	
    public ModelAndView view(){  
        List<Fault> list=faultdao.getAllFaults();
        return new ModelAndView("FaultManagementJsps/viewdetails","list",list);  
    } 
	
	@RequestMapping(value="/pendingurgent",method=RequestMethod.GET)  	
    public ModelAndView viewurgent(){  
        List<Fault> list=faultdao.geturgentJobs();
        return new ModelAndView("FaultManagementJsps/pendingUrgent","list",list);  
    } 
	
	@RequestMapping(value="/todayj",method=RequestMethod.GET)  	
    public ModelAndView viewtoday(){  
        List<Fault> list=faultdao.gettodayjobs();
        return new ModelAndView("FaultManagementJsps/todayjobs","list",list);  
    }
	
	@RequestMapping(value="/finished",method=RequestMethod.GET)  	
    public ModelAndView viewfinished(){  
        List<Fault> list=faultdao.getAllfinishedFaults();
        return new ModelAndView("FaultManagementJsps/finishedjobs","list",list);  
    }
	
	
	/* It opens the faults list for the given page id */
	@RequestMapping(value="/viewdetails/{pageid}")  
    public ModelAndView edit(@PathVariable int pageid){  
        int total=10;  
        if(pageid==1){}  
        else{  
            pageid=(pageid-1)*total+1;  
        }  
        List<Fault> list=faultdao.getStudentsByPage(pageid,total);  
          
        return new ModelAndView("viewdetails","list",list);  
    }
	
	//@RequestMapping(value="/editf")
	//public String editfault() {
		//System.out.println("fuck");

		//return "editfault.jsp";
	//}
	
	/* It opens the record for the given id in editfault page */
	// @RequestMapping(value="/editfault/{id}",method= RequestMethod.GET)  
	  //  public String edit(@PathVariable int id,ModelMap model){  
		
		// 	System.out.println(id);
	      // Fault fault=faultdao.getStudentById(id);
	       //model.addAttribute("edfault", fault);

	       //return "/editfault";	        
	        
	    //}
	
	@RequestMapping("editfault")
	public String editform() {
		return "FaultManagementJsps/editfault";
	}
	
	@RequestMapping(value="/editfault/{faultid}",method=RequestMethod.GET)
	public String edit(@PathVariable int faultid, ModelMap model) {
		
		Fault fault= faultdao.getFaultById(faultid);
		model.addAttribute("edfault", fault);
		return "FaultManagementJsps/editfault";
	}
	 
	/* It updates record for the given id in editfault page and redirects to /detail */  
	 @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	    public ModelAndView editsave(@Valid @ModelAttribute("edfault") Fault fau,BindingResult result, Model model){  
	    	System.out.println("id is"+fau.getId());
	    	
	    	//if ( result.hasErrors()) {
	    		//return new ModelAndView("form");
	    	//}
	    	faultdao.update(fau);  
	        return new ModelAndView("redirect:/detail");  
	    } 
	 
	 @RequestMapping(value="/deletefault/{jobid}",method = RequestMethod.GET)  
	    public ModelAndView delete(@PathVariable int jobid){  
	    	faultdao.delete(jobid);  
	        return new ModelAndView("redirect:/detail");  
	    }  
	    
	      
	    @RequestMapping(value="/delete",method = RequestMethod.GET)  
	    public ModelAndView delete(){  
	    	faultdao.delete();  
	        return new ModelAndView("redirect:/form");  
	    }  

	    @RequestMapping("assign")
		public String assform() {
	    	System.out.println("DYSGDYD");
			return "FaultManagementJsps/assigntech";
		}
	    
	    @RequestMapping(value="/assign/{id}",method=RequestMethod.GET)
	    public String assign(@PathVariable int id,ModelMap model) {
	    	Technicianfault tech = new Technicianfault(id);
	    	//tech=techdao.getTechid(id);
	    	//System.out.println(id);
	    	System.out.println(tech.getFaulttechID());

	    	model.addAttribute("assFault", tech);
	    	return "FaultManagementJsps/assigntech";
	    }
	    
	    @RequestMapping(value="/ass",method=RequestMethod.POST)
		public String enter(@Valid Technicianfault tfault,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
			
			if(result.hasErrors()) {
			System.out.println("ksdfvdfbv");	
				return "Check and fill again";
			}
			techdao.save(tfault);
			return "redirect:/detail";
			//return "redirect:/new";
			}
	    
	    
	    @RequestMapping("viewtec")
	    public String vt() {
	    	return "FaultManagementJsps/viewassigned";
	    }
	    
	    @RequestMapping(value="/viewtec/{id}",method=RequestMethod.GET)  	
	    public String viewtech(@PathVariable int id,ModelMap model){  
	        Technicianfault tc=techdao.getTechid(id);
	        model.addAttribute("techf", tc);
	        return "FaultManagementJsps/viewassigned";  
	    } 
	    
	    @RequestMapping("editassign")
		public String editassi() {
			return "FaultManagementJsps/editAssigned";
		}
		
		@RequestMapping(value="/editassign/{id}",method=RequestMethod.GET)
		public String editassig(@PathVariable int id, ModelMap model) {
			
			Technicianfault tfault= techdao.getTechid(id);
			techdao.updatetech(id);
			model.addAttribute("edass", tfault);
			return "FaultManagementJsps/editAssigned";
		}
		 
		/* It updates record for the given id in editfault page and redirects to /detail */  
		 @RequestMapping(value="/saveassign",method = RequestMethod.POST)  
		    public ModelAndView saveassi(@Valid @ModelAttribute("edass") Technicianfault tfau,BindingResult result, Model model){  
		    	System.out.println("id is"+tfau.getFaultid());
		    	
		    	techdao.update(tfau);  
		        return new ModelAndView("redirect:/detail");  
		    } 
		 
		 @RequestMapping(value="/deleteassign/{id}",method = RequestMethod.GET)  
		    public ModelAndView deleteass(@PathVariable int id){  
		    	techdao.delete(id);  
		        return new ModelAndView("redirect:/detail");  
		    }
		 
	    @RequestMapping("email")
		public String emai() {
			return "/FaultManagementJsps/email";
		}
	    
	    @RequestMapping(value="/email/{id}",method=RequestMethod.GET)
	    public String ema(@PathVariable int id,ModelMap model) {
	    	
	    	Fault f = faultdao.getFaultById(id);
	    	Technicianfault t = techdao.getTechid(id);
	    	
	    	try {
	    	sendemail.sendTechEmail(f, t);
	    	}
	    	catch(MailException e) {
	    		
	    		System.out.println("siudnifdn");
	    		e.printStackTrace();
	    		
	    	}
	    	return "redirect:/detail";
	    }
	    
	    @RequestMapping("emailcus")
		public String emaiclient() {
			return "/FaultManagementJsps/emailcus";
		}
	    
	    @RequestMapping(value="/emailcus/{id}",method=RequestMethod.GET)
	    public String emailClient(@PathVariable int id,ModelMap model) {
	    	
	    	Fault f = faultdao.getFaultById(id);
	    	Technicianfault t = techdao.getTechid(id);
	    	ServiceCall servicecall= servdao.getServCallById(id);
	    	
	    	try {
	    		sendclient.sendClientEmail(f, t, servicecall);
	    	}
	    	catch(MailException e) {
	    		
	    		System.out.println("client email sent");
	    		e.printStackTrace();
	    		
	    	}
	    	return "redirect:/detail";
	    }
	    
	    
	    @RequestMapping(value="/faultdash", method=RequestMethod.GET)
	    public String dashboardfault() {
	    	
	    	return "FaultManagementJsps/FaultDashboard";
	    }
		
	    @RequestMapping(value="/monreport")
	    public String reportone() {
	    	return "FaultManagementJsps/MonthlyReport";
	    }
	    
	    @RequestMapping(value="/reports")
	    public String reports() {
	    	return "FaultManagementJsps/reports";
	    }
}

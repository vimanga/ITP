package com.example.demo.controller.ClientManagement;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.example.demo.dao.ClientManagement.ClientDAO;

import com.example.demo.model.ClientManagement.Client;



@Controller

public class ClientController {
	
	 

	@Autowired
	 

	public ClientDAO clientdao;
	
	 

	//-----------------------------------------------------------------------------------------------
	 
	//inside the AddClient.jsp
	 
	//call the AddClient page 
	
	 
	@RequestMapping(value = "/addClient",method = RequestMethod.GET)
	 
	public String newRegistration(ModelMap model) {
		
		
		Client client = new Client();
		
		model.addAttribute("client",client);
		
		
		return "ClientManagement/AddClient";
		
	 
	}
	 
	 

	//Save the client details in database by clicking the Add Client button and redirect to the client list page 
	 

	@RequestMapping(value="/save",method=RequestMethod.POST)
	
	 
	public String saveRegistration(@Valid Client client,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
		
		//if(result.hasErrors()) {
			
			
		//return "ClientManagement/AddClient";
		//}
		
		

		clientdao.save(client);
		
		return "redirect:/clientList";
	 
	}
	
	
	
	//------------------------------------------------------------------------------------------------
	
	//inside the ClientList.jsp 
	
	//get clientID and the compantName of all the clients from the database to the client list
	

	@RequestMapping(value="/clientList",method=RequestMethod.GET)
	
	public ModelAndView view() {
		
		

		List<Client> list = clientdao.getAllClients();
		
		
		return new ModelAndView("ClientManagement/ClientList","list",list);
		
	}
	
	
	
	
	
	//delete the selected client from the Client list
	

	@RequestMapping(value="/deleteclient")
	
	public String deleteData(@RequestParam("clientID") int clientID ,ModelMap model) {
		
		
		
			//if(result.hasErrors()) {
	    //		
				//return "AddClient";
		
			//}
		
		clientdao.delete(clientID);
		
		List<Client> list = clientdao.getAllClients();
		
		model.addAttribute("list",list);
		

		return "ClientManagement/ClientList";
		
	}
	
	

	

	//------------------------------------------------------------------------------------------------
	
	//inside the EditClientDeatils.jsp
	
	//call the EditClientDeatils.jsp page by clicking the Edit link in client List page
	

	@RequestMapping(value="/editClient",method=RequestMethod.GET)
	
	public String edit(@RequestParam("clientID") int clientID,ModelMap model) {
		
		

		Client client = clientdao.getClientupdate(clientID);
		
		model.addAttribute("client",client);
		
		return "ClientManagement/EditClientDetails";
	
	}
	
	

	//edit client details and save 
	
	@RequestMapping(value="/editsaveclient",method=RequestMethod.POST)
	
	public ModelAndView editSave(@ModelAttribute("client") Client client) {
		
		
		
		clientdao.update(client);
		
		return new ModelAndView("redirect:/clientList");
	
	}
	 
	

	//------------------------------------------------------------------------------------------------
	
	//call the profile page of one the selected client
	
	//return the profile page of the particular client when click the PROFILE link in the LinkList page
	

	@RequestMapping(value="/cprofile{id}",method=RequestMethod.GET)
	
	public String viewProfile(@RequestParam("clientID") int clientID ,ModelMap model) {
		
		
	
		Client client = clientdao.getDetails(clientID);
		
		model.addAttribute("client",client);
		
		return "ClientManagement/ClientProfile";
	
	}
	
	
	

	//------------------------------------------------------------------------------------------------	
	
	//EVENT LOG
	
	//call the EventLog page of one of selected client
/*	

	@RequestMapping(value = "/eventLog",method = RequestMethod.GET)
	
	public String eventlog(ModelMap model) {
					
		

		Client client = new Client();
		
		model.addAttribute("client",client);
		
		return "EventLog";
					
		
	}
	

	//get order details to the eventlog page
	

	@RequestMapping(value="/eventLog",method=RequestMethod.GET)
	
	public ModelAndView viewEventlog(@RequestParam("clientID") int clientID ,ModelMap model) {
			
		

		Client list = clientdao.getCleintOrderDetails(clientID);
		
		return new ModelAndView("EventLog","list",list);
			
	
	}*/
	
	
	
	

	@RequestMapping(value="/eventLog",method=RequestMethod.GET)
	
	public String viewEventlog(@RequestParam("clientID") int clientID ,ModelMap model) {
		
		

		Client client = clientdao.getCleintOrderDetails(clientID);
		
		model.addAttribute("client",client);
		
		return "ClientManagement/EventLog";
		
	
	}
		
	

	//------------------------------------------------------------------------------------------------	
	
	//NEWSLETTER
	
	//call the Newsletter page selecting from the drop down
	

	@RequestMapping(value = "/newsLetter",method = RequestMethod.GET)
	
	public String newsLetter(ModelMap model) {
					
		

		Client client = new Client();
		
		model.addAttribute("client",client);
		
		return "ClientManagement/Newsletter";
					
	
	}
	
	
	

	//------------------------------------------------------------------------------------------------
	
	//Add Branch
	
	//Add branch details of the client editing
		

	@RequestMapping(value="/addBranch",method=RequestMethod.GET)
		
	public String addBranch(@RequestParam("clientID") int clientID,ModelMap model) {
			
			
	
		Client client = clientdao.getDetails(clientID);
			
		model.addAttribute("client",client);
			
		return "ClientManagement/AddBranch";
		
	}
		
	
	

	//Add branch details of the client editing
	

	@RequestMapping(value="/savebranch",method=RequestMethod.POST)
    
	public String saveBranchDetails(@Valid Client client,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes,@RequestParam("clientID") int clientID) {
		

		//if(result.hasErrors()) {
			
			
		//return "ClientManagement/AddClient";
		//}
		
		

		clientdao.saveBranch(client,clientID);
		
		List<Client> list = clientdao.getAllBranchDetails(clientID);
		
		model.addAttribute("list", list);
		
		return "ClientManagement/BranchList";
	 }
	
	  

	//call the branch list page by clicking the drop down
     

	@RequestMapping(value="/branchList",method=RequestMethod.GET)
	 
	public String viewBranch() {
			
			

		return "ClientManagement/BranchList";
	 }	
		
	 
     

	@RequestMapping(value="/branchList/{id}",method=RequestMethod.GET)
	  
	public ModelAndView viewBranchDetails(@RequestParam("clientID") int ID) {
		
		

		List<Client> list = clientdao.getAllBranchDetails(ID);
		
		
		return new ModelAndView("ClientManagement/BranchList","list",list);
		
	}
	

	//------------------------------------------------------------------------------------------------
	

	//DASHBOARD 
	

	@RequestMapping(value="dashboardclient",method=RequestMethod.GET)
	public String Dashboard() {
			
		return "ClientManagement/ClientDashboard";
	
	}
	 
	
    
	
	//------------------------------------------------------------------------------------------------
	
	//ClientProfilePDF
	

	@RequestMapping(value="/profilePdf")
	
	public String profilePdf() {
	
		
		return "ClientManagement/ClientProfilePDF";
	
	}
	
	
	

	//------------------------------------------------------------------------------------------------
    
	

}

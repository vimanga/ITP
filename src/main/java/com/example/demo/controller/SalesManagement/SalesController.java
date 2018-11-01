package com.example.demo.controller.SalesManagement;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.SalesManagement.ClientOrderDAO;
import com.example.demo.dao.SalesManagement.InstallationCertificateDAO;
import com.example.demo.dao.SalesManagement.SalesDAO;
import com.example.demo.model.SalesManagement.ClientOrderSales;
import com.example.demo.model.EmployeeManagement.Employee;
import com.example.demo.model.SalesManagement.InstallationCertificate;
import com.example.demo.model.SalesManagement.Sales;
import com.example.demo.service.SalesManagement.SalesEmailDriver;
import com.example.demo.service.SalesManagement.SalesEmailTechnician;

@Controller
public class SalesController {
	@Autowired
	private InstallationCertificateDAO installationcertificatedao;
	@Autowired
	private ClientOrderDAO clientorderdao;
	@Autowired
	private SalesDAO salesdao;

	@Autowired
	SalesEmailTechnician salesemailtechnician;

	@Autowired
	SalesEmailDriver salesemaildriver;

	// ------------------------------------------Installation_Certificate-------------------------------------------------------

	// Display the Installation Certificate from
	@RequestMapping(value = "/installationcertificate/{id}", method = RequestMethod.GET)
	public String newInstallationCertificate(@PathVariable int id, ModelMap model) {
		InstallationCertificate installationcertificate = installationcertificatedao
				.getAllInstallationCertificateByID(id);

		model.addAttribute("installationcertificate", installationcertificate);

		return "SalesManagement/InstallationCertificate";
	}

	// When the submit button click this mapping will be called
	@RequestMapping(value = "/saveins", method = RequestMethod.POST)
	public String saveInstallation(
			@Valid @ModelAttribute("installationcertificate") InstallationCertificate installationcertificate,
			BindingResult result, @RequestParam("orID") String orID) {
		// if(result.hasErrors()) {
		// return "InstallationCertificate";
		// }
		installationcertificatedao.save(installationcertificate, orID);
		return "redirect:/viewinstallationcertificate";
	}

	// View All Installation Certificates
	@RequestMapping(value = "/viewinstallationcertificate", method = RequestMethod.GET)
	public ModelAndView view() {
		List<InstallationCertificate> list = installationcertificatedao.getAllInstallationCertificates();
		return new ModelAndView("SalesManagement/ViewInstallationCertificate", "list", list);
	}

	// Update Installation Certificate 01
	@RequestMapping("editinst")
	public String editinstallationcertificate() {
		return "SalesManagement/EditInstallationCertificate";
	}

	// Update Installation Certificate 02
	@RequestMapping(value = "/editinst/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, ModelMap model) {

		InstallationCertificate installationcertificate = installationcertificatedao
				.getAllInstallationCertificateByID(id);
		System.out.println(installationcertificate.getInstallationID());
		model.addAttribute("installationcertificate", installationcertificate);

		return "SalesManagement/EditInstallationCertificate";

	}

	// Update Installation Certificate 03
	@RequestMapping(value = "/editsaveins", method = RequestMethod.POST)
	public ModelAndView editSave(@Valid @ModelAttribute("installationcertificate") InstallationCertificate ic,
			BindingResult bindingResult, @RequestParam("installationCode") String installationCode) {
		System.out.println("Update 03 ID is:" + ic.getInstallationCode());
		installationcertificatedao.update(ic, installationCode);
		return new ModelAndView("redirect:/viewinstallationcertificate");
	}

	// Delete Installation Certificate by ID
	@RequestMapping(value = "/deleteinstallationcertificate/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		installationcertificatedao.delete(id);
		return new ModelAndView("redirect:/viewinstallationcertificate");
	}

	// Delete All Installation Certificate
	@RequestMapping(value = "/deleteinst", method = RequestMethod.GET)
	public ModelAndView delete() {
		installationcertificatedao.delete();
		return new ModelAndView("redirect:/viewinstallationcertificate");
	}

	// ----------------------------------------Add_Items----------------------------------------------------------------

	// Display the Add Items form
	@RequestMapping(value = "/additems/{id}", method = RequestMethod.GET)
	public String addItems(@PathVariable int id, ModelMap model) {
		System.out.println("Dis");
		InstallationCertificate installationcertificate = installationcertificatedao
				.getAllInstallationCertificateByID(id);
		model.addAttribute("additems", installationcertificate);
		System.out.println("Display the form of add items" + id);
		return "SalesManagement/AddItems";
	}

	// When the submit button click this mapping will be called and save the values
	// and redirect to viewinstallationcertificate
	@RequestMapping(value = "/addinst", method = RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("additems") InstallationCertificate installationcertificate,
			BindingResult result, @RequestParam("installationCode") String installationCode) {

		installationcertificatedao.saveItem(installationcertificate, installationCode);
		// return new ModelAndView("redirect:/viewinstallationcertificate/{id}") ;
		return new ModelAndView("redirect:/viewinstallationcertificate");

	}

	// Display the Add Items
	@RequestMapping(value = "/viewadditems/{id}", method = RequestMethod.GET)
	public ModelAndView viewItems(@Valid @ModelAttribute("additems") InstallationCertificate installationcertificate,
			BindingResult result, @PathVariable int id, ModelMap model) {

		InstallationCertificate additems = installationcertificatedao.getAllInstallationCertificateByID(id);
		model.addAttribute("additems", additems);
		System.out.println("Chek the jsp instaltion id" + additems.getInstallationID());
		System.out.println("Chek the jspvinsataid" + additems.getInstID());
		System.out.println("Chek the jsp devicies id" + additems.getDevicesId());
		List<InstallationCertificate> list = installationcertificatedao.getAddItemsByID(id);

		return new ModelAndView("SalesManagement/ViewAddItems", "list", list);
	}
	// Delete Add Items by ID
		@RequestMapping(value = "/deleteadditems/{id}", method = RequestMethod.GET)
		public ModelAndView deleteitemsbyid(@PathVariable int id) {
			installationcertificatedao.deleteitemsbyid(id);
			return new ModelAndView("redirect:/viewinstallationcertificate"); 
		}
	// --------------------------------------------------Client_Order-----------------------------------------------------------

	// View All Client Orders for the day
	@RequestMapping(value = "/viewclientorders", method = RequestMethod.GET)
	public ModelAndView vieworders() {
		List<ClientOrderSales> list = clientorderdao.getAllCleintOrders();
		return new ModelAndView("SalesManagement/ViewClientOrder", "list", list);
	}

	// Display client orders date rage form
	@RequestMapping(value = "/viewclientorders2", method = RequestMethod.GET)
	public String vieworders1(ModelMap model) {
		ClientOrderSales clientorder = new ClientOrderSales();
		model.addAttribute("range", clientorder);
		return "SalesManagement/ViewClientOrder2";
	}

	// When the Check order for the range button click this mapping will be called
	// and dispaly the orders for given date range
	@RequestMapping(value = "/getrange", method = RequestMethod.POST)
	public ModelAndView getRange(@Valid @ModelAttribute("range") ClientOrderSales clientorder, BindingResult result,
			@RequestParam("range_1") String range_1, @RequestParam("range_2") String range_2) {
		// if(result.hasErrors()) {
		// return "ViewClientOrder2";
		// }
		List<ClientOrderSales> list = clientorderdao.getAllCleintOrdersByRange(range_1, range_2);

		System.out.println("Get range after");
		return new ModelAndView("SalesManagement/ViewClientOrder3", "list", list);

	}

//--------------------------------------------Assign_Technicians------------------------------------------------------------------------------

	// View All Available Technicians for the day with form
	@RequestMapping(value = "/viewandassigntechnicians/{id}", method = RequestMethod.GET)
	public ModelAndView viewTechniciancs1(
			@Valid @ModelAttribute("assigntech") InstallationCertificate installationcertificate, BindingResult result,
			@PathVariable int id, ModelMap model) {
		Sales additems = clientorderdao.getOrdersByID(id);
		
		model.addAttribute("assigntech", additems);
		List<Employee> list = salesdao.getAllAvailableTechnicians();

		return new ModelAndView("SalesManagement/ViewAndAssignTechnicians", "list", list);
	}

// When the submit button click this mapping will be called and save the values and redirect to viewinstallationcertificate
	@RequestMapping(value = "/techassign", method = RequestMethod.POST)
	public String addTechnician(@Valid @ModelAttribute("assigntech") Sales sales, BindingResult result,
			@RequestParam("clienOrdID") int clienOrdID) {

		salesdao.saveTech(sales, clienOrdID);
		//salesdao.updateStausAssignTechnician(clienOrdID);
		System.out.println("Before Try Catch");
		try {
			salesemailtechnician.sendNotification(sales);
		} catch (MailException e) {
			// Catch error
			e.printStackTrace();
		}
		System.out.println("After Try Catch");

		return "redirect:/viewclientorders";
		// return new ModelAndView("ViewClientOrder");

	}
//--------------------------------------------Assign_Drivers------------------------------------------------------------------------------

	// View All Available Drivers for the day with form
	@RequestMapping(value = "/viewandassigndrivers/{id}", method = RequestMethod.GET)
	public ModelAndView viewDriver(
			@Valid @ModelAttribute("assigndrive") InstallationCertificate installationcertificate, BindingResult result,
			@PathVariable int id, ModelMap model) {
		Sales additems = clientorderdao.getOrdersByID(id);
		
		model.addAttribute("assigndrive", additems);
		List<Employee> list = salesdao.getAllAvailableDrivers();

		return new ModelAndView("SalesManagement/ViewAndAssignDrivers", "list", list);
	}

	// When the submit button click this mapping will be called and save the values
	// and redirect to viewclientorders
	@RequestMapping(value = "/driveassign", method = RequestMethod.POST)
	public String adddriver(@Valid @ModelAttribute("assigndrive") Sales sales, BindingResult result,
			@RequestParam("clienOrdID") int clienOrdID) {

		salesdao.saveDrive(sales, clienOrdID);
		//salesdao.updateStausAssignDriver(clienOrdID);
		System.out.println("Before Try Catch");
		try {
			salesemaildriver.sendNotification(sales);
		} catch (MailException e) {
			// Catch error
			e.printStackTrace();
		}
		System.out.println("After Try Catch");

		return "redirect:/viewclientorders";
		// return new ModelAndView("ViewClientOrder");

	}

//----------------------------------------------------Sales-----------------------------------------------------------

	// View All Sales Details(Done)
	@RequestMapping(value = "/viewsalesdetails", method = RequestMethod.GET)
	public ModelAndView viewSales() {
		List<Sales> list = salesdao.getAllSalesDetails();
		return new ModelAndView("SalesManagement/ViewSalesDetails", "list", list);
	}

	// Delete Sales Detail By ID
	@RequestMapping(value = "/deletesalesbyId/{id}", method = RequestMethod.GET)
	public ModelAndView deleteSalesbyID(@PathVariable int id) {
		salesdao.delete(id);
		return new ModelAndView("redirect:/viewsalesdetails");
	}

	// Delete All Sales Details
	@RequestMapping(value = "/deleteall", method = RequestMethod.GET)
	public ModelAndView deleteAll() {
		salesdao.delete();
		return new ModelAndView("redirect:/viewsalesdetails");
	}

	// Generate Total Amount by ID
	@RequestMapping(value = "/generateamount/{id}", method = RequestMethod.GET)
	public ModelAndView generateAmount(@PathVariable int id) {
		// installationcertificatedao.delete(id);
		salesdao.generateAmountByID(id);
		return new ModelAndView("redirect:/viewsalesdetails");
	}

	// Update Status completed by ID
	@RequestMapping(value = "/updatestatuscom/{id}", method = RequestMethod.GET)
	public ModelAndView updateStausCompleted(@PathVariable int id) {

		salesdao.updateStatusCompletedByID(id);
		return new ModelAndView("redirect:/viewsalesdetails");
	}

	// Update Status pending by ID
	@RequestMapping(value = "/updatestatuspen/{id}", method = RequestMethod.GET)
	public ModelAndView updateStausPending(@PathVariable int id) {

		salesdao.updateStatusPendingByID(id);
		return new ModelAndView("redirect:/viewsalesdetails");
	}
	// Update Payment Status pending by ID
		@RequestMapping(value = "/payment_status/{id}", method = RequestMethod.GET)
		public ModelAndView updateStausPayment(@PathVariable int id) {

			salesdao.updateStausPayment(id);
			return new ModelAndView("redirect:/viewclientorders");
		}
		
//------------------------------------------SalesDashBord----------------------------------------------------------------------------

	@RequestMapping(value = "/salesdashbord", method = RequestMethod.GET)
	public ModelAndView salesDashBord() {
		//List<ClientOrder> list = clientorderdao.getAllCleintOrders();
		List<Sales> list = salesdao.getPendingSalesDetails();
		return new ModelAndView("SalesManagement/SalesDashBord", "list", list);

	}
//--------------------------------------------------Installation Certificate Report---------------------------------------
	@RequestMapping(value="/InstallationCertificatePDF")
	public String InstallationPdf() {
	
		return "SalesManagement/InstallationCertificatePDF";
	}
	
	
//--------------------------------------------------Orders For Range Report---------------------------------------
		@RequestMapping(value="/ordersforrangepdf")
		public String OrdersForRangePdf() {
		
			return "SalesManagement/OrdersForRangePDF";
		}
		
//--------------------------------------------------Today Completed Orders Report---------------------------------------
				@RequestMapping(value="/TodayCompletedOrdersPdf")
				public String TodayCmpletedOrdersPdf() {
				
					return "SalesManagement/TodayCompletedOrdersPDF";
				}
				


}





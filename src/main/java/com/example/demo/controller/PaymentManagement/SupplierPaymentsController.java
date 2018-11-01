package com.example.demo.controller.PaymentManagement;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.PaymentManagement.OrderDAO;
import com.example.demo.dao.PaymentManagement.SupplierPaymentDAO;
import com.example.demo.model.PaymentManagement.ClientCashPayments;
import com.example.demo.model.PaymentManagement.ClientChequePayments;
import com.example.demo.model.PaymentManagement.Order;
import com.example.demo.model.PaymentManagement.PettyCashRegister;
import com.example.demo.model.PaymentManagement.Sales;
import com.example.demo.model.PaymentManagement.SupplierOrder;
import com.example.demo.model.PaymentManagement.SupplierPayment;
import com.example.demo.service.PaymentManagement.PaymentSupNotificationService;

@Controller
public class SupplierPaymentsController {

	
	@Autowired
	private SupplierPaymentDAO supplierpay; 
	
	@Autowired
	private OrderDAO suporder;
	
	@Autowired
	private PaymentSupNotificationService mailfunc;
	
	
	
	
	
	@RequestMapping("/proceedToSupplierOrder")
	public ModelAndView proceedSpplierOrder() {
		
		SupplierPayment sup  = new SupplierPayment();
		
		return new ModelAndView("/PaymentManagement/Supplier_Payment","supplierPayments",sup);
		
	}
	
	@RequestMapping(value = "/supplierPaySave", method = RequestMethod.POST)
	public String savetoRegister(@Valid SupplierPayment sup, BindingResult result, ModelMap model,
			RedirectAttributes redirectattributes) {

		if (result.hasErrors()) {
			return "/PaymentManagement/Supplier_Payment";
		}

		
		supplierpay.Savesupplierpayments(sup);
		mailfunc.sendNotification(sup);
		
		return "redirect:/Supplier_Payment_Register";

	}
	
	@RequestMapping(value = "/Supplier_Payment_Register")
	private ModelAndView SupRegister() {

		System.out.println("Goosup");
		List<SupplierPayment> list = supplierpay.getSupplierRegister();
		return new ModelAndView("/PaymentManagement/Supplier_Payment_Register", "list", list);
	}

	
	
	@RequestMapping(value = "/deletesuppayentry/{id}", method = RequestMethod.GET)
	public ModelAndView delete1(@PathVariable int id) {
		supplierpay.deleteEntry(id);
		return new ModelAndView("redirect:/Supplier_Payment_Register");
	}
	
	
	
	
	
	
	
	@RequestMapping("/supplierPayreport")
	public String pettycashregisterreport() {
		
		
		return "/PaymentManagement/Supplier_Pay_Report";
		
		
	}
	
	
	

	@RequestMapping("/mainPaymentDashboard")
	public String paymentdash() {
		
		return "/PaymentManagement/Payment_Dashboard";
		
	}
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "proceedsupPayments/{id}" ,method = RequestMethod.GET)
	private ModelAndView ContinuesuplierorPayments(@PathVariable int id,ModelMap model) {

		SupplierOrder sup = new SupplierOrder();

		sup = suporder.getSuplierOrderById(id);
		
		SupplierPayment suppay = new SupplierPayment();
		suppay.setAmount(sup.getAmount());
		suppay.setBank("");
		suppay.setChequeNumber(0);
		suppay.setDate("");
		suppay.setSupName("");
		suppay.setSupOrderID(sup.getSid());
		
	
		
		


		return new ModelAndView("/PaymentManagement/Supplier_Payment","supplierPayments",suppay);
		
	}
	///////////////////////////////////////////////////////////////////////////////////
	
	
	
	
}

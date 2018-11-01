package com.example.demo.controller.PaymentManagement;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.example.demo.dao.PaymentManagement.ClientPaymentsDAO;
import com.example.demo.dao.PaymentManagement.OrderDAO;
import com.example.demo.dao.PaymentManagement.SalesDAO1;
import com.example.demo.model.PaymentManagement.ClientCashPayments;
import com.example.demo.model.PaymentManagement.ClientChequePayments;
import com.example.demo.model.PaymentManagement.Order;
import com.example.demo.model.PaymentManagement.Sales;

@Controller
public class ClientPaymentsController {

	@Autowired
	private ClientPaymentsDAO client;

	@Autowired
	private SalesDAO1 sales;
	
	@Autowired
	private OrderDAO order;

	@RequestMapping(value = "/cashPayments", method = RequestMethod.GET)
	private String NewCustomerCashPayment(ModelMap model) {

		ClientCashPayments c = new ClientCashPayments();
		model.addAttribute("clientCashPayments", c);
		System.out.println("Goo");
		return "/PaymentManagement/Cash_Payments";
	}

	@RequestMapping(value = "/cashPaySave", method = RequestMethod.POST)
	public ModelAndView savetoCashPayment(@Valid ClientCashPayments p, HttpServletRequest request,HttpServletResponse response,BindingResult result, ModelMap model,
			RedirectAttributes redirectattributes) {

		if (result.hasErrors()) {
			return new ModelAndView ("/PaymentManagement/Cash_Payments");
		}
		else {
		System.out.println("here");
		client.Save(p);

		
		request.getSession().setAttribute("id", p.getSalesId());
		
		return new ModelAndView("/PaymentManagement/CashInvoice");
		
		}
	
		
		
		

	}

	@RequestMapping(value = "/allCashPayments")
	private ModelAndView FindAllCashPayments() {

		System.out.println("Goo");
		List<ClientCashPayments> list = client.getAllCashPayments();
		return new ModelAndView("/PaymentManagement/All_Cash_Payments", "list", list);
	}

	@RequestMapping(value = "/chequePayments", method = RequestMethod.GET)
	private String newClientChequePayment(ModelMap model) {

		System.out.println("Goo");
		ClientChequePayments client = new ClientChequePayments();

		model.addAttribute("clientChequePayments", client);

		return "/PaymentManagement/Cheque_Payments";

	}

	@RequestMapping(value = "/chequePaySave", method = RequestMethod.POST)
	public ModelAndView savetoChequePayment(@Valid ClientChequePayments p, HttpServletRequest request,HttpServletResponse response,BindingResult result, ModelMap model,
			RedirectAttributes redirectattributes) {

		if (result.hasErrors()) {
			return new ModelAndView( "/PaymentManagement/Cheque_Payments");
		}

		System.out.println("here");
		client.saveCheque(p);
		
		request.getSession().setAttribute("id", p.getSalesId());
		
		return new ModelAndView("/PaymentManagement/ChequeInvoice");
		
		
	

	}

	@RequestMapping(value = "/payment_status_client/{id}",method = RequestMethod.GET)
	private ModelAndView ContinuePayments(@PathVariable String id) {

		Order or = new Order();
		Sales s = new Sales();

		s = sales.getSalesById(id);
		
		System.out.print("===adassa==="+s.orID);
		or = order.getOrderById(s.orID);
		
		
		
		if (or.payType.equals("Cash")) {

			ClientCashPayments cash = new ClientCashPayments();
			cash.setDate(s.getDate());
			cash.setAmount(s.getTotalAmount());
			cash.setSalesId(s.getSalesID());
			cash.setCustomerName("");
			cash.setDiscount(0.0);

			return new ModelAndView("/PaymentManagement/Cash_Payments", "clientCashPayments", cash);
		} else if (or.payType.equals("Cheque")) {

			ClientChequePayments cheque = new ClientChequePayments();

			cheque.setAmount(s.getTotalAmount());
			cheque.setBank("");
			cheque.setBankedDate("");
			cheque.setChequeNumber(0);
			cheque.setCustomerName("");
			cheque.setSalesId(s.getSalesID());
			cheque.setStatus("");

			return new ModelAndView("/PaymentManagement/Cheque_Payments", "clientChequePayments", cheque);
		}

		else {

			return new ModelAndView("/PaymentManagement/Payment_Home");
		}

	}

	@RequestMapping(value = "/Sales_Last")
	private String LastSalesPage() {

		System.out.println("Goo");

		return "/PaymentManagement/Sales_Last";
	}
	
	
	
	
	@RequestMapping("/clientCashDashboard")
	public String clientpaymentdash() {
		
		return "/PaymentManagement/Client_Payment_Dashboard";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

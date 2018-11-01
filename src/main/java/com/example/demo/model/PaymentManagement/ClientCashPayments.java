package com.example.demo.model.PaymentManagement;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
public class ClientCashPayments {

	
	@Id
	@NotNull
	private int cashPayId;
	
	@NotEmpty(message="Cannot be Empty")
	private String date;
	
	@NotNull(message="Cannot be empty")
	private int salesId;
	
	@NotNull(message="Cannot be empty")
	private double amount;
	
	
	@NotEmpty(message ="Cannot be empty")
	private String customerName;
	
	@NotNull(message="Cannot be empty")
	private double discount;
	
	private String paycode;

	public String getPaycode() {
		return paycode;
	}

	public void setPaycode(String paycode) {
		this.paycode = paycode;
	}

	public int getCashPayId() {
		return cashPayId;
	}

	public void setCashPayId(int cashPayId) {
		this.cashPayId = cashPayId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getSalesId() {
		return salesId;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

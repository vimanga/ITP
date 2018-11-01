package com.example.demo.model.PaymentManagement;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class ClientChequePayments {

	
	@Id
	private int clientChequeId;
	
	@NotEmpty(message="cannot be  Empty!")
	private String date;
	
	@NotNull
	private int salesId;
	
	@NotEmpty( message="cannot be  Empty!")
	private String customerName;
	
	@NotNull
	private int chequeNumber;
	
	@NotEmpty( message="cannot be  Empty!")
	private String bankedDate;
	
	@NotEmpty( message="cannot be  Empty!")
	private String bank;
	
	@NotEmpty( message="cannot be  Empty!")
	private String status;
	
	@NotNull
	private double amount;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getClientChequeId() {
		return clientChequeId;
	}

	public void setClientChequeId(int clientChequeId) {
		this.clientChequeId = clientChequeId;
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(int chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	public String getBankedDate() {
		return bankedDate;
	}

	public void setBankedDate(String bankedDate) {
		this.bankedDate = bankedDate;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}

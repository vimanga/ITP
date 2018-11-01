package com.example.demo.model.PaymentManagement;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SupplierPayment {
	
	@Id
	private int supplierpayID;
	
	private String date;
	
	private int supOrderID;
	
	private int amount;
	
	private String supName;
	
	private int chequeNumber;
	
	private String bank;
	
	private String Email;

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getSupplierpayID() {
		return supplierpayID;
	}

	public void setSupplierpayID(int supplierpayID) {
		this.supplierpayID = supplierpayID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getSupOrderID() {
		return supOrderID;
	}

	public void setSupOrderID(int supOrderID) {
		this.supOrderID = supOrderID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public int getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(int chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}
	

}

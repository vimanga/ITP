
package com.example.demo.model.PaymentManagement;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity 
public class PettyCashRegister implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @NotNull
	private int pettyCashId;
	
	@NotEmpty(message="Field Cannot be Empty!")
	private String date;
	
	
	@NotNull(message="Field Cannot be Empty!")
	private double amount;
	
	
	@NotNull(message="Field Cannot be Empty!")
	private int employeeId;
	
	
	
	@NotEmpty(message="Field Cannot be Empty!")
	private String reason;
	
	@NotEmpty(message="Field Cannot be Empty!")
	private String returnStatus;

	
	
	
	
	
	
	
	
	
	
	
	public int getPettyCashId() {
		return pettyCashId;
	}

	public void setPettyCashId(int pettyCashId) {
		this.pettyCashId = pettyCashId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}


	
	
	
	
	
	
	
	
}

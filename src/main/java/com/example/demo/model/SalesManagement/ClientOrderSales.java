
package com.example.demo.model.SalesManagement;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

 public class ClientOrderSales extends Sales implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int clienOrdID;
	
	@NotNull
	private int custID;
	
	
	@NotNull
	private String expectedDate;
	
	@Size(max=100)
	private String delLocation;
	
	@NotNull
	private String paymentType;
	
	private String descrip;
	
	@NotNull
	private String delType;

	
	
	//Values for range
	private String range_1;
	private String range_2;
	
	//Getters And Setters
	
	public int getClienOrdID() {
		return clienOrdID;
	}

	public void setClienOrdID(int clienOrdID) {
		this.clienOrdID = clienOrdID;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(String expectedDate) {
		this.expectedDate = expectedDate;
	}

	public String getDelLocation() {
		return delLocation;
	}

	public void setDelLocation(String delLocation) {
		this.delLocation = delLocation;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public String getDelType() {
		return delType;
	}

	public void setDelType(String delType) {
		this.delType = delType;
	}

	public String getRange_1() {
		return range_1;
	}

	public void setRange_1(String range_1) {
		this.range_1 = range_1;
	}

	public String getRange_2() {
		return range_2;
	}

	public void setRange_2(String range_2) {
		this.range_2 = range_2;
	}

	
	

	
	
	

	
	
	
	
	
	
}

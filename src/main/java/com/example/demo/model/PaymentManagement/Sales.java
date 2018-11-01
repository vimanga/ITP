package com.example.demo.model.PaymentManagement;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sales {

			  @Id
			  public int salesID;
			  
			  private String salesCode;
			  
			  public String status;
			  
			  public String date;
			  
			  public String getDate() {
				return date;
			}

			public void setDate(String date) {
				this.date = date;
			}

			public int techID;
			  
			  public int driverID;
			  
			  public double totalAmount;
			  
			  public String orID;
			  
			  public String paymentMethod;

			public String getPaymentMethod() {
				return paymentMethod;
			}

			public void setPaymentMethod(String paymentMethod) {
				this.paymentMethod = paymentMethod;
			}

			public int getSalesID() {
				return salesID;
			}

			public void setSalesID(int salesID) {
				this.salesID = salesID;
			}

			public String getStatus() {
				return status;
			}

			public void setStatus(String status) {
				this.status = status;
			}

		

			public int getTechID() {
				return techID;
			}

			public void setTechID(int techID) {
				this.techID = techID;
			}

			public int getDriverID() {
				return driverID;
			}

			public void setDriverID(int driverID) {
				this.driverID = driverID;
			}

			public double getTotalAmount() {
				return totalAmount;
			}

			public void setTotalAmount(double totalAmount) {
				this.totalAmount = totalAmount;
			}

			public String getOrID() {
				return orID;
			}

			public void setOrID(String orID) {
				this.orID = orID;
			}     
	
	
	
	
	
	
	
	
	
	
	
	
	
}

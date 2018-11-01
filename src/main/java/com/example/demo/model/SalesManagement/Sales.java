

package com.example.demo.model.SalesManagement;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

import com.example.demo.model.EmployeeManagement.Employee;

 public class   Sales  extends Employee implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
private int salesID;

private String salesCode;

private String status;

private String dateCompleted;

private String techID;

private String driverID;

private double totalAmount;
@NotNull
private String orID;

private boolean payment_status;

private boolean technician_assign_status;
private boolean driver_assign_status;

public int getSalesID() {
	return salesID;
}
public void setSalesID(int salesID) {
	this.salesID = salesID;
}
public String getSalesCode() {
	return salesCode;
}
public void setSalesCode(String salesCode) {
	this.salesCode = salesCode;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getDateCompleted() {
	return dateCompleted;
}
public void setDateCompleted(String dateCompleted) {
	this.dateCompleted = dateCompleted;
}
public String getTechID() {
	return techID;
}
public void setTechID(String techID) {
	this.techID = techID;
}
public String getDriverID() {
	return driverID;
}
public void setDriverID(String driverID) {
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
public boolean getPayment_status() {
	return payment_status;
}
public void setPayment_status(boolean payment_status) {
	this.payment_status = payment_status;
}
public boolean isTechnician_assign_status() {
	return technician_assign_status;
}
public void setTechnician_assign_status(boolean technician_assign_status) {
	this.technician_assign_status = technician_assign_status;
}
public boolean isDriver_assign_status() {
	return driver_assign_status;
}
public void setDriver_assign_status(boolean driver_assign_status) {
	this.driver_assign_status = driver_assign_status;
}





}

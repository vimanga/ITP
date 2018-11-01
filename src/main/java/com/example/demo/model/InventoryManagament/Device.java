package com.example.demo.model.InventoryManagament;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Device implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@NotNull
	private int deviceID;
	
	@NotNull(message="Device name cannot be empty")
	private String name;
	
	@Size(min=3,max=10)
	@NotNull(message="Model field cannot be empty")
	private String model;
	
	@NotNull(message="Unit Price cannot be empty")
	private double unitPrice;
		
	@NotNull(message="Manufacturer field cannot be empty")
	private String manufacturer;


	private int supplierID;


	public int getDeviceID() {
		return deviceID;
	}




	public void setDeviceID(int deviceID) {
		this.deviceID = deviceID;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getModel() {
		return model;
	}




	public void setModel(String model) {
		this.model = model;
	}




	public double getUnitPrice() {
		return unitPrice;
	}




	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}




	public String getManufacturer() {
		return manufacturer;
	}




	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public int getSupplierID() {
		return supplierID;
	}
	
	public void setSuppID(int supplierID) {
		this.supplierID = supplierID;
	}
}

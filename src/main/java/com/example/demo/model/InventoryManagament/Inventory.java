package com.example.demo.model.InventoryManagament;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
@Entity
public class Inventory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int inventoryID;
	
	@NotNull
	private int deviceID;
	
	
	private int quantity;
	

	private int criticalLevel;


	public int getInventoryID() {
		return inventoryID;
	}


	public void setInventoryID(int inventoryID) {
		this.inventoryID = inventoryID;
	}


	public int getDeviceID() {
		return deviceID;
	}


	public void setDeviceID(int deviceID) {
		this.deviceID = deviceID;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getCriticalLevel() {
		return criticalLevel;
	}


	public void setCriticalLevel(int criticalLevel) {
		this.criticalLevel = criticalLevel;
	}
}

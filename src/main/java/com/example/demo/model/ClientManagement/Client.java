package com.example.demo.model.ClientManagement;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	
	@Id
	private int clientID;
    
	@NotEmpty
	private String companyName;
	
	@NotEmpty
	private String clientName;
	
	private int postalCode;
	
	@NotEmpty
	private String street;
	
	@NotEmpty
	private String city;

	@NotNull
	private int contactNumber;

	@Email
	@NotEmpty
	private String email;
	
	@Id
	private int branchID;
	
	@NotNull
	private String bCity;
	
	@NotNull
	private String bAddress;
	
	private int clOrderID;
	
    private int deviID;
	
	private int quan;
	
	private String regDate;
	
	private String clientCode;

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getClOrderID() {
		return clOrderID;
	}

	public void setClOrderID(int clOrderID) {
		this.clOrderID = clOrderID;
	}

	public int getDeviID() {
		return deviID;
	}

	public void setDeviID(int deviID) {
		this.deviID = deviID;
	}

	public int getQuan() {
		return quan;
	}

	public void setQuan(int quan) {
		this.quan = quan;
	}
	
	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBranchID() {
		return branchID;
	}

	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}

	public String getbCity() {
		return bCity;
	}

	public void setbCity(String bCity) {
		this.bCity = bCity;
	}

	public String getbAddress() {
		return bAddress;
	}

	public void setbAddress(String bAddress) {
		this.bAddress = bAddress;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	

}

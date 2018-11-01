package com.example.demo.model.PaymentManagement;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
public class SupplierOrder implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	private int sid;
	@NotNull
	private int id;
	@NotEmpty
	private String location;
	@NotNull
	private int item;
	@NotNull
	private int quantity;
	@NotNull
	private Date date;
	@NotEmpty
	private String paytyp;
	@NotEmpty
	private String deltyp;
	
	private String description;
	
	private boolean proceed_payment;
	
	private int amount;
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isProceed_payment() {
		return proceed_payment;
	}

	public void setProceed_payment(boolean proceed_payment) {
		this.proceed_payment = proceed_payment;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPaytyp() {
		return paytyp;
	}

	public void setPaytyp(String paytyp) {
		this.paytyp = paytyp;
	}

	public String getDeltyp() {
		return deltyp;
	}

	public void setDeltyp(String deltyp) {
		this.deltyp = deltyp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	
}

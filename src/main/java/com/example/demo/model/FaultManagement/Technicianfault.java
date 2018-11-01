package com.example.demo.model.FaultManagement;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Technicianfault implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int faulttechID;
	
	@NotNull(message="Job ID field cannot be empty")
	private int faultid;
	
	@NotNull(message="Employee name field cannot be empty")
	private int empid;
	
	@NotNull(message="Assigned Date field cannot be empty")
	private Date assDate;

	public int getFaulttechID() {
		return faulttechID;
	}

	public void setFaulttechID(int faulttechID) {
		this.faulttechID = faulttechID;
	}

	public int getFaultid() {
		return faultid;
	}

	public void setFaultid(int faultid) {
		this.faultid = faultid;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	

	public Date getAssDate() {
		return assDate;
	}

	public void setAssDate(Date assDate) {
		this.assDate = assDate;
	}
	
	public Technicianfault(@NotNull(message = "Job ID field cannot be empty") int faultid) {
		super();
		this.faultid = faultid;
	}

	public Technicianfault() {
		super();
	}
	

}

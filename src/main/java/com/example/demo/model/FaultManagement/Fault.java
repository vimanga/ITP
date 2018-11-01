package com.example.demo.model.FaultManagement;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Fault implements Serializable {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull
	private String nature;
	
	@NotNull
	private String descrip;
	
	@NotNull
	private String priority;
	
	@NotNull
	private String status;
	
	private String category;
	
	@NotNull
	private int cliID;
	
	@NotNull
	private int brID;

	private String reportedBy;
	
	private boolean isassigned;
	
	@NotNull 
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fixedBy;
	
	@NotNull
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date reportedOn;
	
	@NotNull
	private String faID;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCliID() {
		return cliID;
	}

	public void setCliID(int cliID) {
		this.cliID = cliID;
	}

	public int getBrID() {
		return brID;
	}

	public void setBrID(int brID) {
		this.brID = brID;
	}

	public String getReportedBy() {
		return reportedBy;
	}

	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}

	public Date getFixedBy() {
		return fixedBy;
	}

	public void setFixedBy(Date fixedBy) {
		this.fixedBy = fixedBy;
	}

	public Date getReportedOn() {
		return reportedOn;
	}

	public void setReportedOn(Date reportedOn) {
		this.reportedOn = reportedOn;
	}

	public boolean isIsassigned() {
		return isassigned;
	}

	public void setIsassigned(boolean isassigned) {
		this.isassigned = isassigned;
	}

	public Fault() {
		isassigned = false;
	}
	
	public String getFaID() {
		return faID;
	}

	public void setFaID(String faID) {
		this.faID = faID;
	}
}

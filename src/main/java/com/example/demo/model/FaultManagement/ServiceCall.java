package com.example.demo.model.FaultManagement;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.Future;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ServiceCall implements Serializable {
	
	

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int serviceID;
	
	@NotNull
	private int fauid;
	
	@NotNull
	private int custoID;
	
	@NotNull
	private String faultDesc;
	
	@NotNull
	private String workDetails;
	
	@NotNull
	private boolean fullyFunc;
	
	@NotNull
	private String generalDesc;
	
	@NotNull
	private Date datet;
	
	@NotNull
	private String reasonnot;
	
	@NotNull
	private String servcode;

	
	public ServiceCall(@NotNull int fauid) {
		super();
		this.fauid = fauid;
	}

	public ServiceCall(@NotNull int fauid, @NotNull int custoID) {
		super();
		this.fauid = fauid;
		this.custoID = custoID;
	}

	
	public ServiceCall() {
		super();
	}
	
	
	public int getServiceID() {
		return serviceID;
	}

	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}

	

	public int getFauid() {
		return fauid;
	}

	public void setFauid(int fauid) {
		this.fauid = fauid;
	}

	public Date getDatet() {
		return datet;
	}

	public void setDatet(Date datet) {
		this.datet = datet;
	}

	public int getCustoID() {
		return custoID;
	}

	public void setCustoID(int custoID) {
		this.custoID = custoID;
	}

	public String getFaultDesc() {
		return faultDesc;
	}

	public void setFaultDesc(String faultDesc) {
		this.faultDesc = faultDesc;
	}

	public String getWorkDetails() {
		return workDetails;
	}

	public void setWorkDetails(String workDetails) {
		this.workDetails = workDetails;
	}

	public boolean isFullyFunc() {
		return fullyFunc;
	}

	public void setFullyFunc(boolean fullyFunc) {
		this.fullyFunc = fullyFunc;
	}

	public String getGeneralDesc() {
		return generalDesc;
	}

	public void setGeneralDesc(String generalDesc) {
		this.generalDesc = generalDesc;
	}

	public String getReasonnot() {
		return reasonnot;
	}

	public void setReasonnot(String reasonnot) {
		this.reasonnot = reasonnot;
	}

	public String getServcode() {
		return servcode;
	}

	public void setServcode(String servcode) {
		this.servcode = servcode;
	}

	
	
}	
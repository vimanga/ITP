package com.example.demo.model.SalesManagement;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class InstallationCertificate extends Sales implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int installationID;
	private String installationCode;
	@NotNull
	private String ordId;
	@NotNull 
	private String clienId;
	@NotNull
	private String techId;
	@NotNull
	private String drivId;

	private double cableLen;
		
	private double conduitLen;
	
	private String swInstalled;
	
	@Size(max=100)
	private String swInstalledDescription;
	
	private String opTraining;
	
	private String opTrainingDescription;
	
	private String fullyOperational;
	
	private String fullyOperationalDescription;
	  
	@NotNull
	private String timeIn;
	@NotNull
	private String timeOut;
	@NotEmpty
	private String dateInstalled;
	


	//installation_device table attributes
	
	
		private int instID;
		private int devicesId;
		private String instCode;
		@NotNull
		private String devicesCode;
		@NotNull
		private int quantity;
		
		private int numOfDev;
	
	//Getters And Setters
	public int getInstallationID() {
		return installationID;
	}
	public void setInstallationID(int installationID) {
		this.installationID = installationID;
	}
	
	public String getInstallationCode() {
		return installationCode;
	}
	public void setInstallationCode(String installationCode) {
		this.installationCode = installationCode;
	}
	public String getOrdId() {
		return ordId;
	}
	
	public void setOrdId(String ordId) {
		this.ordId = ordId;
	}
	public String getClienId() {
		return clienId;
	}
	public void setClienId(String clienId) {
		this.clienId = clienId;
	}
	public String getTechId() {
		return techId;
	}
	public void setTechId(String techId) {
		this.techId = techId;
	}
	public String getDrivId() {
		return drivId;
	}
	public void setDrivId(String drivId) {
		this.drivId = drivId;
	}
	public double getCableLen() {
		return cableLen;
	}
	public void setCableLen(double cableLen) {
		this.cableLen = cableLen;
	}
	public double getConduitLen() {
		return conduitLen;
	}
	public void setConduitLen(double conduitLen) {
		this.conduitLen = conduitLen;
	}
	
	public String getSwInstalled() {
		return swInstalled;
	}
	
	public void setSwInstalled(String swInstalled) {
		this.swInstalled = swInstalled;
	}	
	
	public String getSwInstalledDescription() {
		return swInstalledDescription;
	}
	public void setSwInstalledDescription(String swInstalledDescription) {
		this.swInstalledDescription = swInstalledDescription;
	}
	public String getOpTraining() {
		return opTraining;
	}
	public void setOpTraining(String opTraining) {
		this.opTraining = opTraining;
	}
	public String getOpTrainingDescription() {
		return opTrainingDescription;
	}
	public void setOpTrainingDescription(String opTrainingDescription) {
		this.opTrainingDescription = opTrainingDescription;
	}
	public String getFullyOperational() {
		return fullyOperational;
	}
	public void setFullyOperational(String fullyOperational) {
		this.fullyOperational = fullyOperational;
	}
	public String getFullyOperationalDescription() {
		return fullyOperationalDescription;
	}
	public void setFullyOperationalDescription(String fullyOperationalDescription) {
		this.fullyOperationalDescription = fullyOperationalDescription;
	}
	public String getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}
	public String getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}
	public String getDateInstalled() {
		return dateInstalled;
	}
	public void setDateInstalled(String dateInstalled) {
		this.dateInstalled = dateInstalled;
	}
	
	public String getInstCode() {
		return instCode;
	}
	public void setInstCode(String instCode) {
		this.instCode = instCode;
	}
	public String getDevicesCode() {
		return devicesCode;
	}
	public void setDevicesCode(String devicesCode) {
		this.devicesCode = devicesCode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getNumOfDev() {
		return numOfDev;
	}
	public void setNumOfDev(int numOfDev) {
		this.numOfDev = numOfDev;
	}
	public int getInstID() {
		return instID;
	}
	public void setInstID(int instID) {
		this.instID = instID;
	}
	public int getDevicesId() {
		return devicesId;
	}
	public void setDevicesId(int devicesId) {
		this.devicesId = devicesId;
	}
	
	
	
	
	
}

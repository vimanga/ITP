package com.example.demo.model.VisitorManagement;

import java.io.Serializable;
import java.sql.Date;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;





@Entity
public class Visitor implements Serializable{

	private static final long serialVersionUID =  1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appid;
	
	private String appcode;
	

	

	@NotEmpty(message = "Visitor name field cannot be empty")
	@Size(min = 3)
	private String visitorName;
	
	
	
	
	
	@NotEmpty(message = "Company name field cannot be empty")
	private String companyName;
	

	@NotNull(message = "Date field cannot be empty")
	private Date appdate;
	
	
	
	
	@Email 
	@NotEmpty(message = "e-mail field cannot be empty")
	private String mail;
	
	@NotNull(message = "contact number field cannot be empty")
	@Size(min = 8, max = 13)
	private String contactNumber;
	
    private String comments;
	
	
	private String stat;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emailID;
	
	private String mailcode;
	
	private Date sentDate = new java.sql.Date(new java.util.Date().getTime());

	private int count;
	
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getEmailID() {
		return emailID;
	}


	public void setEmailID(int emailID) {
		this.emailID = emailID;
	}


	
	public String getMailcode() {
		return mailcode;
	}


	public void setMailcode(String mailcode) {
		this.mailcode = mailcode;
	}



	public Date getSentDate() {
		return sentDate;
	}


	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}




	private String assigned_employee;
	
	public int getAppid() {
		return appid;
	}


	public void setAppid(int appid) {
		this.appid = appid;
	}
	public String getAppcode() {
		return appcode;
	}


	public void setAppcode(String appcode) {
		this.appcode = appcode;
	}



	public String getVisitorName() {
		return visitorName;
	}


	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public Date getAppdate() {
		return appdate;
	}


	public void setAppdate(Date appdate) {
		this.appdate = appdate;
	}


	


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getAssigned_employee() {
		return assigned_employee;
	}


	public void setAssigned_employee(String assigned_employee) {
		this.assigned_employee = assigned_employee;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getStat() {
		return stat;
	}


	public void setStat(String stat) {
		this.stat = stat;
	}


	

	
	
}

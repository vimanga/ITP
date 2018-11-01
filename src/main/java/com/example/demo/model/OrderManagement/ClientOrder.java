package com.example.demo.model.OrderManagement;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
public class ClientOrder implements Serializable{


		
		private static final long serialVersionUID = 1L;
		@Id
		private int oid;
		@NotNull
		private int id;
		@NotEmpty
		private String location;
		@NotNull
		private int item;
		@NotNull
		private int quantity;
		@NotNull
		private Date exdate;
		@NotEmpty
		private String paytyp;
		@NotEmpty
		private String deltyp;
		
		private String description;
		
		private boolean status;
		
		private String client_order_code;
		
		private String email;
		
	
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getClient_order_code() {
			return client_order_code;
		}

		public void setClient_order_code(String client_order_code) {
			this.client_order_code = client_order_code;
		}

		public boolean getStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public int getItem() {
			return item;
		}
		
		public void setItem(int item) {
			this.item=item;
		}
		
		public int getQuantity() {
			return quantity;
		}
		
		public void setQuantity(int quantity) {
			this.quantity=quantity;
		}
		
		public Date getExdate() {
			return exdate;
		}
		
		public void setExdate(Date exdate) {
			this.exdate=exdate;
		}
		
		public String getPaytyp() {
			return paytyp;
		}
		
		public void setPaytyp(String paytyp) {
			this.paytyp=paytyp;
		}
		
		public String getDeltyp() {
			return deltyp;
		}
		
		public void setDeltyp(String deltyp) {
			this.deltyp=deltyp;
		}
		
		public String getDescription() {
			return description;
		}
		
		public void setDescription(String description) {
			this.description=description;
		}
			
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public int getOid() {
			return oid;
		}
		public void setOid(int oid) {
			this.oid = oid;
		}
		
		

	}






package com.example.demo.dao.PaymentManagement;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.PaymentManagement.Order;
import com.example.demo.model.PaymentManagement.PettyCashRegister;
import com.example.demo.model.PaymentManagement.Sales;
import com.example.demo.model.PaymentManagement.SupplierOrder;


@Service
public class OrderDAO {
	
	
	
	
	
JdbcTemplate template;
	
	@Autowired
	public void serDataSource(DataSource datasource) {
		
		template = new JdbcTemplate(datasource);
		
		
	}
	
	
	public Order getOrderById(String id) {
		return template.query("select clieOrdID,paymentType from client_order where client_order_code='"+id+"'",new ResultSetExtractor<Order>() {
			
			public Order extractData(ResultSet rs) throws SQLException {
				
				
				 Order o = new Order();
				while(rs.next()) {
					
					System.out.print("===adassa==="+id);
					
					
					o.setOrID(rs.getString(1));
					o.setPayType(rs.getString(2));
					System.out.print("===adassa==="+o.getPayType()+"");
					
					
			
				}
				return o;
		}
				
			
		});
		
	}
	
	
	
////////////////////////////////////////////////
	
	
	
	public SupplierOrder getSuplierOrderById(int id) {
		
		return template.query("select supOrderID,amount from supplier_order where supOrderID="+id,new ResultSetExtractor<SupplierOrder>() {
			
			public SupplierOrder extractData(ResultSet rs) throws SQLException {
				
				
				SupplierOrder o = new SupplierOrder();
				
				
				while(rs.next()) {
					
				
				
				o.setSid(rs.getInt(1));
				o.setAmount(rs.getInt(2));	
					
			
				}
				return o;
		}
				
			
		});
		
	}
	
	
	
	
	//////////////////////////////////////////////////
	
	
	
	

}

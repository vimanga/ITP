package com.example.demo.dao.OrderManagement;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

//import com.example.demo.controller.OrderManagement.SignInController;
import com.example.demo.model.OrderManagement.ClientOrder;

import org.springframework.jdbc.core.ResultSetExtractor;

import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
@Service
public class ClientOrderDao {

JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	
	@Autowired
	public void setDataSource(DataSource datasource) {
		
		template= new JdbcTemplate(datasource);
		
	}
	
	public void save(ClientOrder c) {
		
		System.out.println(c.getItem());
		System.out.println(c.getQuantity());
		
		String sql1= "insert into client_order(custID,expectedDate,delLocation,paymentType,descrip,delType) values ("+c.getId()+",'"+c.getExdate()+"','"+c.getLocation()+"','"+c.getPaytyp()+"','"+c.getDescription()+"','"+c.getDeltyp()+"')";
		String sql2="SET @last_id_in_order = Last_Insert_ID();";
		String sql3="insert into client_order_device(clOrderID, deviID, cliID, quan)values (@last_id_in_order,'"+c.getItem()+"','"+c.getId()+"','"+c.getQuantity()+"')";		
		String sql4 = "UPDATE client_order SET client_order_code = concat( client_order_prefix, clieOrdID )";
		System.out.println(sql4);
		template.batchUpdate(sql1,sql2,sql3,sql4);
	}
	

	public List<ClientOrder> getClientOrder() {
		//select item, sum(quntity) from client_order groupby item,
		return template.query("select * from client_order inner join client_order_device on client_order.clieOrdID=client_order_device.clOrderID",new ResultSetExtractor<List<ClientOrder>>(){
			
			public List<ClientOrder> extractData(ResultSet rs) throws SQLException, DataAccessException{
			
			
			List<ClientOrder> list= new ArrayList<ClientOrder>();
			while(rs.next()) {
				ClientOrder co = new ClientOrder();
				co.setOid(rs.getInt(1));
				co.setId(rs.getInt(2));
				co.setLocation(rs.getString(4));
				co.setPaytyp(rs.getString(5));
				co.setDeltyp(rs.getString(7));
				co.setExdate(rs.getDate(3));
				co.setDescription(rs.getString(6));
				co.setItem(rs.getInt(12));
				co.setQuantity(rs.getInt(14));
				co.setStatus(rs.getBoolean(10));
				list.add(co);
				
			}
			return list;
			}
		});
	}
	
	
	public ClientOrder EditClientOrder(int id) {
		//select * from employee inner join system_user on employee.empID=system_user.empSUId
		return template.query("select * from client_order inner join client_order_device on client_order.clieOrdID=client_order_device.clOrderID where client_order.clieOrdID="+id,new ResultSetExtractor<ClientOrder>() {
			
			public ClientOrder extractData(ResultSet rs) throws SQLException {
				
				ClientOrder e= new ClientOrder();
				while(rs.next()) {
					
					e.setOid(rs.getInt(1));
					e.setId(rs.getInt(2));
					e.setLocation(rs.getString(4));
					e.setPaytyp(rs.getString(5));
					e.setDeltyp(rs.getString(7));
					e.setExdate(rs.getDate(3));
					e.setDescription(rs.getString(6));
					e.setClient_order_code(rs.getString(9));
					e.setItem(rs.getInt(12));
					e.setQuantity(rs.getInt(14));
				}
				return e;
		}
					
		});
		
	}
	
	public void update(ClientOrder c) {
			
			System.out.println(c.getItem());
			System.out.println(c.getQuantity());
			
			//String sql= "update client_order(custID,expectedDate,delLocation,paymentType,descrip,delType) set ("+c.getId()+",'"+c.getExdate()+"','"+c.getLocation()+"','"+c.getPaytyp()+"','"+c.getDescription()+"','"+c.getDeltyp()+"') where client_order.clieOrdID=\"+id";
			String sql= "update client_order set custID="+c.getId()+",expectedDate='"+c.getExdate()+"',delLocation='"+c.getLocation()+"',paymentType='"+c.getPaytyp()+"',descrip='"+c.getDescription()+"',delType='"+c.getDeltyp()+"' where clieOrdID="+c.getOid()+";";
			System.out.println(sql);
			template.update(sql);
		}
	
	public void delete(int oid) {
		
		String sql= "delete from client_order where clieOrdID="+oid+";";
		String sql2= "delete from client_order_device where clOrderID="+oid+";";
		System.out.println(sql);
		template.batchUpdate(sql2,sql);
	}
	
public void confirm(int oid, int device, int qnty) {
		
		String sql1= "update client_order set status = 1 where clieOrdID="+oid+";";
//		String sql2= "update device where clOrderID="+oid+";";
		int quantity = template.query("select quantity from inventory where deviceID="+device, new ResultSetExtractor<Integer>() {
			public Integer extractData(ResultSet rs) throws SQLException {
				rs.next();
				return rs.getInt(1);
			}			
		});
		int newQuantity = quantity - qnty;
		if(newQuantity >0) {
			String sql2= "update inventory set quantity = "+newQuantity+" where deviceID="+device+";";
			template.update(sql2);
		} else {
			System.out.println("error");
		}
		System.out.println(quantity);
		template.update(sql1);
	}
		
	}



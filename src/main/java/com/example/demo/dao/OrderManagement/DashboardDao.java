package com.example.demo.dao.OrderManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.example.demo.model.OrderManagement.ClientOrder;
import com.example.demo.model.OrderManagement.DashboardCount;
@Service
public class DashboardDao {

JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	
	@Autowired
	public void setDataSource(DataSource datasource) {
		
		template= new JdbcTemplate(datasource);
		
	}
	
	public List<DashboardCount> Dashboard() {
		
		return template.query("SELECT DATE_FORMAT(expectedDate, \"%b\") AS month, count(custID) as total FROM client_order WHERE expectedDate <= NOW() and expectedDate >= Date_add(Now(),interval - 12 month) GROUP BY DATE_FORMAT(expectedDate, \"%m-%Y\")",new ResultSetExtractor<List<DashboardCount>>(){
			
			public List<DashboardCount> extractData(ResultSet rs) throws SQLException, DataAccessException{
			
			
			List<DashboardCount> list= new ArrayList<DashboardCount>();
			while(rs.next()) {
				DashboardCount d = new DashboardCount();
				
				d.setMonth(rs.getString(1));
				d.setCount(rs.getInt(2));
				
				list.add(d);
				
			}
			return list;
			}
		});
	}
	
	public List<ClientOrder> Dashboard2() {
		
		return template.query("SELECT * FROM client_order inner join client_order_device on client_order.clieOrdID=client_order_device.clOrderID ORDER BY clieOrdID DESC LIMIT 10",new ResultSetExtractor<List<ClientOrder>>(){
			
			public List<ClientOrder> extractData(ResultSet rs) throws SQLException, DataAccessException{
			
			
			List<ClientOrder> list= new ArrayList<ClientOrder>();
			while(rs.next()) {
				ClientOrder d = new ClientOrder();
				
				d.setOid(rs.getInt(1));
				d.setId(rs.getInt(2));
				d.setLocation(rs.getString(4));
				d.setPaytyp(rs.getString(5));
				d.setDeltyp(rs.getString(7));
				d.setExdate(rs.getDate(3));
				d.setDescription(rs.getString(6));
				d.setItem(rs.getInt(12));
				d.setQuantity(rs.getInt(14));
				
				list.add(d);
				
			}
			return list;
			}
		});
	}
}

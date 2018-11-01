package com.example.demo.dao.InventoryManagement;

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

import com.example.demo.model.InventoryManagament.Inventory;

@Service
public class InventoryDAO {
	JdbcTemplate template;
	
	@Autowired
	public void setDataSource(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
	
	
	public void save(Inventory i) {
		String sql = "insert into inventory(inventoryID, deviceID, quantity, criticalLevel) values ('"+i.getInventoryID()+"', '"+i.getDeviceID()+"', '"+i.getQuantity()+"', '"+i.getCriticalLevel()+"')";
		template.update(sql);
	}
	
	public List<Inventory> getAllInventory(){
		return template.query("select * from inventory", new ResultSetExtractor<List<Inventory>>() {
			public List<com.example.demo.model.InventoryManagament.Inventory> extractData(ResultSet rs) throws SQLException, DataAccessException
			{
				List<Inventory> list = new ArrayList<Inventory>();
				while(rs.next()) {
					Inventory inv = new Inventory();
					inv.setInventoryID(rs.getInt(1));
					inv.setDeviceID(rs.getInt(2));
					inv.setQuantity(rs.getInt(3));
					inv.setCriticalLevel(rs.getInt(4));
					
					list.add(inv);
				}
				
				return list;
			}
		});
	}
	
	public Inventory getInventoryById(int devid){
		return template.query("select * from inventory where inventoryID="+devid, new ResultSetExtractor<Inventory>() {
			public com.example.demo.model.InventoryManagament.Inventory extractData(ResultSet rs) throws SQLException, DataAccessException
			{
				Inventory inv = new Inventory();
				while(rs.next()) {
					
					inv.setInventoryID(rs.getInt(1));
					inv.setDeviceID(rs.getInt(2));
					inv.setQuantity(rs.getInt(3));
					inv.setCriticalLevel(rs.getInt(4));
					
				}
				
				return inv;
			}
		});
	}
	
	
	
	public void update(Inventory i) {
		String sql = "update Inventory set quantity='"+i.getQuantity()+"', criticalLevel='"+i.getCriticalLevel()+"' where inventoryID="+i.getInventoryID()+"";
		template.update(sql);
	}
	
	public List<Inventory> getCriticalInventory(){
		return template.query("select deviceID,quantity,criticalLevel from inventory where quantity<=criticalLevel", new ResultSetExtractor<List<Inventory>>() {
			public List<com.example.demo.model.InventoryManagament.Inventory> extractData(ResultSet rs) throws SQLException, DataAccessException
			{
				List<Inventory> list = new ArrayList<Inventory>();
				while(rs.next()) {
					Inventory inv = new Inventory();
					inv.setDeviceID(rs.getInt(1));
					inv.setQuantity(rs.getInt(2));
					inv.setCriticalLevel(rs.getInt(3));
					
					list.add(inv);
				}
				
				return list;
			}
		});
	}
	
	public void delete(int id) {
		String sql="delete from inventory where inventoryID="+id+"";  
	    template.update(sql);  		
	}

	public void delete() {
		String sql="delete from inventory where deviceID>0";  
	    template.update(sql); 
	}
}

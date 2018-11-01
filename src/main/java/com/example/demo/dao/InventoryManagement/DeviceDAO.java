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

import com.example.demo.model.InventoryManagament.Device;

@Service
public class DeviceDAO {
JdbcTemplate template;
	
	@Autowired
	public void setDataSource(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
	public void save(Device d) {
		String sql = "insert into device(deviceID, model, unitPrice, name, manufacturer,suppID) values ('"+d.getDeviceID()+"','"+d.getModel()+"','"+d.getUnitPrice()+"','"+d.getName()+"','"+d.getManufacturer()+"','"+d.getSupplierID()+"')";
		System.out.println(sql);
		template.update(sql);
	}
	
	public List<Device> getAllDevices(){
		return template.query("select * from device", new ResultSetExtractor<List<Device>>() {
			public List<Device> extractData(ResultSet rs) throws SQLException, DataAccessException
			{
				List<Device> list = new ArrayList<Device>();
				while(rs.next()) {
					Device dev = new Device();
					dev.setDeviceID(rs.getInt(1));
					dev.setModel(rs.getString(2));
					dev.setUnitPrice(rs.getDouble(3));
					dev.setName(rs.getString(4));
					dev.setManufacturer(rs.getString(5));
					dev.setSuppID(rs.getInt(6));
					
					
					list.add(dev);
				}
				
				return list;
			}
		});
	}
	
	public Device getDeviceById(int devid){
		return template.query("select * from device where deviceID="+devid, new ResultSetExtractor<Device>() {
			public Device extractData(ResultSet rs) throws SQLException, DataAccessException
			{
				Device dev = new Device();
				while(rs.next()) {
					
					dev.setDeviceID(rs.getInt(1));
					dev.setModel(rs.getString(2));
					dev.setUnitPrice(rs.getDouble(3));
					dev.setName(rs.getString(4));
					dev.setManufacturer(rs.getString(5));
					dev.setSuppID(rs.getInt(6));
					
				}
				
				return dev;
			}
		});
	}
	
	public void update(Device d) {
		String sql = "update device set name='"+d.getName()+"', unitPrice='"+d.getUnitPrice()+"', suppID='"+d.getSupplierID()+"' where deviceID="+d.getDeviceID()+"";
		System.out.println(sql);
		template.update(sql);
	}
	
	public void delete(int id) {
		String sql="delete from device where deviceID="+id+"";  
	    template.update(sql);  		
	}

	public void delete() {
		String sql="delete from device where deviceID>0";  
	    template.update(sql); 
	}
}

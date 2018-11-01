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

import com.example.demo.model.OrderManagement.Supplier;



@Service
public class SupplierDao {

JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;  
	}
	
	@Autowired
	public void setDataSource(DataSource datasource) {
		
		template= new JdbcTemplate(datasource);
		
	}
	
public void save(Supplier s) {
		
		String sql1= "insert into supplier(suppName,location,registeredDate,contactNo,email) values ('"+s.getName()+"','"+s.getLocation()+"','"+s.getRegDate()+"',"+s.getContactNo()+",'"+s.getEmail()+"')";
		String sql2="SET @last_id_in_suporder = Last_Insert_ID();";
		String sql3="insert into supplier_device(supID,deID)values (@last_id_in_suporder,"+s.getItem()+")";	
		String sql4 = "UPDATE supplier SET supplier_code = concat( supplier_prefix, supplierID )";
		System.out.println(sql1);
		System.out.println(sql2);
		System.out.println(sql3);
		
		//template.batchUpdate(sql1,sql2,sql3,sql4);
		template.update(sql1);
		template.update(sql2);
		template.update(sql3);
		template.update(sql4);
	}

public List<Supplier> getSupplier() {
	
	return template.query("select * from supplier inner join supplier_device on supplier.supplierID=supplier_device.supID",new ResultSetExtractor<List<Supplier>>(){
		
		public List<Supplier> extractData(ResultSet rs) throws SQLException, DataAccessException{
		
		
		List<Supplier> list= new ArrayList<Supplier>();
		while(rs.next()) {
			Supplier s = new Supplier();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setLocation(rs.getString(3));
			s.setRegDate(rs.getDate(4));
			s.setContactNo(rs.getInt(7));
			s.setEmail(rs.getString(8));
			s.setItem(rs.getInt(10));
			
			list.add(s);
			
		}
		return list;
		}
	});
}

public Supplier EditSupplier(int id) {
	return template.query("select * from supplier inner join supplier_device on supplier.supplierID=supplier_device.supID where supplier.supplierID="+id,new ResultSetExtractor<Supplier>() {
		
		public Supplier extractData(ResultSet rs) throws SQLException {
			
			Supplier s= new Supplier();
			while(rs.next()) {
				
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setLocation(rs.getString(3));
				s.setRegDate(rs.getDate(4));
				s.setContactNo(rs.getInt(7));
				s.setEmail(rs.getString(8));
				s.setItem(rs.getInt(10));
			}
			return s;
	}
				
	});
	
}

public void update(Supplier c) {
	
	String sql= "update supplier set suppName='"+c.getName()+"',location='"+c.getLocation()+"',registeredDate='"+c.getRegDate()+"',contactNo='"+c.getContactNo()+"',email='"+c.getEmail()+"' where supplierID="+c.getId()+";";
	String sql1="update supplier_device set deId="+c.getItem()+" where supID="+c.getId()+";";
	System.out.println(sql);
	System.out.println(sql1);
	template.batchUpdate(sql,sql1);
}

public void delete(int id) {
	
	String sql= "delete from supplier where supplierID="+id+";";
	String sql2= "delete from supplier_device where supID="+id+";";
	System.out.println(sql);
	System.out.println(sql2);
	template.batchUpdate(sql2,sql);
}



}

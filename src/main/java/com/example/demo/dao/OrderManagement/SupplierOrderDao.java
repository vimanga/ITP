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

import com.example.demo.*;
import com.example.demo.model.PaymentManagement.SupplierOrder;
@Service
public class SupplierOrderDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;  
	}
	
	@Autowired
	public void setDataSource(DataSource datasource) {
		
		template= new JdbcTemplate(datasource);
		
	}
	
public void save(SupplierOrder s) {
		
		System.out.println(s.getItem());
		System.out.println(s.getQuantity());
		
		String sql4="SET @unitprice = (select unitPrice from device where deviceID = "+s.getItem()+")";
		String sql5="SET @quantity = "+s.getQuantity()+"";
		String sql6="SET @amount = @unitprice * @quantity";
		String sql1= "insert into supplier_order(suID,payType,descr,delType,dateOrdered,amount) values ("+s.getId()+",'"+s.getPaytyp()+"','"+s.getDescription()+"','"+s.getDeltyp()+"','"+s.getDate()+"',@amount)";
		String sql8="UPDATE supplier_order SET supplier_order_code = concat( supplier_order_prefix, supOrderID )" ;

		String sql2="SET @last_id_in_suporder = Last_Insert_ID();";
		String sql3="insert into supp_order_device(supOrdID,supplID,devicId,quantity)values (@last_id_in_suporder,"+s.getId()+","+s.getItem()+","+s.getQuantity()+")";	

		System.out.println(sql3);

		System.out.println(sql1);
		System.out.println(sql2);
		System.out.println(sql4);
		System.out.println(sql5);
		System.out.println(sql6);
		//System.out.println(sql7);
		System.out.println(s.getDate());
		//template.batchUpdate(sql1,sql2,sql3,sql4,sql5,sql6,sql7);
		template.batchUpdate(sql4,sql5,sql6);
		template.update(sql1);
		template.update(sql8);
		template.update(sql2);
		template.update(sql3);
	}

	
public List<SupplierOrder> getSupplierOrder() {
	
	return template.query("select * from supplier_order inner join supp_order_device on supplier_order.supOrderID=supp_order_device.supOrdID",new ResultSetExtractor<List<SupplierOrder>>(){
		
		public List<SupplierOrder> extractData(ResultSet rs) throws SQLException, DataAccessException{
		
		
		List<SupplierOrder> list= new ArrayList<SupplierOrder>();
		while(rs.next()) {
			SupplierOrder s = new SupplierOrder();
			s.setSid(rs.getInt(1));
			s.setId(rs.getInt(2));
			//s.setLocation(rs.getString(4));
			s.setPaytyp(rs.getString(3));
			s.setDeltyp(rs.getString(5));
			s.setDate(rs.getDate(6));
			s.setDescription(rs.getString(4));
			s.setItem(rs.getInt(13));
			s.setQuantity(rs.getInt(14));
			s.setProceed_payment(rs.getBoolean(11));
			list.add(s);
			
		}
		return list;
		}
	});
}

public SupplierOrder EditSupplierOrder(int id) {
	//select * from employee inner join system_user on employee.empID=system_user.empSUId
	return template.query("select * from supplier_order inner join supp_order_device on supplier_order.supOrderID=supp_order_device.supOrdID where supplier_order.supOrderID="+id,new ResultSetExtractor<SupplierOrder>() {
		
		public SupplierOrder extractData(ResultSet rs) throws SQLException {
			
			SupplierOrder e= new SupplierOrder();
			while(rs.next()) {
				
				e.setSid(rs.getInt(1));
				e.setId(rs.getInt(2));
				//e.setLocation(rs.getString(4));
				e.setPaytyp(rs.getString(3));
				e.setDeltyp(rs.getString(5));
				e.setDate(rs.getDate(6));
				e.setDescription(rs.getString(4));
				e.setItem(rs.getInt(13));
				e.setQuantity(rs.getInt(14));
			}
			return e;
	}
				
	});
	
}

public void update(SupplierOrder c) {
	
	System.out.println(c.getItem());
	System.out.println(c.getQuantity());
	
	//String sql= "update client_order(custID,expectedDate,delLocation,paymentType,descrip,delType) set ("+c.getId()+",'"+c.getExdate()+"','"+c.getLocation()+"','"+c.getPaytyp()+"','"+c.getDescription()+"','"+c.getDeltyp()+"') where client_order.clieOrdID=\"+id";
	String sql= "update supplier_order set suID="+c.getId()+",dateOrdered='"+c.getDate()+"',payType='"+c.getPaytyp()+"',descr='"+c.getDescription()+"',delType='"+c.getDeltyp()+"' where supOrderID="+c.getSid()+";";
	String sql1="update supp_order_device set devicId="+c.getItem()+",quantity="+c.getQuantity()+" where supOrdID="+c.getSid()+";";
	System.out.println(sql);
	System.out.println(sql1);
	template.batchUpdate(sql,sql1);
}

public void delete(int sid) {
	
	String sql= "delete from supplier_order where supOrderID="+sid+";";
	String sql2= "delete from supp_order_device where supOrdID="+sid+";";
	System.out.println(sql);
	System.out.println(sql2);
	template.batchUpdate(sql2,sql);
}

public void payment(int oid) {
	
	String sql1= "update supplier_order set proceed_payment = 1 where supOrderID="+oid+";";
//	String sql2= "update device where clOrderID="+oid+";";
//	int quantity = template.query("select quantity from inventory where deviceID="+device, new ResultSetExtractor<Integer>() {
//		public Integer extractData(ResultSet rs) throws SQLException {
//			rs.next();
//			return rs.getInt(1);
//		}			
//	});
//	int newQuantity = quantity - qnty;
//	if(newQuantity >0) {
//		String sql2= "update inventory set quantity = "+newQuantity+" where deviceID="+device+";";
//		template.update(sql2);
//	} else {
//		System.out.println("error");
//	}
//	System.out.println(quantity);
	template.update(sql1);
}

}

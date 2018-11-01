package com.example.demo.dao.PaymentManagement;

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


import com.example.demo.model.PaymentManagement.SupplierPayment;


@Service
public class SupplierPaymentDAO {

	
	
	
	
	
	JdbcTemplate template;

	@Autowired
	public void setDataSource(DataSource datasource) {

		template = new JdbcTemplate(datasource);
	}

	
	public void Savesupplierpayments(SupplierPayment s) {

		String sql = "insert into suppplierpayments(date,supOrderID,amount,supName,chequeNumber,bank) Values ('" + s.getDate()
				+ "','" + s.getSupOrderID() + "','" + s.getAmount() + "','" + s.getSupName() + "','"
				+ s.getChequeNumber() + "','"+ s.getBank()+"')";

		template.update(sql);

	}
	
	public List<SupplierPayment> getSupplierRegister() {

		return template.query("select*from suppplierpayments", new ResultSetExtractor<List<SupplierPayment>>() {

			public List<SupplierPayment> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<SupplierPayment> list = new ArrayList<SupplierPayment>();
				while (rs.next()) {
					
					SupplierPayment supplierpayment = new SupplierPayment();
					
					supplierpayment.setSupplierpayID(rs.getInt(1));
					supplierpayment.setDate(rs.getString(2));
					supplierpayment.setSupOrderID(rs.getInt(3));
					supplierpayment.setAmount(rs.getInt(4));
					supplierpayment.setSupName(rs.getString(5));
					supplierpayment.setChequeNumber(rs.getInt(6));
					supplierpayment.setBank(rs.getString(7));
			
					list.add(supplierpayment);
				}
				return list;
			}
		});

	}
	

	
	public void deleteEntry(int id) {
		// TODO Auto-generated method stub
		String sql="delete from suppplierpayments where supplierpayId="+id+"";  
	    template.update(sql);  
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

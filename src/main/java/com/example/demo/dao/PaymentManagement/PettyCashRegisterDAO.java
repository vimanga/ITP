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

import com.example.demo.model.PaymentManagement.PettyCashRegister;

@Service
public class PettyCashRegisterDAO {

	JdbcTemplate template;

	@Autowired
	public void setDataSource(DataSource datasource) {

		template = new JdbcTemplate(datasource);
	}

	public void Save(PettyCashRegister p) {

		String sql = "insert into PettyCashRegister(date,amount,employeeId,reason,returnStatus) Values ('" + p.getDate()
				+ "','" + p.getAmount() + "','" + p.getEmployeeId() + "','" + p.getReason() + "','"
				+ p.getReturnStatus() + "')";

		template.update(sql);

	}

	public List<PettyCashRegister> getRegister() {

		return template.query("select*from pettycashregister", new ResultSetExtractor<List<PettyCashRegister>>() {

			public List<PettyCashRegister> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<PettyCashRegister> list = new ArrayList<PettyCashRegister>();
				while (rs.next()) {
					PettyCashRegister pettyCashRegister = new PettyCashRegister();
					pettyCashRegister.setPettyCashId(rs.getInt(1));
					pettyCashRegister.setDate(rs.getString(2));
					pettyCashRegister.setAmount(rs.getDouble(3));
					pettyCashRegister.setEmployeeId(rs.getInt(4));
					pettyCashRegister.setReason(rs.getString(5));
					pettyCashRegister.setReturnStatus(rs.getString(6));

					list.add(pettyCashRegister);
				}
				return list;
			}
		});

	}

	public List<PettyCashRegister> getRegisterByStatus() {

		return template.query("select*from pettycashregister where returnStatus='Pending' ",
				new ResultSetExtractor<List<PettyCashRegister>>() {

					public List<PettyCashRegister> extractData(ResultSet rs) throws SQLException, DataAccessException {

						List<PettyCashRegister> list = new ArrayList<PettyCashRegister>();
						while (rs.next()) {
							PettyCashRegister pettyCashRegister = new PettyCashRegister();
							pettyCashRegister.setPettyCashId(rs.getInt(1));
							pettyCashRegister.setDate(rs.getString(2));
							pettyCashRegister.setAmount(rs.getDouble(3));
							pettyCashRegister.setEmployeeId(rs.getInt(4));
							pettyCashRegister.setReason(rs.getString(5));
							pettyCashRegister.setReturnStatus(rs.getString(6));

							list.add(pettyCashRegister);
						}
						return list;
					}
				});

	}
	//Update

	public void edit(PettyCashRegister p) {
		String sql = "update PettyCashRegister set date='" + p.getDate() + "',amount='" + p.getAmount()+ "',employeeId='"
				+ p.getEmployeeId() + "',reason='" + p.getReason() + "',returnStatus='" + p.getReturnStatus()+ "' where pettyCashId=" + p.getPettyCashId();
		System.out.println(sql);
		template.update(sql);
	}

	
	
	
	public PettyCashRegister getRegisterById(int id) {
		// TODO Auto-generated method stub
				 return template.query("select * from PettyCashRegister where pettyCashId="+id,new ResultSetExtractor<PettyCashRegister>(){  
					    
				     public PettyCashRegister extractData(ResultSet rs) throws SQLException,  
				            DataAccessException {  
				      
				    	 PettyCashRegister pettyCashRegister=new PettyCashRegister();  
				        while(rs.next()){  
				        	
				        	pettyCashRegister.setPettyCashId(rs.getInt(1));
							pettyCashRegister.setDate(rs.getString(2));
							pettyCashRegister.setAmount(rs.getDouble(3));
							pettyCashRegister.setEmployeeId(rs.getInt(4));
							pettyCashRegister.setReason(rs.getString(5));
							pettyCashRegister.setReturnStatus(rs.getString(6));
				        
				        	
				        	
				        	
				        }  
				        return pettyCashRegister;  
				        }  
				    });  
			}
	
	
	
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from PettyCashRegister where pettyCashId="+id+"";  
	    template.update(sql);  
		
	}
	
	
	
	
	
	
	
	
	
}

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

import com.example.demo.model.PaymentManagement.ClientCashPayments;
import com.example.demo.model.PaymentManagement.ClientChequePayments;

@Service
public class ClientPaymentsDAO {

	JdbcTemplate template;

	@Autowired
	public void setDataSource(DataSource datasource) {

		template = new JdbcTemplate(datasource);
	}

	public void Save(ClientCashPayments p) {

		String sql = "insert into clientcashpayments(date,salesId,amount,customerName,discount) Values ('" + p.getDate()
				+ "','" + p.getSalesId() + "','" + p.getAmount() + "','" + p.getCustomerName() + "','" + p.getDiscount()
				+ "')";
		
		
		String sql1 = "UPDATE clientcashpayments SET paycode = concat( paytype,cashPayId ) where paytype='PAYCASH';";
			

		template.update(sql);
		template.update(sql1);

	}

public List<ClientCashPayments> getAllCashPayments() {
	
	
	
	return template.query("select*from clientcashpayments", new ResultSetExtractor<List<ClientCashPayments>>() {

		public List<ClientCashPayments> extractData(ResultSet rs) throws SQLException, DataAccessException {

			List<ClientCashPayments> list = new ArrayList<ClientCashPayments>();
			while (rs.next()) {
			
				
				ClientCashPayments c = new ClientCashPayments();
				
				c.setCashPayId(rs.getInt(1));
				c.setDate(rs.getString(2));
				c.setSalesId(rs.getInt(3));
				c.setAmount(rs.getDouble(4));
				c.setCustomerName(rs.getString(5));
				c.setDiscount(rs.getDouble(6));
				c.setPaycode(rs.getString(8));
				
				
				

				list.add(c);
			}
			return list;
		}
	});

	
}
	

	
	
	
	public void saveCheque(ClientChequePayments p) {

		String sql = "insert into ClientChequePayments(date,salesId,customerName,chequeNumber,bankedDate,bank,status,amount) Values ('" + p.getDate()
				+ "','" +p.getSalesId() + "','" + p.getCustomerName()+ "','" + p.getChequeNumber() + "','"
				+ p.getBankedDate()+ "', '"+ p.getBank()+"','"+p.getStatus() +"','"+p.getAmount() +"')";

		template.update(sql);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}

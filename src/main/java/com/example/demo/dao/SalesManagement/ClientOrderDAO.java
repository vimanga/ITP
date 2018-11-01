package com.example.demo.dao.SalesManagement;

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

import com.example.demo.model.SalesManagement.ClientOrderSales;




@Service
public class ClientOrderDAO {
	JdbcTemplate template;

	@Autowired
	public void setDataSource(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}

	// Retrieve All ClientOrders

	public List<ClientOrderSales> getAllCleintOrders() {
		
		return template.query("select * from client_order where expectedDate = current_date() AND status = '1'", new ResultSetExtractor<List<ClientOrderSales>>() {
			public List<ClientOrderSales> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<ClientOrderSales> list = new ArrayList<ClientOrderSales>();

				while (rs.next()) {

					ClientOrderSales e = new ClientOrderSales();

					e.setClienOrdID(rs.getInt(1));
					e.setCustID(rs.getInt(2));
					e.setExpectedDate(rs.getString(3));
					e.setDelLocation(rs.getString(4));
					e.setPaymentType(rs.getString(5));
					e.setDescrip(rs.getString(6));
					e.setDelType(rs.getString(7));

					list.add(e);
				}
				return list;
			}

		});

	}
	
	// Retrieve All Installation Certificates by range
	  public List<ClientOrderSales>getAllCleintOrdersByRange(String range_1,String range_2){
		  String sql="select * from client_order where expectedDate between '"+ range_1 +"' and '"+range_2+"';";
	  return template.query(sql,new ResultSetExtractor<List<ClientOrderSales>>(){ public
	  List<ClientOrderSales> extractData(ResultSet rs) throws
	  SQLException,DataAccessException{
	  List<ClientOrderSales> list = new ArrayList<ClientOrderSales>();
	
	  while (rs.next()) {
		  ClientOrderSales e = new ClientOrderSales();
			e.setClienOrdID(rs.getInt(1));
			e.setCustID(rs.getInt(2));
			e.setExpectedDate(rs.getString(3));
			e.setDelLocation(rs.getString(4));
			e.setPaymentType(rs.getString(5));
			e.setDescrip(rs.getString(6));
			e.setDelType(rs.getString(7));
System.out.println("Is this woriking?"+e.getDelLocation());
			list.add(e); } return list; }
	  
	  });
	  
	  
	  
	  
	  
	  }
	  
//Get orders by ID
	  public ClientOrderSales getOrdersByID(int id) {

			return template.query("select * from client_order where clieOrdID=" + id,
					new ResultSetExtractor<ClientOrderSales>() {
						public ClientOrderSales extractData(ResultSet rs) throws SQLException, DataAccessException {

							ClientOrderSales e = new ClientOrderSales();
							while (rs.next()) {

								
							e.setClienOrdID(rs.getInt(1));

						

							}
							return e;
						}

					});
		}
	  
	
	
	

		 
	
	
	
}

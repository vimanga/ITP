package com.example.demo.dao.ClientManagement;


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

import com.example.demo.model.ClientManagement.Client;

@Service
public class ClientDAO {

	JdbcTemplate template;
	
	@Autowired
	public void setDataSource(DataSource datasource) {
		
		template = new JdbcTemplate(datasource);
	}
	
	//Add info to the client table
	public void save(Client p) {
		
		String sql="insert into client(clientName,companyName,email,contactNumber,postalCode,city,street,regDate) values ('"+p.getClientName()+"','"+p.getCompanyName()+"','"+p.getEmail()+"',"+p.getContactNumber()+","+p.getPostalCode()+",'"+p.getCity()+"','"+p.getStreet()+"','"+p.getRegDate()+"')";
		
		String sql2 = "update client SET clientCode = concat(clientPrefix,clientID)";
		
		template.batchUpdate(sql,sql2);
	}
	
	
	public List <Client> getAllClients(){
		
		return template.query("select clientID,companyName from client",new ResultSetExtractor<List<Client>>() {
			
			public List<Client> extractData(ResultSet rs) throws SQLException,
			        DataAccessException{
				
				List<Client> list = new ArrayList<Client>();
				while(rs.next()) {
					
					Client C = new Client();
					
					C.setClientID(rs.getInt(1));
					C.setCompanyName(rs.getString(2));
					
					list.add(C);
					
				}
				
				return list;
			}
		});
	}
	
	
	public void update(Client cl) {
		
		String sql= "update client set clientName='"+cl.getClientName()+"',companyName='"+cl.getCompanyName()+"',email='"+cl.getEmail()+"',contactNumber="+cl.getContactNumber()+",postalCode="+cl.getPostalCode()+",city='"+cl.getCity()+"',street='"+cl.getStreet()+"' where clientID="+cl.getClientID()+"";
		System.out.println("Update methode:"+cl.getClientID());
		System.out.println("UPDATE SQL :"+sql);
		template.update(sql);
	}
	
    public void delete(int clientid) {
    	    	
    	String sql = "delete from branch where clID= "+clientid+"";
    	String sql2 = "delete from client where clientID= "+clientid+"";
    	
    	template.batchUpdate(sql,sql2);
    }

	

	public Client getClientupdate(int clientID) {

       return template.query("select * from client where clientID ="+clientID,new ResultSetExtractor<Client>() {
			
			public Client extractData(ResultSet rs) throws SQLException,
			        DataAccessException{
				
				Client C = new Client();			
				while(rs.next()) {
					
					C.setClientID(rs.getInt(2));
					C.setClientName(rs.getString(4));
					C.setCompanyName(rs.getString(5));
					C.setEmail(rs.getString(6));
					C.setContactNumber(rs.getInt(7));
					C.setPostalCode(rs.getInt(8));
					C.setCity(rs.getString(9));
					C.setStreet(rs.getString(10));
					C.setRegDate(rs.getString(11));			
					
				}
				
				return C;
			}
		});
	}

	//get Client details to the Client profile
	public Client getDetails(int clientID) {
	
       return template.query("select * from client where clientID ="+clientID,new ResultSetExtractor<Client>() {
			
			public Client extractData(ResultSet rs) throws SQLException,
			        DataAccessException{
				
				Client C = new Client();			
				while(rs.next()) {
					
					C.setClientID(rs.getInt(2));
					C.setClientCode(rs.getString(3));
					C.setClientName(rs.getString(4));
					C.setCompanyName(rs.getString(5));
					C.setEmail(rs.getString(6));
					C.setContactNumber(rs.getInt(7));
					C.setPostalCode(rs.getInt(8));
					C.setCity(rs.getString(9));
					C.setStreet(rs.getString(10));	
					C.setRegDate(rs.getString(11));
			
				}
				
				return C;
			}
		});
	}

	public Client getCleintOrderDetails(int clientID) {
		
       return template.query("select * from client left outer join client_order_device on client.clientID = cod.cliID where cliID = "+clientID+"",new ResultSetExtractor<Client>() {
			
			public Client extractData(ResultSet rs) throws SQLException,
			        DataAccessException{
				
				Client C = new Client();			
				while(rs.next()) {
					
					C.setClOrderID(rs.getInt(1));
					C.setDeviID(rs.getInt(2));
					C.setQuan(rs.getInt(4));
			 
				}
				
				return C;
				
			}
		});
	}

	
     public List <Client> getAllClientEmails(){
		
		return template.query("select email from client",new ResultSetExtractor<List<Client>>() {
			
			public List<Client> extractData(ResultSet rs) throws SQLException,
			        DataAccessException{
				
				List<Client> list = new ArrayList<Client>();
				while(rs.next()) {
					
					Client C = new Client();
					
					C.setEmail(rs.getString(6));
					
					list.add(C);
					
				}
				
				return list;
			}
		});
	 }
     
     
     //save branch details
     public void saveBranch(Client b,int id) {
 		
 		String sql="insert into branch(bCity, bAddress,clID) values('"+b.getbCity()+"','"+b.getbAddress()+"',"+id+")";
 		
 		template.update(sql);
 	}
     
     
 	 
    
	public List<Client> getAllBranchDetails(int clientID) {
		
    return template.query("select * from client left outer join branch on client.clientID = branch.clID where clID = "+clientID+"",new ResultSetExtractor<List<Client>>() {
			
			public List<Client> extractData(ResultSet rs) throws SQLException,
			        DataAccessException{
				
				List<Client> list = new ArrayList<Client>();
				while(rs.next()) {
					
					Client C = new Client();
					
					C.setClientID(rs.getInt(2));
					C.setBranchID(rs.getInt(12));
				    C.setbCity(rs.getString(14));
				    C.setbAddress(rs.getString(15));
					
					list.add(C);
					
				}
				
				return list;
			}
			
		});
	}
	
	
	
}


package com.example.demo.dao.VisitorManagement;




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

import com.example.demo.model.VisitorManagement.Visitor;

@Service
public class VisitorDAO {

	JdbcTemplate template;
	
	@Autowired
	
	public void setDataSource(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	
	public void save(Visitor v) {
	
		
		String sql1 = "insert into appointment(appcode,appdate,comments,assigned_employee,stat,visitorName,companyName,contactNumber,mail) values('abc','"+v.getAppdate()+"','"+v.getComments()+"','"+v.getAssigned_employee()+"','"+v.getStat()+"','"+v.getVisitorName()+"','"+v.getCompanyName()+"','"+v.getContactNumber()+"','"+v.getMail()+"')";
	    String sql6 = "UPDATE appointment SET appcode = concat(appstr,appID)";
	    String sql5 = "SET @last_id_in_vis = Last_Insert_ID();";
	   
	    String sql7 = "insert into visitor_email(emailID,companyName,dateSent,visitorName,appID)values('"+v.getEmailID()+"','"+v.getCompanyName()+"','"+v.getSentDate()+"','"+v.getVisitorName()+"',@last_id_in_vis)";
	  
		
		System.out.println(sql1);
		System.out.println(sql6);
		System.out.println(sql5);
		System.out.println(sql7);
	    
		template.batchUpdate(sql1,sql6,sql5,sql7);
		
	}
	
public List<Visitor> getAllAppointments(){
		
		return template.query("select * from appointment",new ResultSetExtractor<List<Visitor>>(){
	
		
			public List<Visitor> extractData(ResultSet rs) throws SQLException,DataAccessException
			{
				List<Visitor> list = new ArrayList<Visitor>();
				
				while(rs.next()){
					
					Visitor v = new Visitor();
					

					v.setAppcode(rs.getString(3));
					v.setVisitorName(rs.getString(8));
					v.setCompanyName(rs.getString(9));
					v.setAppdate(rs.getDate(4));
			
					v.setAssigned_employee(rs.getString(6));
					v.setStat(rs.getString(7));
					
					list.add(v);
				}
				
				return list;
			}
		});
	}



public List<Visitor> getAllAppointmentsbypage(int pageid,int total){
	
	String sql = "select * from appointment limit"+(pageid - 1)+","+total;
    return template.query(sql, new ResultSetExtractor<List<Visitor>>(){

	
		public List<Visitor> extractData(ResultSet rs) throws SQLException,DataAccessException
		{
			List<Visitor> list = new ArrayList<Visitor>();
			
			while(rs.next()){
				
				Visitor v = new Visitor();

				v.setAppcode(rs.getString(3));
				v.setVisitorName(rs.getString(8));
				v.setCompanyName(rs.getString(9));
				v.setAppdate(rs.getDate(4));
		
				v.setAssigned_employee(rs.getString(6));
				v.setStat(rs.getString(7));
				
				list.add(v);
			}
			
			return list;
		}
	});
}


public Visitor getAllAppointmentsbyid(String appcode){
	
	return template.query("select * from appointment where appcode = '"+appcode+"'",new ResultSetExtractor<Visitor>(){

	
		public Visitor extractData(ResultSet rs) throws SQLException,DataAccessException
		{
			Visitor v = new Visitor();
			
			while(rs.next()){
				
				

				v.setAppcode(rs.getString(3));
				v.setComments(rs.getString(5));
			    v.setMail(rs.getString(11));
			    v.setContactNumber(rs.getString(10));
				v.setVisitorName(rs.getString(8));
				v.setCompanyName(rs.getString(9));
				v.setAppdate(rs.getDate(4));
				
				v.setAssigned_employee(rs.getString(6));
				v.setStat(rs.getString(7));
				
				
			}
			
			return v;
		}
	});
}

public void edit(Visitor v) { 

	String sql = "update appointment set appdate ='"+v.getAppdate()+"',comments ='"+v.getComments()+"',assigned_employee ='"+v.getAssigned_employee()+"',stat ='"+v.getStat()+"',visitorName ='"+v.getVisitorName()+"',companyName ='"+v.getCompanyName()+"',contactNumber ='"+v.getContactNumber()+"',mail='"+v.getMail()+"' where appcode = '"+v.getAppcode()+"' ;";
	String sql1 = "update visitor_email set companyName = '"+v.getCompanyName()+"',visitorName = '"+v.getVisitorName()+"'";
	System.out.println(sql);
	System.out.println(sql1);

	template.batchUpdate(sql,sql1);
	

}




public void deleteapp(String appcode){

	String sql1 = "delete from visitor_email where appID IN (select appID from appointment where appcode='"+appcode+"')";
String sql2 = "delete from appointment where appcode ='"+appcode+"'";

System.out.println(sql1);
System.out.println(sql2);
 template.update(sql1);
template.update(sql2);

}

public int count(){
	String sql4  = "select count(*) from appointment";
	int count = template.queryForObject(sql4,Integer.class);
	return count;
}

public List<Visitor> getCount(){
	
	return template.query("select companyName,count(visitorName) from appointment group by companyName;",new ResultSetExtractor<List<Visitor>>(){

	
		public List<Visitor> extractData(ResultSet rs) throws SQLException,DataAccessException
		{
			List<Visitor> list = new ArrayList<Visitor>();
			
			while(rs.next()){
				
				Visitor v = new Visitor();
				

				v.setCompanyName(rs.getString(1));
				v.setCount(rs.getInt(2));
				
				list.add(v);
			}
			
			return list;
		}
	});
}


 



}
    


	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					
			

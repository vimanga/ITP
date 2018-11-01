package com.example.demo.dao.FaultManagement;



import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.FaultManagement.Fault;
import com.example.demo.model.FaultManagement.Technicianfault;

@Service
public class FaultDao {

	JdbcTemplate template;
	
	
	@Autowired
	public void setTemplate(JdbcTemplate template ) {  
	    this.template = template;  
	    
	}  
	
	@Autowired
	public void setDataSource(DataSource datasource) {
		
		template= new JdbcTemplate(datasource);
		
		
	}
	
	
	
	public void save(Fault f) {
		
		String sql= "insert into fault(nature,priority,status,category,cID,brID,descrip,reportedBy,fixedby,reportedDate) values ('"+f.getNature()+"','"+f.getPriority()+"','"+f.getStatus()+"','"+f.getCategory()+"','"+f.getCliID()+"','"+f.getBrID()+"','"+f.getDescrip()+"','"+f.getReportedBy()+"','"+f.getFixedBy()+"','"+f.getReportedOn()+"')";
		System.out.println(sql);
		template.update(sql);
		String sql2 = "update fault set faID=concat(jstr,jobID)";
		System.out.println(sql2);
		template.update(sql2);


	}
	
	public List<Fault> getAllFaults() {
		
		
		return template.query("select * from fault where status='Pending'",new ResultSetExtractor<List<Fault>>(){  
		    
		     public List<Fault> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Fault> list=new ArrayList<Fault>();  
		        while(rs.next()){  
		        Fault e=new Fault();  
		        e.setFaID(rs.getString(14));
		        e.setNature(rs.getString(2));  
		        e.setPriority(rs.getString(3));  
		        e.setStatus(rs.getString(4));
		        e.setCategory(rs.getString(5));
		        e.setCliID(rs.getInt(6));
		        e.setBrID(rs.getInt(7));  
		        e.setDescrip(rs.getString(8));
		        e.setReportedBy(rs.getString(9));
		        e.setFixedBy(rs.getDate(10));
		        e.setReportedOn(rs.getDate(11));
		        e.setIsassigned(rs.getBoolean(12));
		        e.setId(rs.getInt(1));
		        
		        list.add(e);  
		        }  
		        return list;  
		        }  
		    });  
		  
		
		  }
	
	
public List<Fault> getAllfinishedFaults() {
		
		
		return template.query("select * from fault where status='Completed'",new ResultSetExtractor<List<Fault>>(){  
		    
		     public List<Fault> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Fault> list=new ArrayList<Fault>();  
		        while(rs.next()){  
		        Fault e=new Fault();  
		        e.setFaID(rs.getString(14));
		        e.setNature(rs.getString(2));  
		        e.setPriority(rs.getString(3));  
		        //e.setStatus(rs.getString(4));
		        e.setCategory(rs.getString(5));
		        e.setCliID(rs.getInt(6));
		        e.setBrID(rs.getInt(7));  
		        e.setDescrip(rs.getString(8));
		        e.setReportedBy(rs.getString(9));
		        e.setFixedBy(rs.getDate(10));
		        e.setReportedOn(rs.getDate(11));
		        e.setIsassigned(rs.getBoolean(12));
		        e.setId(rs.getInt(1));
		        
		        list.add(e);  
		        }  
		        return list;  
		        }  
		    });  
		  
		
		  }


	public List<Fault> gettodayjobs(){
		
		
		
		return template.query("select * from fault where jobID IN (select faultid from fault_tech where assDate=CURDATE())",new ResultSetExtractor<List<Fault>>(){  
		    
		     public List<Fault> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Fault> list=new ArrayList<Fault>();  
		        while(rs.next()){  
		        Fault e=new Fault();  
		        e.setFaID(rs.getString(14));
		        e.setNature(rs.getString(2));  
		        e.setPriority(rs.getString(3));  
		        e.setStatus(rs.getString(4));
		        e.setCategory(rs.getString(5));
		        e.setCliID(rs.getInt(6));
		        e.setBrID(rs.getInt(7));  
		        e.setDescrip(rs.getString(8));
		        e.setReportedBy(rs.getString(9));
		        e.setFixedBy(rs.getDate(10));
		        e.setReportedOn(rs.getDate(11));
		        e.setIsassigned(rs.getBoolean(12));
		        e.setId(rs.getInt(1));
		        
		        list.add(e);  
		        }  
		        return list;  
		        }  
		    });  
	}
	
	public List<Fault> geturgentJobs() {
		
		
		return template.query("select * from fault where status='pending' and priority='Urgent'",new ResultSetExtractor<List<Fault>>(){  
		    
		     public List<Fault> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Fault> list=new ArrayList<Fault>();  
		        while(rs.next()){  
		        Fault e=new Fault();  
		        e.setFaID(rs.getString(14));
		        e.setNature(rs.getString(2));  
		        e.setPriority(rs.getString(3));  
		        //e.setStatus(rs.getString(4));
		        e.setCategory(rs.getString(5));
		        e.setCliID(rs.getInt(6));
		        e.setBrID(rs.getInt(7));  
		        e.setDescrip(rs.getString(8));
		        e.setReportedBy(rs.getString(9));
		        e.setFixedBy(rs.getDate(10));
		        e.setReportedOn(rs.getDate(11));
		        e.setIsassigned(rs.getBoolean(12));
		        e.setId(rs.getInt(1));
		        
		        list.add(e);  
		        }  
		        return list;  
		        }  
		    });  
		  
		
		  }

		public List<Fault> getStudentsByPage(int pageid, int total) {
			// TODO Auto-generated method stub
			String sql="select * from fault limit "+(pageid-1)+","+total;  
			return template.query(sql,new ResultSetExtractor<List<Fault>>(){  
		    
		     public List<Fault> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Fault> list=new ArrayList<Fault>();  
		        
		        while(rs.next()){  
		        	Fault e=new Fault();  
		        	e.setId(rs.getInt(1));  
			        e.setNature(rs.getString(2));  
			        e.setPriority(rs.getString(3));  
			        e.setStatus(rs.getString(4));
			        e.setCategory(rs.getString(5));
			        e.setCliID(rs.getInt(6));
			        e.setBrID(rs.getInt(7));  
			        e.setDescrip(rs.getString(8));
			        e.setReportedBy(rs.getString(9));
			        e.setFixedBy(rs.getDate(10));
			        e.setReportedOn(rs.getDate(11));
			        e.setIsassigned(rs.getBoolean(12));

			        list.add(e);  
		        }  
		        return list;  
		        }  
		    });  
		  }
	
		public Fault getFaultById(int id) {
			// TODO Auto-generated method stub
					 return template.query("select * from fault where jobID="+id+"",new ResultSetExtractor<Fault>(){  
					     public Fault extractData(ResultSet rs) throws SQLException,  
					            DataAccessException {  
							  

					    	 Fault e=new Fault();  
					        while(rs.next()){  
					       
					        	e.setId(rs.getInt(1));  
						        e.setNature(rs.getString(2));  
						        e.setPriority(rs.getString(3));  
						        e.setStatus(rs.getString(4));
						        e.setCategory(rs.getString(5));
						        e.setCliID(rs.getInt(6));
						        e.setBrID(rs.getInt(7));  
						        e.setDescrip(rs.getString(8));
						        e.setReportedBy(rs.getString(9));
						        e.setFixedBy(rs.getDate(10));
						        e.setReportedOn(rs.getDate(11));
						        e.setIsassigned(rs.getBoolean(12));
					        }  
					        return e;  
					        }  
					    });  
				}
		
		public int count() {
			String sql="select count(*) from fault";
			int count = template.queryForObject(sql,Integer.class);
			return count;
			  }



		public void update(Fault p) {
			String sql="update fault set nature='"+p.getNature()+"',priority='"+p.getPriority()+"',status='"+p.getStatus()+"',category='"+p.getCategory()+"',cID='"+p.getCliID()+"',brID='"+p.getBrID()+"',descrip='"+p.getDescrip()+"' ,reportedBy='"+p.getReportedBy()+"', fixedby='"+p.getFixedBy()+"',reportedDate='"+p.getReportedOn()+"' where jobID="+p.getId()+"";
			System.out.println(sql);
	       template.update(sql);  
		}



		public void delete(int id) {
			// TODO Auto-generated method stub
			String sql="delete from fault where jobID="+id+""; 
			System.out.println(sql);
			Fault fault=getFaultById(id);
			if(fault.isIsassigned()) {
				String sql2= "delete from fault_tech where faultid="+id+"";
				String sql3="update other_emps set availability=1 where empOTId IN (select empid from fault_tech where faultid="+id+")";
				System.out.println(sql2);
				System.out.println(sql3);
				template.update(sql3);
				template.update(sql2);
			}
		    template.update(sql);  
			
		}



		public void delete() {
			// TODO Auto-generated method stub
			String sql="delete from fault where jobID>0";  
		    template.update(sql); 
		}

		
	
}

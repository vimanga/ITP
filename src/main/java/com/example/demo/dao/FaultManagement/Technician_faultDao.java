package com.example.demo.dao.FaultManagement;



import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import org.springframework.stereotype.Service;

import com.example.demo.model.FaultManagement.Fault;
import com.example.demo.model.FaultManagement.Technicianfault;


@Service
public class Technician_faultDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	
	@Autowired
	public void setDataSource(DataSource datasource) {
		
		template= new JdbcTemplate(datasource);
		
	}
	
	public void save(Technicianfault f) {
		
		String sql1="insert into fault_tech(faultid,empid,assDate) values ('"+f.getFaultid()+"','"+f.getEmpid()+"','"+f.getAssDate()+"')";
		String sql2="update fault set isassigned=true where jobID='"+f.getFaultid()+"'";
		String sql3="update other_emps set availability=0 where empOTId="+f.getEmpid()+"";
		System.out.println(sql1);
		System.out.println(sql2);
		System.out.println(sql3);
		template.batchUpdate(sql1,sql2);
		template.update(sql3);
	}

	//public int getJobID(int id) {
		
	public Technicianfault getStudentById(int id) {
		// TODO Auto-generated method stub
				 return template.query("select * from fault_tech where faulttechID="+id+"",new ResultSetExtractor<Technicianfault>(){  
				     public Technicianfault extractData(ResultSet rs) throws SQLException,  
				            DataAccessException {  
						  

				    	 Technicianfault e=new Technicianfault();  
				        while(rs.next()){  
				        	e.setFaulttechID(rs.getInt(1));
				        	
				        	e.setFaultid(rs.getInt(2));
				        	e.setEmpid(rs.getInt(3));
				        	e.setAssDate(rs.getDate(4));
				        	
				        }  
				        return e;  
				        }  
				    });  
			}
	
	
public List<Technicianfault> getAllTechDetails() {
		
		
		return template.query("select * from fault_tech",new ResultSetExtractor<List<Technicianfault>>(){  
		    
		     public List<Technicianfault> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Technicianfault> list=new ArrayList<Technicianfault>();  
		        while(rs.next()){  
		        	Technicianfault e=new Technicianfault();  
		        e.setFaulttechID(rs.getInt(1));
	        	
	        	e.setFaultid(rs.getInt(2));
	        	e.setEmpid(rs.getInt(3));
	        	e.setAssDate(rs.getDate(4));
		        
		        list.add(e);  
		        }  
		        return list;  
		        }  
		    });  
		  
		
		  }

	public Technicianfault getTechid(int id) {
		// TODO Auto-generated method stub
				 return template.query("select * from fault_tech where faultid="+id+"",new ResultSetExtractor<Technicianfault>(){  
				     public Technicianfault extractData(ResultSet rs) throws SQLException,  
				            DataAccessException {  
						  

				    	 Technicianfault e=new Technicianfault();  
				        while(rs.next()){  
				        	e.setFaulttechID(rs.getInt(1));
				        	
				        	e.setFaultid(rs.getInt(2));
				        	e.setEmpid(rs.getInt(3));
				        	e.setAssDate(rs.getDate(4));
				        	
				        }  
				        return e;  
				        }  
				    });  
			}
	
	public void update(Technicianfault p) {
		String sql="update fault_tech set empid='"+p.getEmpid()+"',assDate='"+p.getAssDate()+"' where faultid="+p.getFaultid()+"";
		System.out.println(sql);
		String sql1="update other_emps set availability=0 where empOTId="+p.getEmpid()+"";
		System.out.println(sql1);
       template.update(sql);
       template.update(sql1);
	}



	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from fault_tech where faultid="+id+"";  
		String sql2="update fault set isassigned=false where jobID="+id+"";
		String sql1="update other_emps set availability=1 where empOTId IN (select empid from fault_tech where faultid="+id+")";
		template.update(sql1);
		template.batchUpdate(sql, sql2);
	    System.out.println(sql);
	    System.out.println(sql2);
	    System.out.println(sql1);
	    
		
	}
	
	public void updatetech(int emid) {
		String sql ="update other_emps set availability=1 where empOTId IN (select empid from fault_tech where faultid="+emid+")";
		System.out.println(sql);
		template.update(sql);
	}


}		
	//}
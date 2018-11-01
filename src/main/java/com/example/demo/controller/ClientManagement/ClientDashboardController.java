package com.example.demo.controller.ClientManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class ClientDashboardController {

	public static int chart_A() throws SQLException, ClassNotFoundException 
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
		Statement st = (Statement) con.createStatement();
		
		String query1 = "select count(*) from(select substring(regDate,1,4) as year  from client) as t where year='2015';";
		ResultSet rs1 = st.executeQuery(query1);
		String Countrow1="";
		while(rs1.next())
		{
			
			Countrow1 = rs1.getString(1);
			
		}
		
	  	return Integer.parseInt(Countrow1);
		
	}
	
  	public static int chart_B() throws SQLException, ClassNotFoundException 
  	{
  		
  		
  		Class.forName("com.mysql.jdbc.Driver");
		Connection con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
		Statement st = (Statement) con.createStatement();
  		
  		String query2 = "select count(*) from(select substring(regDate,1,4) as year  from client) as t where year='2016';";
  		ResultSet rs2 = st.executeQuery(query2);
  		String Countrow2="";
  		while(rs2.next())
  		{
  			
  			Countrow2 = rs2.getString(1);
  			
  		}
  		
  	  	return Integer.parseInt(Countrow2);
  		
  	}
  	
  	public static int chart_C() throws ClassNotFoundException, SQLException 
  	{
  		
  		Class.forName("com.mysql.jdbc.Driver");
		Connection con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
		Statement st = (Statement) con.createStatement();
  		
  		String query3 = "select count(*) from(select substring(regDate,1,4) as year  from client) as t where year='2017';";
  		ResultSet rs3 = st.executeQuery(query3);
  		String Countrow3="";
  		while(rs3.next())
  		{
  			
  			Countrow3 = rs3.getString(1);
  			
  		}
  		
  	  	return Integer.parseInt(Countrow3);	
  		
  		
  	}
  		
  	
  	public static int chart_D() throws SQLException, ClassNotFoundException 
  	{
  		
  		Class.forName("com.mysql.jdbc.Driver");
		Connection con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
		Statement st = (Statement) con.createStatement();
  		
  		String query4 = "select count(*) from(select substring(regDate,1,4) as year  from client) as t where year='2018';";
  		ResultSet rs4 = st.executeQuery(query4);
  		String Countrow4="";
  		while(rs4.next())
  		{
  			
  			Countrow4 = rs4.getString(1);
  			
  		}
  		
  	  	return Integer.parseInt(Countrow4);	
  		
  	}

}
 
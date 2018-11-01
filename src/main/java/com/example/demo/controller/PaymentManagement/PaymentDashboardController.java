package com.example.demo.controller.PaymentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class PaymentDashboardController {

	
	
	
	

	
	
	
	public static int chartX() throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
		Statement st = (Statement) con.createStatement();
		
		String query1 = "Select Count(*) from pettycashregister where returnStatus='Pending'";
		ResultSet rs1 = st.executeQuery(query1);
		String Countrow1="";
		while(rs1.next())
		{
			
			Countrow1 = rs1.getString(1);
			
		}
		
		
		return Integer.parseInt(Countrow1);	
	
	}
	

	public static int chartY() throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
		Statement st = (Statement) con.createStatement();
		
		String query1 = "Select Count(*) from pettycashregister where returnStatus='Completed'";
		ResultSet rs1 = st.executeQuery(query1);
		String Countrow1="";
		while(rs1.next())
		{
			
			Countrow1 = rs1.getString(1);
			
		}
		
		
		return Integer.parseInt(Countrow1);	
	
	}
	
	public static int chartA() throws SQLException, ClassNotFoundException 
  	{
  		
  		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
		Statement st = (Statement) con.createStatement();

		String query4 = "Select SUM(amount) from pettycashregister where returnStatus='Completed'";
		ResultSet rs4 = st.executeQuery(query4);
		String Countrow4="";
		while(rs4.next())
		{
			
			Countrow4 = rs4.getString(1);
			
		}
		
		
		return Integer.parseInt(Countrow4);	
  		
  		
  	}
  	

	
	
	
	public static int chartB() throws SQLException, ClassNotFoundException 
  	{
  		
  		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
		Statement st = (Statement) con.createStatement();

		String query4 = "Select SUM(amount) from pettycashregister where returnStatus='Pending'";
		
		ResultSet rs4 = st.executeQuery(query4);
		String Countrow4="";
		while(rs4.next())
		{
			
			Countrow4 = rs4.getString(1);
			
		}
		
		
		return Integer.parseInt(Countrow4);	
  		
  		
  	}
  	
	
	
	
	
	
	
	
	
	
	  
/*	public static int chartY() throws SQLException, ClassNotFoundException 
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
		Statement st = (Statement) con.createStatement();
		
		String query2 = "Select Count(*) from employee where designation='Driver'";
		ResultSet rs2 = st.executeQuery(query2);
		String Countrow2="";
		while(rs2.next())
		{
			
			Countrow2 = rs2.getString(1);
			
		}
		
	  	return Integer.parseInt(Countrow2);	
		
	}	
	*/
	 
	
	public static int chartW() throws SQLException, ClassNotFoundException 
  	{
  		
  		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
		Statement st = (Statement) con.createStatement();

		String query4 = "Select SUM(amount) from clientcashpayments";
		ResultSet rs4 = st.executeQuery(query4);
		String Countrow4="";
		while(rs4.next())
		{
			
			Countrow4 = rs4.getString(1);
			
		}
		
		
		return Integer.parseInt(Countrow4);	
  		
  		
  	}
  	
	public static int chartM() throws SQLException, ClassNotFoundException 
  	{
  		
  		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
		Statement st = (Statement) con.createStatement();

		String query4 = "Select SUM(amount) from clientchequepayments";
		ResultSet rs4 = st.executeQuery(query4);
		String Countrow4="";
		while(rs4.next())
		{
			
			Countrow4 = rs4.getString(1);
			
		}
		
		
		return Integer.parseInt(Countrow4);	
  		
  		
  	}
  	
	
	public static int chartl() throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
		Statement st = (Statement) con.createStatement();
		
		String query1 = "Select Count(*) from clientchequepayments where status='Pending'";
		ResultSet rs1 = st.executeQuery(query1);
		String Countrow1="";
		while(rs1.next())
		{
			
			Countrow1 = rs1.getString(1);
			
		}
		
		
		return Integer.parseInt(Countrow1);	
	
	}
	
	
	public static int chartm() throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
		Statement st = (Statement) con.createStatement();
		
		String query1 = "Select Count(*) from clientchequepayments where status='Cleared'";
		ResultSet rs1 = st.executeQuery(query1);
		String Countrow1="";
		while(rs1.next())
		{
			
			Countrow1 = rs1.getString(1);
			
		}
		
		
		return Integer.parseInt(Countrow1);	
	
	}
	
	public static int chartz() throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
		Statement st = (Statement) con.createStatement();
		
		String query1 = "Select SUM(amount) from clientchequepayments";
		ResultSet rs1 = st.executeQuery(query1);
		String Countrow1="";
		while(rs1.next())
		{
			
			Countrow1 = rs1.getString(1);
			
		}
		
		String query2 = "Select SUM(amount) from clientcashpayments";
		ResultSet rs2 = st.executeQuery(query2);
		String Countrow2="";
		while(rs2.next())
		{
			
			Countrow2 = rs2.getString(1);
			
		}
		
		
		return Integer.parseInt(Countrow1)+Integer.parseInt(Countrow2)	;
	
	}
	
	public static int chartx() throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
		Statement st = (Statement) con.createStatement();
		
		String query1 = "Select SUM(amount) from pettycashregister";
		ResultSet rs1 = st.executeQuery(query1);
		String Countrow1="";
		while(rs1.next())
		{
			
			Countrow1 = rs1.getString(1);
			
		}
		
		
		return Integer.parseInt(Countrow1);
	
	}
	
	public static int chartemp() throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
		Statement st = (Statement) con.createStatement();
		
		String query1 = "Select SUM(basicSalary) from employee";
		ResultSet rs1 = st.executeQuery(query1);
		String Countrow1="";
		while(rs1.next())
		{
			
			Countrow1 = rs1.getString(1);
			
		}
		
		
		return Integer.parseInt(Countrow1);
	
	}
	
	
	
	
}

<%@ page language="java" contentType="application/pdf; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="net.sf.jasperreports.engine.design.JRDesignQuery"%>
<%@page import="net.sf.jasperreports.engine.design.JasperDesign"%>
<%@page import="net.sf.jasperreports.engine.xml.JRXmlLoader"%>
<%@page import="java.util.HashMap"%>
<%@ page trimDirectiveWhitespaces="true" %>   
<%@ page import="net.sf.jasperreports.engine.*" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.InputStream" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

 
 
<% Connection con=null;  
 
 	Class.forName("com.mysql.jdbc.Driver");
 	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
 
 	
 	String jrxmlFile = session.getServletContext().getRealPath("/jsp/InventoryManagement/InventoryReport.jrxml");
 	
 	InputStream input = new FileInputStream(new File(jrxmlFile));
 	
 	JasperReport jasperReport = JasperCompileManager.compileReport(input);
 	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,con);
 	
    JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
 	
 	response.getOutputStream().flush();
 	response.getOutputStream().close();
 	
  	con.close();
 	
 	
 	
 	%>

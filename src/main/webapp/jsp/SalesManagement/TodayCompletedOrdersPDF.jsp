<%@ page language="java" contentType="application/pdf; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="net.sf.jasperreports.engine.JasperExportManager"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.JasperCompileManager"%>
<%@ page trimDirectiveWhitespaces="true" %> 
<%@page import="net.sf.jasperreports.engine.JasperReport"%>
<%@page import="net.sf.jasperreports.engine.design.JRDesignQuery"%>
<%@page import="java.io.File"%>
<%@page import="net.sf.jasperreports.engine.xml.JRXmlLoader"%>
<%@page import="net.sf.jasperreports.engine.design.JasperDesign"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>


    
    <% Connection con=null;  
 
	
	 	Class.forName("com.mysql.jdbc.Driver");
	 	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
	 
	 	String jrxmlFile = session.getServletContext().getRealPath("/jsp/SalesManagement/TodayCompletedOrders.jrxml");
		
	 
		
		JasperDesign jd= JRXmlLoader.load(new File(jrxmlFile));
		JRDesignQuery newQuery = new JRDesignQuery();
	 	newQuery.setText("SELECT * FROM sales where dateCompleted = current_date();");
	 	jd.setQuery(newQuery);
	  
	 	
	 	JasperReport jasperReport = JasperCompileManager.compileReport(jd);
	 	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,con);
	 	
	 	JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	 	
	 	response.getOutputStream().flush();
	 	response.getOutputStream().close();
	 	
	 	con.close();
 	
 	
 	
 	%>

    
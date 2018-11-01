<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  <%@ page isELIgnored="false" %>
  <%@page import="java.sql.Statement"%>
  <%@page import="java.sql.Connection"%>
  <%@page import="java.sql.ResultSet"%>
  <%@page import="java.sql.DriverManager"%>   
<!DOCTYPE html>
<html>
<head>
      <meta charset="ISO-8859-1">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	  <link rel="stylesheet" href="css/bootstrap.css">
	  <link rel="stylesheet" href="css/custom.css">
      <script src="js/jquery.js"></script>
      <script src="js/proper.js"></script>
	  <script src="js/bootstrap.js"></script>
	 	
      <title>Client Profile</title>
</head>
<body>


<% 
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma","no-cache"); //HTTP 1.0
		response.setHeader("Expires","0");  //Proxies

		if(session.getAttribute("USER")== null)
		{
			response.sendRedirect("signin");
		}
		
	%>
	<div class="container-fluid" style="height: 2000px">
		<div class="row" >
			<div class="header">
				<img src="Images/logo.png" style="width:12%;margin-left: 2%">
 				<font style="font-family: Good Times; font-size: 230%"><span style="color: white;margin-left: 2%;">Automated Barcode Solutions</span></font>
 				<a href="signout"><font style="font-family: Good Times; font-size: 100%"><span style="color: white;margin-left: 90%;">Sign Out</span></font></a>
 					<div class="navbar">
						<div class="dropdown">
  							<a href="dashemp" style="color: black;text-decoration: none;"><button class="dropbtn dropdown-toggle">Employee Management</button></a>
  							<div class="dropdown-content">
    							<a href="add">Add Employee</a>
							    <a href="remove">Remove Employee</a>
							    <a href="profile">Employee Profile</a>
      							<div class="dropdown-divider"></div>
							    <a href="payroll">Payroll System</a>
							    <a href="t&a">Time and Attendance System</a>
							    <a href="leave">Leaving System</a>
  							</div>  
  						</div>
						<div class="dropdown">
   							<a href="dashboard" style="color: black;text-decoration: none;"><button class="dropbtn dropdown-toggle">Client Management</button></a>
  							<div class="dropdown-content">
							    <a href="addClient">Add Client</a>
							    <a href="clientList">Client List</a>
							    <a href="branchList">Branch List</a>
							    <a href="newsLetter">Newsletter</a>
 							</div>
 						</div>
					 	<div class="dropdown">
					<a href="salesdashbord" style="color: black; text-decoration: none;">
						<button class="dropbtn dropdown-toggle">
							Sales Management
						</button></a>
						<div class="dropdown-content">
							    <a href="salesdashbord">Sales Dash Board</a>
							    <a href="viewclientorders">Today Orders</a>
							    <a href="viewclientorders2">Orders For Range</a>
							    <a href="viewsalesdetails">Sales Details</a>
							    <a href="viewinstallationcertificate">Installation Certificates</a>
  							</div>
					</div>
						<div class="dropdown">
   							<a href="orderdashboard" style="color: black;text-decoration: none;"><button class="dropbtn dropdown-toggle">Order Management</button></a>
						  	<div class="dropdown-content">
							    <a href="ClientOrder">ClientOrder</a>
							    <a href="SupplierOrder">SupplierOrder</a>
						       	<a href="ViewClientOrder">View Client Orders</a>
						       	<a href="ViewSupplierOrder">View Supplier Orders</a>
						       	<a href="AddSupplier">Add Supplier</a>
						       	<a href="ViewSupplier">View Suppliers</a>
						       	<div class="dropdown-divider"></div>
						  	</div>
						</div>
						<div class="dropdown">
   							<a href="invdash" style="color: black;text-decoration: none;"><button class="dropbtn dropdown-toggle">Inventory Management</button></a>
							<div class="dropdown-content">
							  <a href="dform">Register Device</a>
							    <a href="iform">Add to Inventory</a>
							    <div class="dropdown-divider"></div>
							    <a href="view">View Inventory</a>
						       	<a href="iview">View Devices</a>
							</div>
						</div>
						<div class="dropdown">
   							<a href="mainPaymentDashboard" style="color: black;text-decoration: none;"><button class="dropbtn dropdown-toggle">Payment Management</button></a>
						  	<div class="dropdown-content">
							    <a href="pettyCashRegister">Petty Cash</a>
						  	</div>
						</div>
						<div class="dropdown">
  				 			<a href="/faultdash" style="color: black;text-decoration: none;"><button class="dropbtn dropdown-toggle">Fault Management</button></a>
  							<div class="dropdown-content">
							    <a href="/form">Add Fault</a>
							    <a href="/pendingurgent">Pending urgent jobs</a>
							    <a href="/finished">Finished Jobs</a>
      							<div class="dropdown-divider"></div>
							    <a href="/detail">Jobs List</a>
							    <a href="/todayj">Today's Jobs</a>
							    <a href="/monreport">Get Monthly Report</a>
  							</div>
  						</div>
						<div class="dropdown">
   							<a href="vhome" style="color: black;text-decoration: none;"><button class="dropbtn dropdown-toggle">Visitor Management</button></a>
  							<div class="dropdown-content">
							    <a href="appform">Add appointment</a>
							    <a href="alog">Remove appointment</a>
					
      							<div class="dropdown-divider"></div>
							    <a href="alog"> Appointment Log</a>
							    <a href="evelog"> Event Log</a>
							
  							</div>
  						</div>
				</div>
			</div>
		</div>
		
		
		<div class="row mx-auto">
			<div class="col-md-12">
			
			
			    <div class="form-group" style="margin-top:3%;margin-left:82%">
			       <div>
			            <a href="/eventLog?clientID=${client.clientID}">Event Log</a>  
			       </div>
			       <div style="margin-top:5%"> 
			            <a href="/addBranch?clientID=${client.clientID}">Add Branch</a>  
			       </div> 
			    </div>
			    
  				<h2 class =" text-center" >${client.companyName}</h2>
  				
  				<form:form method= "POST" modelAttribute="client" class="form-horizontal"  >
  				
  				
  				<div class="form-group row" style="margin-left: 20%;margin-top: 3%">
    				<label class="control-label col-sm-2" for="clientID">Client ID</label>
    					<div class="col-sm-4">
      						<form:input type="number" path="clientID" class="form-control" id="clientID"  name="clientID" readonly="true"/>
      						<div class ="has-error">
      						<form:errors path="clientID" class="help-inline"/>
      						</div>
    					</div>
 	 			</div>
 	 			
 	 			
  				<div class="form-group row"  style="margin-left: 20%;margin-top: 4%">
    				<label class="control-label col-sm-2" for="clientName">Contact Person Name</label>
    					<div class="col-sm-4"> 
      						<form:input type="text" path="clientName" class="form-control" id="clientName" name="clientName" readonly="true"/>
      						<div class="has-error">
      						<form:errors path="clientName" class="help-inline"/>
      						</div>
    					</div>
  				</div>
  				
  				
  				<div class="form-group row" style="margin-left: 20%;margin-top: 4%">
  				
    				<label class="control-label col-sm-2" for="address">Address</label>
    				   <div class="col-sm-4"> 
      						<form:input type="text" path="postalCode" class="form-control" id="postalCode" name="postalCode" placeholder="Postal Code" readonly="true"/>
      						<div class="has-error">
      						<form:errors path="postalCode" class="help-inline"/>
      						</div>
    					</div>
    					
    					<div class="col-sm-4"style="margin-left: 17%; margin-top:4%"> 
      						<form:input type="text" path="street" class="form-control" id="street" name="street" placeholder="Street" readonly="true"/>
      						<div class="has-error">
      						<form:errors path="street" class="help-inline"/>
      						</div>
    					</div>
    					
    					
    					<div class="col-sm-4" style="margin-left: 17%; margin-top:4%"> 
      						<form:input type="text" path="city" class="form-control" id="city" name="city" placeholder="City" readonly="true"/>
      						<div class="has-error">
      						<form:errors path="city" class="help-inline"/>
      						</div>
    					</div>	
 	 			</div>
  				
  				
  				
  				<div class="form-group row" style="margin-left: 20%;margin-top: 4%">
    				<label class="control-label col-sm-2" for="contactNumber">Contact No</label>
    					<div class="col-sm-4">
      						<form:input type="text" path="contactNumber" class="form-control" id="contactNumber" name="contactNumber" readonly="true"/>
      						<div>
      						<form:errors path="contactNumber" class="help-inline"/>
      						</div>
    					</div>
 	 			</div>
 	 			
 	 			 
 	 			
  				<div class="form-group row"  style="margin-left: 20%;margin-top: 4%">
    				<label class="control-label col-sm-2" for="email">Email</label>
    				
    					<div class="col-sm-4"> 
      						<form:input type="email" path="email" class="form-control" id="email" name="email" readonly="true"/>
      						<div>
      						<form:errors path="email" class="help-inline"/>
      						</div>
    					</div>
    					
  				</div>
  				
  				
  				 
    		    
				</form:form>
				
				<div class="row">
      		<div class="col md-5 offset-4 mt-5">
      			<button type="button" class="btn btn-primary" onclick="window.open('profilePdf')">Generate Profile PDF </button>
     		</div>
    	</div>

  		
  	<noscript>Enable JavaScript in your browser</noscript>
  	
  	<c:set var="cid" value="${client.clientCode}" scope="session"/>
			</div>
  		</div>	
		
		
	</div>
  
  <footer class="page-footer" style="background-color:#5c5d60;">
	<div class="footer-copyright text-center py-3">Copyright © 2018  Automated Barcode Solutions (Pvt) Ltd . All rights reserved </a></div>
  </footer>
</body>
</html>
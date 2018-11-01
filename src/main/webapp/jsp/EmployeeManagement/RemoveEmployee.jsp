<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<link rel="stylesheet" href="css/glyphican.css">
    <script src="js/jquery.js"></script>
    <script src="js/proper.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/EmployeeManagement/RemoveEmployee.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.js"></script>
	<title>Remove Employee</title>
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
	
		<form method="GET"  action="removeEmployee" >
		<div class="form-group row my-5">
     					<label for="employeeId" class="col-md-2 col-form-label" style="margin-left:320px ">Select Employee Id</label>
   						<div class="col-md-5">
      						<div class="input-group">
						  		<select class="custom-select form-control" name="employeeCode" id="employeeCode">
							    	<option value=-1>Choose Id</option>
							    	<%
							    		try
							    		{
							    			String query ="select empcode,firstName,lastName from employee";
							    			Class.forName("com.mysql.jdbc.Driver").newInstance();
							    			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
							    			Statement stm = con.createStatement();
							    			ResultSet rs = stm.executeQuery(query);
							    			while(rs.next()){
							    				
							    				%><option value="<%=rs.getString("empcode")%>"><%=rs.getString("empcode") %> <%=rs.getString("firstName") %> <%=rs.getString("lastName") %></option>
							    				<% 	    				
							    			}
							    			
							    		}
							    		catch(Exception ex){
							    			
							    			ex.printStackTrace();
							    			
							    		}
							    								    	
							    	%>
						  		</select>
						  		<button type="submit"  class="col-md-4 btn btn-primary ml-3">Generate Content</button>
						  	</div>
						  	
    					</div>
    					
  					</div>
		
		
	</form>
	
	

	<form:form method="POST" action="empRemove"  modelAttribute="remployee" id="validateRemoveForm">
	
		<div class="form-group row mt-5">
			<label for="employeeCode" class="col-md-3 col-form-label offset-3">Employee ID<span class="glyphicon glyphicon-star"></span></label>
    		<div class="col-md-3">
      		<form:input type="text" class="form-control" path="employeeCode" name="employeeCode" readonly="true" placeholder="System Generated"/>
      		</div>
  		</div>
  			
  		<div class="form-group row">
			<label for="firstName" class="col-md-3 col-form-label offset-3">First Name<span class="glyphicon glyphicon-star"></span></label>
    		<div class="col-md-3">
      			<form:input type="text" class="form-control" name="firstName" path="firstName" readonly="true" id="firstName" placeholder="System Generated"/>
      		</div>
	 	</div>
  	
  		<div class="form-group row">
			<label for="contactNo1" class="col-md-3 col-form-label offset-3">Contact No<span class="glyphicon glyphicon-star"></span></label>
    		<div class="col-md-3">
      			<form:input type="text" class="form-control" path="contactNo1" readonly="true" name="contactNo1" id="contactNo1" placeholder="System Generated"/>
      		</div>
	 	</div>
  	
  	
		<div class="form-group row">
    		<label for="joinedDate" class="col-md-3 col-form-label  offset-3">Registered Date<span class="glyphicon glyphicon-star"></span></label>
   			 <div class="col-md-3">
      				<form:input type="text" class="form-control" readonly="true" path="joinedDate" name="joinedDate" id="joinedDate" placeholder="System Generated"/>
    		</div>
		</div>
		
	 	<div class="form-group row">
   		 	<label for="designation" class="col-md-3 col-form-label  offset-3">Designation<span class="glyphicon glyphicon-star"></span></label>
    		<div class="col-md-3">
      			<form:input type="text" class="form-control" path="designation" readonly="true" name="designation" id="inputLname" placeholder="System Generated"/>
    		</div>
	 	</div>
	 	
	 	<div class="form-group row">
    		<label for="departmentName" class="col-md-3 col-form-label  offset-3">Department<span class="glyphicon glyphicon-star"></span></label>
    		<div class="col-md-3">
      			<form:input type="text" class="form-control" path= "departmentName" readonly="true" name="departmentName" id="departmentName" placeholder="System Generated"/>
    		</div>
	 	</div>
	 
	 	<div class="form-group row">
    		<label for="leaveDate" class="col-md-3 col-form-label  offset-3">Leaving Date<span class="glyphicon glyphicon-star"></span></label>
    		<div class="col-md-3">
      			<form:input type="date"  path="leavingDate" class="form-control"  id="leaveDate" />
    		</div>
	 	</div>
	 
	 	<div class="form-group row">
    		<label for="leaveReason" class="col-md-3 col-form-label  offset-3">Leaving Reason<span class="glyphicon glyphicon-star"></span></label>
    		<div class="col-md-3">
      			<form:input type="text" class="form-control"  path="leaveReason" id="leaveReason"/>
    		</div>
	 	</div>
	 
	 	<div class="form-group row">
	 		<label for="resignation" class="col-md-3 col-form-label  offset-3">Resignation Letter</label>
	  		<div class="col-md-3">
      			<div class="input-group">
  					<div class="custom-file">
    					<form:input type="file" class="custom-file-input" path="resignation"  id="resignation" aria-describedby="inputGroupFileAddon04"/>
    					<label class="custom-file-label" for="inputGroupFile04">Choose file</label>
  					</div>

				</div>
    		</div>
    	</div>
    
    
     	<div class="form-group row">
    		<label for="specialNotes" class="col-md-3 col-form-label  offset-3">Special Notes</label>
    		<div class="col-md-3">
      			<textarea class="form-control" id="specialNotes" name="specialNotes" rows=5></textarea>
    		</div>
	 	</div>

		<div class="row">
      		<div class="col-md-4 offset-2 my-5 text-center">
				<button type="submit" id="remove" class="btn btn-primary">Submit</button>
    		</div>
    			
 			<div class="col-md-4  my-5 text-center">
      			<button type="reset" class="btn btn-primary">Reset</button>
    		</div>
      	</div>
  	
	</form:form>
  
    
  	</div>
  	
  	<footer class="page-footer" style="background-color:#5c5d60;">
		<div class="footer-copyright text-center py-3">Copyright © 2018  Automated Barcode Solutions (Pvt) Ltd . All rights reserved </div>
  	</footer>

</body>
</html>

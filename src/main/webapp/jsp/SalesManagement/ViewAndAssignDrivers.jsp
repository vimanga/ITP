<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
 
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%> 



<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/custom.css">
<script src="js/jquery.js"></script>
<script src="js/proper.js"></script>
<script src="js/bootstrap.js"></script>

<style>
table {
    border-collapse: collapse;
    
}

th {
    background-color: #0171a1;
    color: white;
}


th, td {
    text-align: center;
    padding: 8px;
}



tr:nth-child(odd) {background-color: #9fc1cf;}
tr:hover {background-color:#2bb2cf;}
</style>


<title>View And Assign Drivers</title>
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
<br>


		<br>

		<h1 align="center">Available Drivers</h1>
		<br>
		<form:form>
			<div class="table-responsive">


				<table id="driverTable" border="0px" align="center">
					<tr align="center">
						<th>Driver ID</th>
						<th>Name</th>
						<th>Experienced Level</th>
						<th>Email</th>
						<th>Contact Numbers</th>
						<th>Vehicle Number</th>
					</tr>

					<c:forEach var="clientorder" items="${list}">
						<tr align="center">
							<td>${clientorder.employeeCode}</td>
							<td>${clientorder.firstName} ${clientorder.lastName}</td>
							<td>${clientorder.experiencedLevel}</td>
							<td>${clientorder.email}</td>
							<td>${clientorder.contactNo1}/${clientorder.contactNo2}</td>
							<td>${clientorder.vehicleNo}</td>

						</tr>
					</c:forEach>

				</table>
				

		</form:form>
		
		<br><br>
		
		
		
		<form:form method="POST" class="form-horizontal" style="overflow-x:hidden" modelAttribute="assigndrive" action="/driveassign"  id="assignForm2">


					<div class="form-group row"
						style="margin-left: 25%; margin-top: 2%">
						<label style="width: 200px" for="clienOrdID">Order ID</label>
						<div class="col-sm-4" style="margin-left: 12%">
							<form:input type="text" class="form-control" path="clienOrdID" name="clienOrdID"
								id="clienOrdID"  readonly="true" />
							<div class="has-error">
								<form:errors path="clienOrdID" class="help-inline" />
							</div>
						</div>

					</div>
					
					
					
					
					
					
					
					<div class="form-group row " style="margin-left: 25%; margin-top: 2%">
     					<label style="width: 200px" for="driverID">Driver ID</label>
   						<div class="col-sm-4" style="margin-left: 12%">
      						<div class="input-group">
						  		<select class="custom-select form-control" name="driverID" id="driverID">
							    	<option value=-1>Choose Id</option>
							    	<%
							    		try
							    		{
											String query ="select e.empcode from employee e, other_emps oe where e.designation='Driver' AND oe.availability=1 AND  e.empID=oe.empOTId";
							    			Class.forName("com.mysql.jdbc.Driver").newInstance();
							    			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false","root","root");
							    			Statement stm = con.createStatement();
							    			ResultSet rs = stm.executeQuery(query);
							    			while(rs.next()){
							    				
							    				%><option value="<%=rs.getString("empcode")%>"><%=rs.getString("empcode")%></option>
							    				<% 	    				
							    			}
							    			
							    		}
							    		catch(Exception ex){
							    			
							    			ex.printStackTrace();
							    			
							    		}
							    								    	
							    	%>
						  		</select>
						  		
						  	</div>
						  	
    					</div>
    					
  					</div>
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					<!-- 
					
					
					
					<div class="form-group row"
						style="margin-left: 25%; margin-top: 2%">
						<label style="width: 200px" for="driverID">Driver ID</label>
						<div class="col-sm-4" style="margin-left: 12%">
							<form:input type="text" class="form-control" path="driverID" name="driverID"
								id="driverID"  />
							<div class="has-error">
								<form:errors path="driverID" class="help-inline" />
							</div>
						</div>

					</div>

					 -->

				

					<div class="row" style="margin-left: 42%;width:38%;">
						<div class="col text-center">
							<div class="form-actions ">
								<input type="submit" value="Add Driver"
									class="btn btn-primary btn-sm">
							</div>
						</div>
					</div>
					
					
					
					
					

				</form:form>
		
		
		
		
		
		 

				
			</div>
			
								
				

	</div>


	<footer class="page-footer" style="background-color: #5c5d60;">
		<div class="footer-copyright text-center py-3">
			Copyright © 2018 Automated Barcode Solutions (Pvt) Ltd . All rights
			reserved </a>
		</div>
	</footer>

</body>
</html>
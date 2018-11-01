                                                                                                                                                                                                                           

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/bootstrap.css">

<link rel="stylesheet" href="css/glyphican.css">
<link rel="stylesheet" href="css/custom.css">

<script src="js/jquery.js"></script>
<script src="js/proper.js"></script>
<script src="js/bootstrap.js"></script>
<style>
table {
    border-collapse: collapse;
   align:center;
}

th {
    background-color: #0171a1;
    color: white;
    padding: 8px;
}


th, td {
    text-align: center;
    padding: 8px;
}



tr:nth-child(odd) {background-color: #9fc1cf;}
tr:hover {background-color:#2bb2cf;}
</style>

<title>View Client Order</title>
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
<div class="row"  align="right">
						<div  class="col text-center">
							<div  align="right" style="width:40%;margin-left: 60%;">
								<input 
								type="button" value="Check order for a range"
									class="btn btn-primary btn-sm" onclick="window.location.href='/viewclientorders2'" >
									
							</div>
						</div>
					</div>
					
					<br>
					<div class="row"  align="right">
						<div  class="col text-center">
							<div  align="right" style="width:40%;margin-left: 60%;">
								<input 
								type="button" value="Sales Details"
									class="btn btn-primary btn-sm" onclick="window.location.href='/viewsalesdetails'" >
									
							</div>
						</div>
					</div>
		 

		<br>

		<h1 align="center">Orders For Today</h1>
		<br>
		<form:form>
			<div class="table-responsive">


				<table id="icTable01" align="center" >
					<tr align="center">
						<th>Order ID</th>
						<th>Client ID</th>
						<th>Expected Date</th>
						<th>Location</th>
						<th>Payment Type</th>
						<th>Description</th>
						<th>Delivery Type</th>
						<th>Assign Technician</th>
						<th>Assign Driver</th>
					</tr>

					<c:forEach var="clientorder" items="${list}">
						<tr align="center">
							<td>COI${clientorder.clienOrdID}</td>
							<td>CLI${clientorder.custID}</td>
							<td>${clientorder.expectedDate}</td>
							<td>${clientorder.delLocation}</td>
							<td>${clientorder.paymentType}</td>
							<td>${clientorder.descrip}</td>
							<td>${clientorder.delType}</td>
							
							<!-- ${clientorder.technician_assign_status}
							${clientorder.driver_assign_status} -->

<!--  Assign technician-->
							<td>
							<c:choose>
							<c:when test="${clientorder.technician_assign_status}"><a href="#"><span class="glyphicon glyphicon-ok-sign"></span></a></c:when>
							<c:otherwise><a href="/viewandassigntechnicians/${clientorder.clienOrdID}"><span class="glyphicon glyphicon-user"></span> </a></c:otherwise>
							</c:choose>
							</td>
							
							
							
<!--  Assign Driver-->
							<td>
							<c:choose>
							<c:when test="${clientorder.driver_assign_status}"><a href="#"><span class="glyphicon glyphicon-ok-sign"></span></a></c:when>
							<c:otherwise><a href="/viewandassigndrivers/${clientorder.clienOrdID}"><span class="glyphicon glyphicon-user"></span> </a></c:otherwise>
							</c:choose>
							</td>
							



				<!-- Assign technician 
							<td><a href="/viewandassigntechnicians/${clientorder.clienOrdID}">Technician</a></td>
							-->
							
				<!-- Assign Driver 
							<td><a href="/viewandassigndrivers/${clientorder.clienOrdID}">Driver</a></td>
							-->
							

						</tr>
					</c:forEach>

				</table>
				
</div>


		</form:form>
		
		<br><br>
		
		

				
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
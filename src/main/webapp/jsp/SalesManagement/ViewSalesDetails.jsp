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
    
}

th {
    background-color: #0171a1;
    color: white;
}


th, td {
    text-align: center;
    padding: 4px;
}



tr:nth-child(odd) {background-color: #9fc1cf;}

</style>

<title>View Sales Details</title>
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
		<div class="row"  align="right">
						<div  class="col text-center">
							<div  align="right" style="width:40%;margin-left: 60%;">
								<input 
								type="button" value="Today Orders"
									class="btn btn-primary btn-sm" onclick="window.location.href='/viewclientorders'" >
									
							</div>
						</div>
					</div>
					
				<br>	
					
					<div class="row"  align="right">
						<div  class="col text-center">
							<div  align="right" style="width:40%;margin-left: 60%;">
								<input 
								type="button" value="Installation Certificates"
									class="btn btn-primary btn-sm" onclick="window.location.href='/viewinstallationcertificate'" >
									
							</div>
						</div>
					</div>

		<h1 align="center">Sales Details</h1>
		<br>
		<form:form>
			<div class="table-responsive">



				


				<table id="salesTable01" border="0px" align="center">
					<tr align="center">
						<th>Sales ID</th>
						<th>Order ID</th>
						<th>Technician  ID</th>
						<th>Driver ID</th>
						<th>Status</th>
						<th>Completed Date</th>
						<th>Total Amount</th>
						<th>Generate Amount</th>
						<th>Change Status</th>
						<th>Installation Certificate</th>
						<th>Payment</th>
						<th>Remove</th>
						
					
					</tr>
	
					
					

					<c:forEach var="sales" items="${list}">
						<tr align="center">
							<td>${sales.salesCode}</td>
							<td>${sales.orID}</td>
							<td>${sales.techID}</td>
							<td>${sales.driverID}</td>
							<td>${sales.status}</td>
							<td>${sales.dateCompleted}</td>
							<td>Rs.${sales.totalAmount}</td>
							
						<!-- Generate Amount By ID-->
						<td>
								<div>
									<input style="border-radius: 10px;background-color: #4286f4;color: white;" type="button" value="Generate Amount"  onclick="window.location.href='/generateamount/${sales.salesID}'" >	
								</div>
							
						</td>
						
							<!-- Change the Status  By ID-->
						
						<td>
						 		<div >
									<input style="border-radius: 10px;background-color: #4286f4;color: white;" type="button" value="Completed"  onclick="window.location.href='/updatestatuscom/${sales.salesID}'" >	
								
									<input style="border-radius: 10px;background-color: #4286f4;color: white;" type="button" value="Reset"  onclick="window.location.href='/updatestatuspen/${sales.salesID}'" >	
								</div>
						</td>


							
							<!-- InsatallationCertificate-->
							<td><a href="/installationcertificate/${sales.salesID}"><span class="glyphicon glyphicon-list-alt"></span>  </a></td>
							
							<!-- Proceed to payment-->
							<td>
							<c:choose>
							<c:when test="${sales.payment_status}"><a href="#">Confirmed Payment</a></c:when>
							<c:otherwise><a href="/payment_status_client/${sales.salesID}"><span class="glyphicon glyphicon-usd"></span> </a></c:otherwise>
							</c:choose>
							</td>

							<!-- Remove Sales Details-->
							<td><a href="/deletesalesbyId/${sales.salesID}" onclick="return confirm('Are you sure you want to remove this Sale?');"><span class="glyphicon glyphicon-trash"></span>  </a></td>

							
							
							
							
				
		</tr>
					</c:forEach>

				</table>
				
				
				
				<br>
				<!-- Delete All-->
				<h5 align="right">
					<a href="/deleteall/${sales.salesID}" onclick="return confirm('Are you sure you want to remove all the Sales?');">Delete All Sales Details</a>
				</h5>
				<br>
				
			</div>


		</form:form>
		
		
			<div class="row">
      		<div class="col md-5 offset-4 mt-5">
      			<button type="button" class="btn btn-primary" onclick="window.open('TodayCompletedOrdersPdf')">Generate Today Completed Orders PDF </button>
     		</div>
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
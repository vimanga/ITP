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

<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="css/glyphican.css">
<link rel="stylesheet" href="/css/custom.css">
<script src="js/jquery.js"></script>
<script src="js/proper.js"></script>
<script src="js/bootstrap.js"></script>

<script type="text/javascript">
	function getConfirmation() {
		var retVal = confirm("Do you want to delete ?");
		if (retVal == true) {
			document.write("Deleted Successfully !");
			retun
			true;
		} else {
			document.write("Not Deleted");
			return false;
		}

	}
</script>



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
	padding: 2px;
}

tr:nth-child(odd) {
	background-color: #9fc1cf;
}

tr:hover {
	background-color: #2bb2cf;
}
</style>

<title>View Installation Certificates</title>
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
		<div class="row" align="right">
			<div class="col text-center">
				<div align="right" style="width: 40%; margin-left: 60%;">
					<input type="button" value="Sales Details"
						class="btn btn-primary btn-sm"
						onclick="window.location.href='/viewsalesdetails'">

				</div>
			</div>
		</div>
		<h1 align="center">Installation Certificates</h1>
		<br>
		<form:form>
			<div class="table-responsive">



				




				<table id="icTable01" border="1px">
					<tr align="center">
						<th>IC ID</th>
						<th>Order ID</th>
						<th>Client ID</th>
						<th>Technician ID</th>
						<th>Driver ID</th>
						<th>Cable Length(m)</th>
						<th>Conduit Length(m)</th>
						<th>SW Installed</th>
						<th>SWIn. Description</th>
						<th>Opt. Trainee Provided</th>
						<th>OTProv. Description</th>
						<th>System Fully Opt</th>
						<th>SFOpt. Description</th>
						<th>Time In</th>
						<th>Time Out</th>
						<th style="width: 20%;">Date Installed</th>
						<th>Generate IC</th>
						<th>Edit</th>
						<th>Delete</th>
						<th>Add Items</th>
						<th>View Items</th>


					</tr>

					<c:forEach var="installationcertificate" items="${list}">
						<tr align="center">
							<td>${installationcertificate.installationCode}</td>
							<td>${installationcertificate.ordId}</td>
							<td>CLI${installationcertificate.clienId}</td>
							<td>${installationcertificate.techId}</td>
							<td>${installationcertificate.drivId}</td>
							<td>${installationcertificate.cableLen}</td>
							<td>${installationcertificate.conduitLen}</td>
							<td>${installationcertificate.swInstalled}</td>
							<td>${installationcertificate.swInstalledDescription}</td>
							<td>${installationcertificate.opTraining}</td>
							<td>${installationcertificate.opTrainingDescription}</td>
							<td>${installationcertificate.fullyOperational}</td>
							<td>${installationcertificate.fullyOperationalDescription}</td>
							<td>${installationcertificate.timeIn}</td>
							<td>${installationcertificate.timeOut}</td>
							<td>${installationcertificate.dateInstalled}</td>


							<!-- Generate report -->
							<td><a href="#"><span
									class="glyphicon glyphicon-download-alt"
									onclick="window.open('InstallationCertificatePDF')"></span></a>

								<noscript>Enable JavaScript in your browser</noscript>
								 <c:set
									var="installationCode"
									value="${installationcertificate.installationCode}"
									scope="session" />

							</td>
							<!-- Edit By ID-->
							<td><a
								href="/editinst/${installationcertificate.installationID}"><span
									class="glyphicon glyphicon-edit"></span></a></td>

							<!-- Delete By ID-->
							<td><a
								href="/deleteinstallationcertificate/${installationcertificate.installationID}"
								onclick="return confirm('Are you sure you want to delete this Intllation Certificate?');"><span
									class="glyphicon glyphicon-trash"></span></a></td>


							<!-- Add Items-->
							<td><a
								href="/additems/${installationcertificate.installationID}"><span
									class="glyphicon glyphicon-plus"></span></a></td>

							<!-- View Items -->


							<td><a
								href="/viewadditems/${installationcertificate.installationID}"><span
									class="glyphicon glyphicon-th-list"></span></a></td>



						</tr>
					</c:forEach>

				</table>
				<br>
				<!-- Delete All-->
				<h5 align="right">
					<a href="/deleteinst/${installationcertificate.installationID}"
						onclick="return confirm('Are you sure you want to delete all the Intllation Certificate?');"><span
						class="glyphicon glyphicon-trash"></span> Delete All
						Installation Certificates</a>
				</h5>
			</div>


		</form:form>





	</div>


	<footer class="page-footer" style="background-color: #5c5d60;">
		<div class="footer-copyright text-center py-3">
			Copyright © 2018 Automated Barcode Solutions (Pvt) Ltd . All rights
			reserved </a>
		</div>
	</footer>

</body>
</html>
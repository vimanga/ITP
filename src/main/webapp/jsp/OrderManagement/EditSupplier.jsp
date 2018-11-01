<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  <%@ page isELIgnored="false" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/custom.css">
	<link rel="stylesheet" href="/css/glyphican.css">
	<link rel="stylesheet" href="/css/jquery.datetimepicker.min.css">
    <script src="js/jquery.js"></script>
    <script src="js/proper.js"></script>
	<script src="js/bootstrap.js"></script>
	<script type="text/javascript" src="/js/bootstrapValidator.js"></script>
	<script src="/js/jquery.datetimepicker.full.js"></script>
	 	
	<title>SignIn</title>
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
								<h2 align="center" style="margin-top: 2%">Add Supplier</h2>
			
				<form:form method="POST" modelAttribute="supplier" class="form-horizontal" id="validateForm3" action="editsuppliersubmit">
  				<div class="form-group row" style="margin-left: 30%;margin-top: 12%">
    				<label class="control-label col-sm-2" for="name">Supplier Name</label>
    					<div class="col-sm-4">
      						<input type="text" value="${supplier.name}" name="name" class="form-control" id="name" placeholder="Enter Supplier Name" >
    					</div>
 	 			</div>
  				  				<input type="hidden" name="id" value="${supplier.id}">
  				
  				<div class="form-group row"  style="margin-left: 30%;margin-top: 4%">
    				<label class="control-label col-sm-2" for="pwd">Supplier Location</label>
    					<div class="col-sm-4"> 
      						<input type="text" value="${supplier.location}" name="location" class="form-control" id="location" placeholder="Enter location">
    					</div>
  				</div>
  				<div class="form-group row"  style="margin-left: 30%;margin-top: 4%">
    				<label class="control-label col-sm-2" for="contactNo">Contact number</label>
    					<div class="col-sm-4"> 
      						<input type="text" value="${supplier.contactNo}" name="contactNo" class="form-control" id="contactNo" placeholder="Enter Contact number">
    					</div>
  				</div>
  				<div class="form-group row"  style="margin-left: 30%;margin-top: 4%">
    				<label class="control-label col-sm-2" for="email">Email</label>
    					<div class="col-sm-4"> 
      						<input type="text" value="${supplier.email}" name="email" class="form-control" id="email" placeholder="Enter Email">
    					</div>
  				</div>
  				<div class="form-group row"  style="margin-left: 30%;margin-top: 4%">
    				<label class="control-label col-sm-2" for="pwd">Item</label>
    					<div class="col-sm-4"> 
      						<input type="text" value="${supplier.item}" name="item" class="form-control" id="item" placeholder="Enter Item">
    					</div>
  				</div>
  				
  				<div class="form-group row"  style="margin-left: 30%;margin-top: 4%">
    				<label class="control-label col-sm-2" for="regDate">Date</label>
    					<div class="col-sm-4"> 
      						<input type="date" value="${supplier.regDate}" name="regDate" class="form-control" id="regDate" placeholder="Enter date">
    					</div>
  				</div>
  				
  				
	 			<div class="form-group" style="margin-left: 42%;margin-top: 5%"> 
    				<div class="col-sm-offset-2 col-sm-10">
      					<button type="submit" class="btn btn-primary" id="submit">Submit</button><br><br>
      					<button type="reset" class="btn btn-primary">Reset</button>
    				</div>
    				
 	 			</div>
				</form:form>
			</div>
  		</div>
	</div>
		<script type="text/javascript">
 
   			$(document).ready(function() {
			$('#validateForm3').bootstrapValidator({
				feedbackIcons: {
					valid: 'glyphicon glyphicon-ok',
					invalid: 'glyphicon glyphicon-remove',
					validating: 'glyphicon glyphicon-refresh'
				},
				fields: {
					
					name: {
						validators: {
							notEmpty: {
								message: 'Select payment type'
							}
						}
					},
					
					regDate: {
						validators: {
							notEmpty: {
								message: 'Select date'
							}
						}
					},
					
					contactNo: {
						validators: {
							stringLength: {
								max: 10,
								min: 10,
								message: 'Enter only 10 Numbers'
							},
							
							notEmpty: {
								message: 'Enter Contact number'
							}
							
							
						}
					},
		
					location: {
						validators: {
							notEmpty: {
								message: 'Enter location'
							}
							
						}
					},
					
					item: {
						validators: {
							notEmpty: {
								message: 'Enter item'
							}
						}
					},
					
					email: {
						validators: {
							notEmpty: {
								message: 'Enter email'
							}
						}
					}
					
					
				    },
				    submitHandler: function(form) {
				        var postData = new FormData($(form)),
				            formURL = $(form).attr("action"),
				            method = $(form).attr("method");
				        return false;
					}
				});
			});
   			
		</script>
  <footer class="page-footer" style="background-color:#5c5d60;">
	<div class="footer-copyright text-center py-3">Copyright © 2018  Automated Barcode Solutions (Pvt) Ltd . All rights reserved </a></div>
  </footer>
</body>
<script>

</script>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta http-equiv="Content-Type"  name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/custom.css">
	<link rel="stylesheet" href="css/glyphican.css">
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/EmployeeManagement/EditEmployeeProfile.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.js"></script>
	 	
	<title>Payment Home</title>
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

		<!----------------------------------------------------------------------------------------------------------------------------->

		<noscript>Enable JavaScript in your browser</noscript>
		<script>
			$(function() {
				$('.form').hide();
				$('.f1').show();

				$('#genContent').on("change", function() {
					$('.form').hide();
					$('.f' + $(this).val()).show();
				}).val("1");
			});
		</script>




		<div class="form f1">









			<div class="row mx-auto">
				<div class="col-md-12">

					<div class="col-md-12  my-5 text-center">
						<span style="text-decoration: underline;">Petty Cash
							Register</span>
					</div>
					<form:form modelAttribute="pettyCashRegister"
						class="form-horizontal" action="Savepetty" method="POST"
						id="validateForm1">

						<div class="form-group row"
							style="margin-left: 30%; margin-top: 4%">
							<label class="control-label col-sm-2" for="date">Date</label>
							<div class="col-sm-4">
								<form:input type="date" path="date" class="form-control"
									id="date" placeholder="Enter Date" />
								<div class="has-error">
									<form:errors path="date" class="help-in-line" />
								</div>
							</div>
						</div>


						<div class="form-group row"
							style="margin-left: 30%; margin-top: 4%">
							<label class="control-label col-sm-2" for="amount">Amount</label>
							<div class="col-sm-4">
								<form:input type="number" path="amount" class="form-control"
									id="amount" placeholder="Enter Amount" />
								<div class="has-error">
									<form:errors path="amount" class="help-in-line" />
								</div>
							</div>
						</div>

						<div class="form-group row"
							style="margin-left: 30%; margin-top: 4%">
							<label class="control-label col-sm-2" for="employee">Employee
								Id </label>
							<div class="col-sm-4">
								<form:input type="number" path="employeeId" class="form-control"
									id="employeeId" placeholder="Enter Employee Id" />
								<div class="has-error">
									<form:errors path="employeeId" class="help-in-line" />
								</div>

							</div>
						</div>

						<div class="form-group row"
							style="margin-left: 30%; margin-top: 4%">
							<label class="control-label col-sm-2" for="reason">Reason</label>
							<div class="col-sm-4">
								<form:input type="text" path="reason" class="form-control"
									id="reason" placeholder="Enter Reason" />
								<div class="has-error">
									<form:errors path="reason" class="help-in-line" />
								</div>
							</div>
						</div>

						<div class="form-group row"
							style="margin-left: 30%; margin-top: 4%">
							<label class="control-label col-sm-2" for="return">Return
								Status</label>
							<div class="col-sm-4">
								<form:select path="returnStatus" class="form-control"
									id="returnStatus">
									<option value="Issued">Issued</option>
									<option value="Pending">Pending</option>
									<option value="Completed">Completed</option>

								</form:select>

								<div class="has-error">
									<form:errors path="returnStatus" class="help-in-line" />
								</div>
							</div>
						</div>









						<div class="form-group row">
							<div class="col md-5 offset-3 mt-5 ">
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>


						</div>

					</form:form>


					<script type="text/javascript">
						$(document)
								.ready(
										function() {
											$('#validateForm1')
													.bootstrapValidator(
															{
																feedbackIcons : {
																	valid : 'glyphicon glyphicon-ok',
																	invalid : 'glyphicon glyphicon-remove',
																	validating : 'glyphicon glyphicon-refresh'
																},
																fields : {

																	date : {
																		validators : {

																			notEmpty : {
																				message : 'Select Date'
																			}
																		}
																	},

																	amount : {
																		validators : {

																			notEmpty : {
																				message : 'Enter Amount'
																			}
																		}
																	},

																	employeeId : {
																		validators : {
																			stringLength : {
																				max : 5,
																				min : 5,
																				message : 'Enter only 5 Numbers'
																			},

																			notEmpty : {
																				message : 'employeeId'
																			}
																		}
																	},

																	reason : {
																		validators : {
																			notEmpty : {
																				message : 'Enter Name'
																			}
																		}
																	},

																	returnStatus : {
																		validators : {
																			notEmpty : {
																				message : 'Enter Status'
																			}
																		}
																	}

																}
															});
										});
					</script>




















				</div>
			</div>
		</div>

		<!----------------------------------------------------------------------------------------------------------------------------->



		<!-- -------------------------------------------------------------------------------------------------------------- -->
		<footer class="page-footer" style="background-color: #5c5d60;">
			<div class="footer-copyright text-center py-3">
				Copyright © 2018 Automated Barcode Solutions (Pvt) Ltd . All rights
				reserved </a>
			</div>
		</footer>
</body>
</html>
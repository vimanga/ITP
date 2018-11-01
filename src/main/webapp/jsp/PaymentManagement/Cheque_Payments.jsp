<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/custom.css">
<link rel="stylesheet" href="/css/glyphican.css">
<script src="/js/jquery.js"></script>
<script src="/js/bootstrap.js"></script>
<script src="/js/EmployeeManagement/EditEmployeeProfile.js"></script>
<script type="text/javascript" src="/js/bootstrapValidator.js"></script>

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
		<div class="row mx-auto">
			<div class="col-md-12">

				<div class="col-md-12  my-5 text-center">
					<span style="text-decoration: underline;"><h4>Cheque
							Payments</h4></span>
				</div>

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




					<form:form modelAttribute="clientChequePayments"
						class="form-horizontal" action="/chequePaySave" method="POST"
						id="validateForm1">


						<div class="form-group row"
							style="margin-left: 30%; margin-top: 4%">
							<label class="control-label col-sm-2" for="date">Date</label>
							<div class="col-sm-4">
								<form:input type="date" path="date" class="form-control"
									id="date" placeholder="Enter Date" name="date" />
								<div class="has-error">
									<form:errors path="date" class="help-in-line" />
								</div>
							</div>
						</div>



						<div class="form-group row"
							style="margin-left: 30%; margin-top: 4%">
							<label class="control-label col-sm-2" for="salesId">Sales
								Id</label>
							<div class="col-sm-4">
								<form:input type="locked" path="salesId" class="form-control"
									id="salesId" placeholder="Sales Id" name="salesId" />
								<div class="has-error">
									<form:errors path="salesId" class="help-in-line" />
								</div>
							</div>
						</div>



						<div class="form-group row"
							style="margin-left: 30%; margin-top: 4%">
							<label class="control-label col-sm-2" for="customerName">Customer
								Name</label>
							<div class="col-sm-4">
								<form:input type="text" path="customerName" class="form-control"
									id="customerName" placeholder="Name" name="customerName" />
								<div class="has-error">
									<form:errors path="customerName" class="help-in-line" />
								</div>
							</div>
						</div>



						<div class="form-group row"
							style="margin-left: 30%; margin-top: 4%">
							<label class="control-label col-sm-2" for="chequeNumber">cheque
								Number</label>
							<div class="col-sm-4">
								<form:input type="number" path="chequeNumber"
									class="form-control" id="chequeNumber"
									placeholder="chequeNumber" name="chequeNumber" />
								<div class="has-error">
									<form:errors path="chequeNumber" class="help-in-line" />
								</div>
							</div>
						</div>

						<div class="form-group row"
							style="margin-left: 30%; margin-top: 4%">
							<label class="control-label col-sm-2" for="bankedDate">Banked
								Date</label>
							<div class="col-sm-4">
								<form:input type="date" path="bankedDate" class="form-control"
									id="bankedDate" placeholder="Enter Date" name="bankedDate" />
								<div class="has-error">
									<form:errors path="bankedDate" class="help-in-line" />
								</div>
							</div>
						</div>



						<div class="form-group row"
							style="margin-left: 30%; margin-top: 4%">
							<label class="control-label col-sm-2" for="amount">Amount</label>
							<div class="col-sm-4">
								<form:input type="number" path="amount" class="form-control"
									id="amount" placeholder="amount" name="amount" />
								<div class="has-error">
									<form:errors path="amount" class="help-in-line" />
								</div>
							</div>
						</div>








						<div class="form-group row"
							style="margin-left: 30%; margin-top: 4%">
							<label class="control-label col-sm-2" for="bank">Bank</label>
							<div class="col-sm-4">
								<form:input type="text" path="bank" class="form-control"
									id="bank" placeholder="bank" name="bank" />
								<div class="has-error">
									<form:errors path="bank" class="help-in-line" />
								</div>
							</div>
						</div>








						<div class="form-group row"
							style="margin-left: 30%; margin-top: 4%">
							<label class="control-label col-sm-2" for="status">
								Status</label>
							<div class="col-sm-4">
								<form:select path="status" class="form-control" id="status">
									<option value="Cleared">Cleared</option>
									<option value="Pending">Pending</option>

								</form:select>

								<div class="has-error">
									<form:errors path="status" class="help-in-line" />
								</div>
							</div>
						</div>

						<div class="form-group row">
							<div class="col md-5 offset-3 mt-5 ">
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>

							<div class="col md-5 mt-5 ">
								<button type="reset" class="btn btn-primary">Reset</button>
							</div>
						</div>



					</form:form>
				</div>
			</div>
		</div>









		<script type="text/javascript">
		$(document).ready(function() {
			$('#validateForm1').bootstrapValidator({
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

					

				
					customerName : {
						validators : {
							notEmpty : {
								message : 'Enter Name'
							}
						}
					},

					chequeNumber : {
						validators : {
							notEmpty : {
								message : 'Enter Name'
							}
						}
					},
					
					
					
					bank : {
						validators : {
							notEmpty : {
								message : 'Enter bank'
							}
						}
					}

				}
			});
		});
	</script>







		<!----------------------------------------------------------------------------------------------------------------------------->
		<footer class="page-footer" style="background-color: #5c5d60;">
			<div class="footer-copyright text-center py-3">
				Copyright © 2018 Automated Barcode Solutions (Pvt) Ltd . All rights
				reserved </a>
			</div>
		</footer>
</body>
</html>
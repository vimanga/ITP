<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link rel="stylesheet" href="/css/bootstrap.css">
	<link rel="stylesheet" href="/css/glyphican.css">
	<link rel="stylesheet" href="/css/custom.css">
	<link rel="stylesheet" href="/css/jquery.datetimepicker.min.css">
    <script src="/js/jquery.js"></script>
    <script src="/js/proper.js"></script>
	<script src="/js/bootstrap.js"></script>
	<script type="text/javascript" src="/js/bootstrapValidator.js"></script>
	<script src="/js/jquery.datetimepicker.full.js"></script>
	 	
	<title>Edit Appointment</title>
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
		 <h2 style="text-align: center;">Edit Form</h2>
		
		<div class="row md-auto">
			<div class="col-md-12">
				<form:form  method ="POST" modelAttribute="edvisitor" id="validateEForm" class="form-horizontal" action ="/editapp">
  				
  				<div class="form-group row" style="margin-left: 30%;margin-top: 4%">
    				<label class="control-label col-sm-2" for="appcode">Appointment ID</label>
    					<div class="col-sm-4">
      						<form:input type="text" path="appcode" class="form-control" id="appcode" readonly="true" name ="appcode"/>
      						</div>
    					</div>
    					
 	 		
  				<div class="form-group row"  style="margin-left: 30%;margin-top: 2%">
    				<label class="control-label col-sm-2" for="visitorName">Name of Visitor</label>
    					<div class="col-sm-4"> 
      						<form:input type="text" path="visitorName" class="form-control" id="visitorName" name ="visitorName"/>
      						<div class = "has-error">
      						<font color = "red">
      						<form:errors path="visitorName" class="help-inline"/></font>
      						</div>
    					</div>
  				</div>
  				
 	 			
  				<div class="form-group row" style="margin-left: 30%;margin-top: 2%">
    				<label class="control-label col-sm-2" for="companyName">Name of Company</label>
    					<div class="col-sm-4">
      						<form:input type="text" path="companyName" class="form-control" id="companyName" name="companyName"/>
      						<div class = "has-error">
      						<font color = "red">
      						<form:errors path="companyName" class="help-inline"/></font>
      						</div>
    					</div>
 	 			</div>
 	 			<div class="form-group row"  style="margin-left: 30%;margin-top: 2%">
    				<label class="control-label col-sm-2" for="mail">Email</label>
    					<div class="col-sm-4"> 
      						<form:input type="text" path="mail" class="form-control" id="mail" name ="mail"/>
      						<div class = "has-error">
      						<font color = "red">
      						<form:errors path="mail" class="help-inline"/></font>
      						</div>
    					</div>
    					</div>
    				
    			<div class="form-group row"  style="margin-left: 30%;margin-top: 2%">
    				<label class="control-label col-sm-2" for="contactNumber">Contact Number</label>
    					<div class="col-sm-4"> 
      						<form:input type="text" path="contactNumber" class="form-control" id="contactNumber" name ="contactNumber"/>
      						<div class = "has-error">
      						<font color = "red">
      						<form:errors path="contactNumber" class="help-inline"/></font>
      						</div>
    					</div>
  				</div>
  				<div class="form-group row"  style="margin-left: 30%;margin-top: 2%">
    				<label class="control-label col-sm-2" for="appdate">Date</label>
    					<div class="col-sm-4"> 
      						<form:input type="date" path="appdate" class="form-control" id="appdate" name ="appdate"/>
      						<div class = "has-error">
      						<font color = "red">
      						<form:errors path="appdate" class="help-inline"/></font>
    					</div>
  				</div></div>
  				
  				
  				<div class="form-group row"  style="margin-left: 30%;margin-top: 2%">
    				<label class="control-label col-sm-2" for="assigned_employee">Assigned Employee</label>
    					<div class="col-sm-4"> 
      						<form:input type="text" path="assigned_employee" class="form-control" id="assigned_employee" name ="assigned_employee"/>
      						
    					</div>
  				</div>
  				
  				<div class="form-group row"  style="margin-left: 30%;margin-top: 2%">
    				<label class="control-label col-sm-2" for="comments">Comments</label>
    					<div class="col-sm-4"> 
      						<form:input type="text" path="comments" class="form-control" id="comments" name="comments"/>
      						
    					</div>
  				</div>
  				
  				<div class="form-group row" style="margin-left: 30%;margin-top: 2%">
    				<label class="control-label col-sm-2" for="stat">Status</label>
    					<div class="col-sm-4">
      						<select class="form-control"  id="stat" name ="stat">
      						  <option value="pending">Pending</option>
      						  <option value="conf">Confirmation Sent</option>
                              <option value="visited">Visited</option>
                            
                             
                         </select>
       </div>
 	 			</div>
  				
	 			<div class="form-group" style="margin-left: 42%;margin-top: 2%"> 
    				<div class="col-sm-offset-2 col-sm-10">
    				<div class="form-actions">
      					<button type="submit" value = "submit" class="btn btn-primary">Edit Appointment</button>
    				</div>
    				</div>
 	 			</div>
 	 			
 	
 	 			
 	 			
 	 			</form:form>
 	 			
 	 			
 	 		</div>
 	 		</div>
 	 	<script type = "text/javascript">
  		

  		$(document).ready(function() {
			$('#validateEForm').bootstrapValidator({
				feedbackIcons: {
					valid: 'glyphicon glyphicon-ok',
					invalid: 'glyphicon glyphicon-remove',
					validating: 'glyphicon glyphicon-refresh'
				},
				
				fields: {
					visitorName:{
						validators:{
						notEmpty:{
							message:'Please enter a visitor name'
						},
						stringLength:{
							min: 2
						}
				  
					}
					},
					companyName:{
						validators:{
							notEmpty:{
								message:'Please enter a Company name'
							},
							stringLength:{
								min:2
							}
						}
					},
					appdate:{
						validators:{
						notEmpty:{
							message:'Date field cannot be empty'
						}
					}
					},
					mail:{
						validators:{
							notEmpty:{
								message:'E-mail field cannot be empty'
							},
					        emailAddress: {
			                        message: 'Please supply a valid email address'
			                    }
						}
					},
					contactNumber:{
						validators:{
							notEmpty:{
								message:'Contact number field cannot be empty'
							},
							regexp: {
					              regexp: /^0\d{9}$/,
					              message: 'Please supply a valid phone number in the form 0xxxxxxxxx'
					            }
							
					      
						}
					},
				}
				    
				   
					});
				});
  		
  		
  		</script>
 	 		
 	 		
  		</div>
  
  
  <footer class="page-footer" style="background-color:#5c5d60;">
	<div class="footer-copyright text-center py-3">Copyright © 2018  Automated Barcode Solutions (Pvt) Ltd . All rights reserved </div>
  </footer>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored = "false" %>
<%@page import="java.sql.*"  %>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta http-equiv="Content-Type" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link rel="stylesheet" href="/css/bootstrap.css">
	<link rel="stylesheet" href="/css/custom.css">
	
    <script src="/js/jquery.js"></script>
    <script src="/js/proper.js"></script>
	<script src="/js/bootstrap.js"></script>
	<script type="text/javascript" src="/js/bootstrapValidator.js"></script>
	<script src="/js/jquery.datetimepicker.full.js"></script>
		
	<title>Edit Fault Details</title>
	
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
		<div class="form-container">
		<h1 align="center">Edit Entry</h1>
			<br>
			
			
   
   		<form:form method="POST" modelAttribute="edfault" id="validateEdForm" class="form-horizontal" action="/editsave">

			<div class="form-group row" style="margin-left: 30%;margin-top: 4%">
    				<label class="control-label col-sm-2" for="id">Job ID</label>
    					<div class="col-sm-4">
    					      						FAU${edfault.id} 
    					
      						<form:input type="hidden" path="id" class="form-control" id="id" name="id"/>
      						</div>
    					</div>
		
		<div class="form-group row" style="margin-left: 30%;margin-top: 4%">
    				<label class="control-label col-sm-2" for="nature">Nature</label>
    					<div class="col-sm-4">
      						<form:input type="text" path="nature" class="form-control" id="nature" name="nature"/>
      						<div class = "has-error">
      						<form:errors path="nature" class="help-inline"/>
      						</div>
      						</div>
    					</div>
    					
 	 		
  				<div class="form-group row"  style="margin-left: 30%;margin-top: 2%">
    				<label class="control-label col-sm-2" for="category">Category</label>
    					<div class="col-sm-4"> 
      						<select style="width: 280px; height: 35px;padding: 8px" id="category" path="category" name="category">
      						<option value="${edfault.category}">${edfault.category}</option>
      						<option value="Hardware">Hardware</option>
      						<option value="Software">Software</option>
      						<option value="Firewall">Firewall</option>
      						</select>
      						<div class = "has-error">
      						<form:errors path="category" class="help-inline"/>
      						</div>
    					</div>
  				</div>
  				<div class="form-group row" style="margin-left: 30%;margin-top: 2%">
    				<label class="control-label col-sm-2" for="priority">Priority :</label>
    					<div class="col-sm-4">
      						<select style="width: 280px; height: 35px;padding: 8px" id="priority" path="priority" name="priority">
      						<option value="${edfault.priority}">${edfault.priority}</option>
      						<option value="Urgent">Urgent</option>
      						<option value="Not Urgent">Not Urgent</option>
      						</select>
      						<div class = "has-error">
      						<form:errors path="priority" class="help-inline"/>
      						</div>
    					</div>
 	 			</div>
  				<div class="form-group row" style="margin-left: 30%;margin-top: 2%">
    				<label class="control-label col-sm-2" for="cliID">Client Name :</label>
    					<div class="col-sm-4">
      						<select style="width: 280px; height: 35px;padding: 8px" id="cliID" path="cliID" name="cliID">
      						<option value="${edfault.cliID}">${edfault.cliID}</option>
      						
      						<%
      						
      							try{
      								
      								String sql = "select clientID, name from client";
      								Class.forName("com.mysql.jdbc.Driver").newInstance();
      								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false", "root", "root");
      								Statement stm = con.createStatement();
      								ResultSet rs = stm.executeQuery(sql);
      								
      								while (rs.next()){
      									
      									%>
      									
      									<option value="<%= rs.getInt("clientID")%>"> <%= rs.getString("name") %></option>
      									<%
      								}
      								
      							}
      						
      							catch(Exception e){
      								
      								e.printStackTrace();
      								out.println("Error : " + e.getMessage());
      							}
      						
      						%>
      						
      						</select>
      						<div class = "has-error">
      						<form:errors path="cliID" class="help-inline"/>
      						</div>
    					</div>
 	 			</div>
 	 			<div class="form-group row"  style="margin-left: 30%;margin-top: 2%">
    				<label class="control-label col-sm-2" for="brID">Branch Name :</label>
    					<div class="col-sm-4"> 
    					<select style="width: 280px; height: 35px;padding: 8px" id="brID" path="brID" name="brID">
      						<option value="${edfault.brID}">${edfault.brID}</option>
      						
      						<%
      						
      							try{
      								
      								String sql = "select branchID, Bcity from branch";
      								Class.forName("com.mysql.jdbc.Driver").newInstance();
      								Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/automatedbarcode_database?useSSL=false", "root", "root");
      								Statement stm = con.createStatement();
      								ResultSet rs = stm.executeQuery(sql);
      								
      								while (rs.next()){
      									
      									%>
      									
      									<option value="<%= rs.getInt("branchID")%>"> <%= rs.getString("Bcity") %></option>
      									<%
      								}
      								
      							}
      						
      							catch(Exception e){
      								
      								e.printStackTrace();
      								out.println("Error : " + e.getMessage());
      							}
      						
      						%>
      						
      						</select>
    					
      						<div class = "has-error">
      						<form:errors path="brID" class="help-inline"/>
      						</div>
    					</div>
    					</div>
    				
    			<div class="form-group row"  style="margin-left: 30%;margin-top: 2%">
    				<label class="control-label col-sm-2" for="descrip">Description  :</label>
    					<div class="col-sm-4"> 
      						<form:input type="text" path="descrip" class="form-control" id="descrip" name="descrip"/>
      						<div class = "has-error">
      						<form:errors path="descrip" class="help-inline"/>
      						</div>
    					</div>
  				</div>
  				<div class="form-group row"  style="margin-left: 30%;margin-top: 2%">
    				<label class="control-label col-sm-2" for="reportedBy">Reported By  :</label>
    					<div class="col-sm-4"> 
      						<form:input type="text" path="reportedBy" class="form-control" id="reportedBy" name="reportedBy"/>
      						<div class = "has-error">
      						<form:errors path="reportedBy" class="help-inline"/>
      						</div>
    					</div>
  				</div>
  				<div class="form-group row"  style="margin-left: 30%;margin-top: 2%">
    				<label class="control-label col-sm-2" for="fixedBy">Fixed By  : </label>
    					<div class="col-sm-4"> 
      						<form:input type="date" path="fixedBy" class="form-control" id="fixedBy" name="fixedBy"/>
      						<div class = "has-error">
      						<form:errors path="fixedBy" class="help-inline"/>
    					</div>
  				</div></div>
  				<div class="form-group row"  style="margin-left: 30%;margin-top: 2%">
    				<label class="control-label col-sm-2" for="reportedOn">Reported On  : </label>
    					<div class="col-sm-4"> 
      						<form:input type="date" path="reportedOn" class="form-control" id="reportedOn" name="reportedOn"/>
      						<div class = "has-error">
      						<form:errors path="reportedOn" class="help-inline"/>
    					</div>
  				</div></div>
  				
  				<div class="form-group row" style="margin-left: 30%;margin-top: 2%">
    				<label class="control-label col-sm-2" for="status">Status</label>
    					<div class="col-sm-4">
      						<select style="width: 280px; height: 35px;padding: 8px" id="status" path="status" name="status">
      						<option value="${edfault.status}">${edfault.status}</option>
      						<option value="Pending">Pending</option>
      						<option value="Completed">Completed</option>
      						</select>
      						<div class = "has-error">
      						<form:errors path="status" class="help-inline"/>
    					</div>
       </div>
 	 			</div>
					<br><br><br><br>	
			<div class="form-group" style="margin-left: 42%;margin-top: 2%"> 
    				<div class="col-sm-offset-2 col-sm-10">
    				<div class="form-actions">
      					<button type="submit" value = "edit" class="btn btn-primary">Edit</button>
      					<button type="reset" value="reset" class="btn btn-warning">Reset</button>
    				</div>
    				</div>
 	 			</div>
	
	</form:form>
	
	</div>
</div>

	<script type="text/javascript">
  		
  		$(function(){
  		    var dtToday = new Date();
  		    
  		    var month = dtToday.getMonth() + 1;
  		    var day = dtToday.getDate();
  		    var year = dtToday.getFullYear();
  		    if(month < 10)
  		        month = '0' + month.toString();
  		    if(day < 10)
  		        day = '0' + day.toString();
  		    
  		    var maxDate = year + '-' + month + '-' + day;
  		    //alert(maxDate);
  		    $('#reportedOn').attr('max', maxDate);
  		});
  		
  		$(function(){
  		    var dtToday = new Date();
  		    
  		    var month = dtToday.getMonth() + 1;
  		    var day = dtToday.getDate();
  		    var year = dtToday.getFullYear();
  		    if(month < 10)
  		        month = '0' + month.toString();
  		    if(day < 10)
  		        day = '0' + day.toString();
  		    
  		    var minDate = year + '-' + month + '-' + day;
  		    //alert(maxDate);
  		    $('#fixedBy').attr('min', minDate);
  		});
	 
	   			$(document).ready(function() {
				$('#validateEdForm').bootstrapValidator({
					feedbackIcons: {
						valid: 'glyphicon glyphicon-ok',
						invalid: 'glyphicon glyphicon-remove',
						validating: 'glyphicon glyphicon-refresh'
					},
					fields: {
						
						nature: {
							validators: {
								stringLength: {
									min: 5,
									message: 'Enter nature of fault reported with minimum of 5 letters length'
								},
								
								notEmpty: {
									message: 'Nature field is required'
								}
							}
						},
						
						category: {
							validators: {
								notEmpty: {
									message: 'Category field is required'
								}
							}
						},
			
						priority: {
							validators: {
								notEmpty: {
									message: 'Priority field is required'
								}
							}
						},
						
						cliID: {
							validators: {
								notEmpty: {
									message: 'Client Name field is required'
								}
							}
						},
			
						brID: {
							validators: {
								notEmpty: {
									message: 'Branch Name field is required'
								}
							}
						},
					

						descrip: {
							validators: {
								stringLength: {
									min: 10,
									message: 'Description should be at least 10 letters long'
								},
								notEmpty: {
									message: 'Description field is required'
								}
							}
						},
						
						reportedBy: {
							validators: {
								stringLength: {
									min: 5,
									message: 'Name of the person reporting on behalf of client should be at least 5 letters long'
								},
								
								notEmpty: {
									message: 'Reported By field is required'
								}
							}
						},
						
						fixedBy: {
							validators: {
								notEmpty: {
									message: 'Fixed By field is required'
								}
							}
						},
						
						reportedOn: {
							validators: {
								notEmpty: {
									message: 'Reported on field is required'
								}
							}
						},
						
						status: {
							validators: {
								notEmpty: {
									message: 'Status field is required'
								}
							}
						},
						
						}
					});
				});
	   			
			</script>
			
<footer class="page-footer" style="background-color:#5c5d60;">
	<div class="footer-copyright text-center py-3">Copyright © 2018  Automated Barcode Solutions (Pvt) Ltd . All rights reserved</div>
  </footer>
</body>
</html>
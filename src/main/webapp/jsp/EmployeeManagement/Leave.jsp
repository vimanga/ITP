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
	<link rel="stylesheet" href="css/jquery.datetimepicker.min.css">
    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/EmployeeManagement/Leave.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.js"></script>
	<script src="js/jquery.datetimepicker.full.js"></script>	
	<title>Leave</title>
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
	
	
		<form method="GET"  action="getLeaveEmployee" >
		<div class="form-group row my-5">
     					<label for="employeeCode" class="col-md-2 col-form-label" style="margin-left:320px ">Select Employee Id</label>
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
	
		<form:form method="POST" action="leaveEmployee" id="leaveEmp" modelAttribute="lemployee">
		<div class="form">
		
			<div class="row">
				<div class="col text-center my-4">
					<Span style="text-decoration: underline;"><h4>Employee Information</h4></Span>
				</div>
			</div>
	
	   		<div class="form-group row">
				<label for="employeeCode" class="col-md-3 col-form-label" style="margin-left: 350px">Employee ID<span class="glyphicon glyphicon-star"></span></label>
	    		<div class="col-md-3">
	      			<form:input type="text" class="form-control" id="employeeCode" path="employeeCode" name="employeeCode" placeholder="System Generated" readonly="true"/>
	      		</div>
	   		</div>
		
			<div class="form-group row">
				<label for="firstName" class="col-md-3 col-form-label" style="margin-left: 350px">First Name<span class="glyphicon glyphicon-star"></span></label>
	    		<div class="col-md-3">
	      			<form:input type="text" class="form-control" id="firstName" name="firstName" path="firstName" placeholder="System Generated" readonly="true"/>
	      		</div>
	   		</div>
	   
	   		<div class="form-group row">
				<label for="lastName" class="col-md-3 col-form-label" style="margin-left: 350px">Last Name<span class="glyphicon glyphicon-star"></span></label>
	    		<div class="col-md-3">
	      			<form:input type="text" class="form-control" id="lasttName" name="lastName" path="lastName" placeholder="System Generated" readonly="true"/>
	      		</div>
	   		</div>
	   		
	   		<div class="form-group row">
				<label for="departmentName" class="col-md-3 col-form-label" style="margin-left: 350px">Department Name<span class="glyphicon glyphicon-star"></span></label>
	    		<div class="col-md-3">
	      			<form:input type="text" class="form-control" id="department" name="departmentName"  path="departmentName" placeholder="System Generated" readonly="true"/>
	      		</div>
	   		</div>
	   		
	   		<div class="form-group row">
				<label for="designation" class="col-md-3 col-form-label" style="margin-left: 350px">Designation<span class="glyphicon glyphicon-star"></span></label>
	    		<div class="col-md-3">
	      			<form:input type="text" class="form-control" id="designation" name="designation" path="designation" placeholder="System Generated" readonly="true"/>
	      		</div>
	   		</div>
	   
	  		<div class="row">
				<div class="col text-center my-4">
					<Span style="text-decoration: underline;"><h4>Nature of Leave</h4></Span>
				</div>
			</div>
			
	  		<div class="form-group row my-3">
	  			<div class="col-md-6 offset-4 ">
				  	<div class="input-group">
				  		<div class="row">
				  			<span class="glyphicon glyphicon-star"></span>
				  			
				   			<div class="col-md-2 custom-control custom-radio custom-control-inline">
	  							<input type="radio" id="customRadioInline1" value="Annual" name="leaveType" class="custom-control-input">
	 	 						<label class="custom-control-label" for="customRadioInline1">Annual</label>
							</div>
							
							<div class="col-md-2 custom-control custom-radio custom-control-inline ml-2" >
							  	<input type="radio" id="customRadioInline2" value="Medical" name="leaveType" class="custom-control-input">
							  	<label class="custom-control-label" for="customRadioInline2">Medical</label>
							</div>
							
							<div class="col-md-3 custom-control custom-radio custom-control-inline ml-2"  >
							  	<input type="radio" id="customRadioInline3" name="leaveType" value="Half Day" class="custom-control-input">
							  	<label class="custom-control-label" for="customRadioInline3">Half Day</label>
							</div>
							
							<div class="col-md-2 custom-control custom-radio custom-control-inline ml-2" >
							  	<input type="radio" id="customRadioInline4" name="leaveType" value="Other" class="custom-control-input">
							  	<label class="custom-control-label" for="customRadioInline4">Other</label>
							</div>
						</div>  
	  				</div>
	  			</div>
	  		</div>
	 
	 		<div class="row">
				<div class="col text-center my-4">
					<Span style="text-decoration: underline;"><h4>Leaving Information</h4></Span>
				</div>
			</div>
		
			<div class="form-group row">
				<label for="leaveReason" class="col-md-3 col-form-label" style="margin-left: 350px">Reason</label>
		    	<div class="col-md-3">
		      		<form:input type="text" class="form-control" id="leaveReason" path="leaveReason" name="leaveReason" placeholder="Only Applicable for Halfday & Other"/>
		      	</div>
		   </div>
	   
		   <div class="form-group row">
				<label for="leaveRequestedDate" class="col-md-3 col-form-label" style="margin-left: 350px">Requested Date<span class="glyphicon glyphicon-star"></span></label>
			    <div class="col-md-3">
			      <form:input type="date" class="form-control" id="leaveRequestedDate" path="leaveRequestedDate" name="leaveRequestedDate" placeholder="System Date"/>
			    </div>
		   </div>
		
			<div class="form-group row">
				<label for="leaveStartDate" class="col-md-3 col-form-label" style="margin-left: 350px">From<span class="glyphicon glyphicon-star"></span></label>
			    <div class="col-md-3">
			      <form:input type="datetime-local" class="form-control" path="leaveStartDate" name="leaveStartDate" id="leaveStartDate"/>
			    </div>
		 	</div>
	   
		    <div class="form-group row">
				<label for="leaveEndDate" class="col-md-3 col-form-label" style="margin-left: 350px">To<span class="glyphicon glyphicon-star"></span></label>
				<div class="col-md-3">
		      		<form:input type="datetime-local" class="form-control" path="leaveEndDate" name="leaveEndDate" id="leaveEndDate"/>
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
	    </div>
	  	</form:form>
  </div>
  
  <footer class="page-footer" style="background-color:#5c5d60;">
	<div class="footer-copyright text-center py-3">Copyright © 2018  Automated Barcode Solutions (Pvt) Ltd . All rights reserved </a></div>
  </footer>
  
</body>
</html>

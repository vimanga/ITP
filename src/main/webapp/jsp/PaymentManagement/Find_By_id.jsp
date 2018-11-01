<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
    
    
 
    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




	<form  class="form-horizontal"
					action="findid/${pettyCashId}" method="POST">
					
			<div class="form-group row"
						style="margin-left: 30%; margin-top: 4%">
						<label class="control-label col-sm-2" for="pettyCashId">Did</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"
								id="pettyCashId" placeholder="Id" name="pettyCashId" />
							
						<input type="submit"/>
						</div>
					</div>
					</form>












</body>
</html>
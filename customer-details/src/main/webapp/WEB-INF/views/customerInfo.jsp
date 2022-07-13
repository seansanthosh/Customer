<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List,com.greatlearning.crmCrud.customerRelationshipManagement.model.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>

		 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h1 style="background-color:lightgreen;">CUSTOMER RELATIONSHIP MANAGEMENT</h1>
   <br>
   <br>
   <input type="button" value="Add Customer"
    onclick="window.location.href='/customer-details/Customer/new';"
    class="btn btn-primary" />
    <br/><br/>
		<%
			
		List<Customer> customers=(List<Customer>)request.getAttribute("customerInfo");
		
		
		out.println("<table border=1><tr><th>First Name</th><th>Last Name</th><th>Email</th><th>Delete</th><th>Update</th></tr>");
		for(Customer c:customers){
			
			out.println("<tr><td>"+c.getFirstName()+"</td><td>"+c.getLastName()+"</td><td>"+c.getEmail()+"</td><td><a href='/customer-details/Customer/delete-customer?id="+c.getId()+"'onclick=+ if (!(confirm('Are you sure you want to delete this customer?'))) return false>Delete</a></td>"+"</td><td><a href='/customer-details/Customer/updateForm?id="+c.getId()+"'>Update</a></td></tr>");
		}
		
		out.println("</table>");
		%>
		
		</div>
		<p>
		
    

	</p>	
		
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>customer Details</title>
</head>
<body>
	<div>

		<h1>Enter customer details below</h1>

		<form action="/customer-details/Customer/new-customer" method="post">
		<input type="hidden" name="id" placeholder="CustomerId" /> <br>
			<input type="text" name="firstName" placeholder="First Name" /> <br> <input
				type="text" name="lastName" placeholder="Last Name" /> <br>
			<input type="text" name="email" placeholder="Email" /> <br>
			<br> <input type="submit" name="s" value="Save" />
			<br>

      <a href="/customer-details/Customer/show">Back to List</a>


		</form>
	</div>
</body>
</html>
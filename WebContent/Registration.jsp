<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>

	<h1>Customer Registration Page</h1>
	
	<form action="regCustomer" method="post">
		Name: <input type="text" name="tbName" id="tdName"/>
		<br>
		Email: <input type="email" name="tbEmail" id="tdEmail"/>
		<br>
		Mobile: <input type="tel" name="tbMobile" id="tbMobile"/>
		<br>
		Password: <input type="password" name="tbPassword" id="tbPassword"/>
		<br>
		State: <select name="ddlStates">
				<option value="">---Select---</option>
				<option value="Karnataka">KA</option>
				<option value="Kerala">KL</option>
				<option value="Tamil Nadu">TN</option>
				<option value="ANdhra Pradesh">AP</option>
		
				</select>
		<br>
		<input type="submit" value="Register"/>		
		
	</form>


</body>
</html>
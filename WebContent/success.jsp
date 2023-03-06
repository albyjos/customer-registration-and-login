<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.techpalle.util.SuccessPage" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success page</title>
</head>
<body>
<%
	SuccessPage spJSP = (SuccessPage)request.getAttribute("SuccessDetails");
%>
<header>
	<h1><%=spJSP.h1 %></h1>
</header>

	<p><%= spJSP.p %></p>	

<footer>
	<h1><%=spJSP.h2 %></h1>
</footer>	
	
</body>
</html>
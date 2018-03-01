<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Header.jsp" %>
<form action="perform_login" method="post">
<table align="center" border="1">
	<tr bgcolor="cyan">
		<td colspan="2"><center>Enter Credential</center></td>
	</tr>
	<tr>
		<td>User Name </td>
		<td><input type="text" name="username" /></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name="password" /></td>
	</tr>
	<tr bgcolor="cyan">
		<td colspan="2">
		<center><input type="submit" value="Login"/></center>
		</td>
	</tr>
</table>
</form>
<h3 align="center">Login Page</h3>
</body>
</html>
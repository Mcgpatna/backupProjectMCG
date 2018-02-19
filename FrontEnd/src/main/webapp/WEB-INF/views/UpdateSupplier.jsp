<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3 align="center">Supplier Page</h3>

<body>
<form action="<c:url value="/UpdateSupplier"/>" method="post">
<table align="center">
<tr bgcolor="pink">
<td colspan="2">Update Supplier</td>
</tr>
<tr bgcolor="cyan">
	<td>Supplier ID</td>
	<td><input type="text" readonly id="suppid" name="suppid" value="${supplierInfo.supplierId}"/></td>
</tr>
<tr bgcolor="cyan">
	<td>Supplier Name</td>
	<td><input type="text" id="suppname" name="suppname" value="${supplierInfo.supplierName}"/></td>
</tr>
<tr>
	<td>Supplier Address</td>
	<td><input type="text" id="suppaddress" name="suppaddress" value="${supplierInfo.supplierAddress}"/></td>
</tr>
<tr bgcolor="cyan">
	<td colspan="2"><center>
	<input type="submit" value="Update"/>
	<input type="reset" value="RESET"/>
	</center></td>
</tr>
</table>
</form>

<table align="center">
	<tr>
		<td>Supplier ID</td>
		<td>Supplier Name</td>
		<td>Supplier Address</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${listSupplier}" var="supplier">
	<tr>
		<td>${supplier.supplierId}</td>
		<td>${supplier.supplierName}</td>
		<td>${supplier.supplierAddress}</td>
		<td>
		<a href="<c:url value="/updateSupplier/${supplier.supplierId}"/>">Update</a>/
		<a href="<c:url value="/deleteSupplier/${supplier.supplierId}"/>">Delete</a>
		</td>
	</tr>
	</c:forEach>
	
</table>



</body>
</html>
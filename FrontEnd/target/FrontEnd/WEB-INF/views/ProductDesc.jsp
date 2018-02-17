<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<body>
<h3 align="center">Product Page</h3>

<table >
	<tr bgcolor="pink">
		<td rowspan="6">
		<img src="<c:url value="/resources/images/${ProductInfo.productId}.jpg"/>" width="200" height="200"/>
		</td>
		<td>Product ID</td>
		<td>${ProductInfo.productId}</td>
	</tr>
	<tr bgcolor="pink">
		<td>Price</td>
		<td>${ProductInfo.price}</td>
	</tr>
	<tr bgcolor="pink">
		<td>Product Name</td>
		<td>${ProductInfo.productName}</td>
	</tr>
	<tr bgcolor="pink">
		<td>Category ID</td>
		<td>${categoryName}</td>
	</tr>
	<tr bgcolor="pink">
		<td>Supplier ID</td>
		<td>${ProductInfo.supplierId}</td>
	</tr>
	<tr bgcolor="pink">
		<td>Product Description</td>
		<td>${ProductInfo.prodDesc}</td>
	</tr>
	<tr>
		<td>Quantity</td>
		<td>
		<select name="quantity">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select>
		</td>
	</tr>
</table>

</body>
</html>
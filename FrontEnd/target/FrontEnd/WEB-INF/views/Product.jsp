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
<form:form action="InsertProduct" modelAttribute="product" enctype="multipart/form-data">
<table align="center">
	<tr> <td colspan="2">Product Detail</td></tr>
	<tr> 
	   <td>Product Name</td>
	   <td><form:input path="productName"/></td>
	</tr>
	<tr>
		<td> Category ID</td>
		<td>
			<form:select path="categoryId">
				<form:options value="0" label="---Select----"/>
				<form:options items="${catlist}"/>
			</form:select>
		</td>
	</tr>
	<tr bgcolor="pink">
		<td> Supplier</td>
		<td><form:input path="supplierId"/></td>
	</tr>
	<tr>
		<td>Price</td>
		<td><form:input path="productPrice"/></td>
	</tr>
	<tr bgcolor="pink">
		<td>Stock</td>
		<td><form:input path="quantity"/></td>
	</tr>
	<tr>
		<td>Product Description</td>
		<td><form:input path="productDesc"/></td>
	</tr>
	<tr>
		<td> Product Image </td>
		<td> <form:input type="file" path="pimage" /></td>
	</tr>
	<tr bgcolor="pink">
		<td colspan="2">
		<center><input type="submit" value="SUBMIT"/></center>
	</tr>
	
</table>
</form:form>
</body>
</html>
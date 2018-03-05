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

<h3 align="center">Cart Page</h3>

<table align="center" class="table">
	<tr classr="danger">
		<td colspan="3" >Your Cart</td>	
	</tr>
	<tr>
		<td>Image</td>
		<td>Product ID</td>
		<td>Produt Name</td>
		<td>Quantity </td>
		<td>SubTotal</td>
	</tr>
<c:forEach items="${cartList}" var="cartItem">
    <form action="<c:url value="/updateCartItem/${cartItem.cartId}"/>" method="get">
	<tr class="info">
		<td><img src="<c:url value="/resources/images/${cartItem.productId}.jpg"/>" style="width:50;" height="50"/>
		</td>
		<td>${cartItem.productId}</td>
		<td>${cartItem.productName}</td>
		<td>${cartItem.quantity}</td>
		<td>${cartItem.subtotal}</td>
		<td>
		  <input type="submit" value="Update" class="btn-success"/>
		  <a href="<c:url value="/deleteCartItem" class="btn btn-danger btn-block"/>">Delete</a>
	</tr>
	</form>
</c:forEach>
<tr>
<td colspan="2"> <a href="<c:url value="/UserHome" />" class="btn btn-danger btn-block">Continue Shopping </a></td>
<td colspan="2"> <a href="<c:url value="/ConfirmOrder" />" class="btn btn-danger btn-block">Check Out</a></td>
</tr>

</table>
<jsp:include page="footer.jsp" />

</body>
</html>
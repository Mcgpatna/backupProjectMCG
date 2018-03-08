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

<h3 align="center">Order Confirm Page</h3>

<table align="center" class="table">
	<tr classr="danger">
		<td colspan="3" ><c:out value="${username}'s Order Page"/></td>	
	</tr>
	<tr>
		<td></td>
		<td>Product ID</td>
		<td>Produt Name</td>
		<td>Quantity </td>
		<td>SubTotal</td>
	</tr>
<c:forEach items="${cartList}" var="cartItem">
   
	<tr class="info">
		<td><img src="<c:url value="/resources/images/${cartItem.productId}.jpg"/>" style="width:50;" height="50"/>
		</td>
		<td>${cartItem.productId}</td>
		<td> ${cartItem.productName}</td>
		<td>${cartItem.quantity}</td>
		<td>${cartItem.subtotal}</td>
		
	</tr>
	
</c:forEach>
<tr>
	<td colspan="2">Grand Total</td>
	<td colspan="2">Rs. ${grandTotal}</td>
</tr>
<tr>

</table>
<form action="<c:url value="/PaymentConfirm" />" method="POST">
<table aliugn="center" class="table">
	<tr bgcolor="pink">
		<td colspan="2">Payment Option </td>
	</tr>
	<tr>
		<td> Payment Mode </td>
		<td>
			<input type="radio" name="pmode" value="CC"/>Credit Card
			<input type="radio" name="pmode" value="NB"/>Net Banking
			<input type="radio" name="pmode" value="CV"/>Cash on Delivery
		</td>
		</tr>
		<tr>
		 	<td> Shipment Address </td>
		 	<td><textarea rows="4" cols="4" name="shipAddr"></textarea></td>
		 </tr>
		 <tr>
		 	<td colspan="2"><input type="submit" value="Pay"/></td>		
</table>
</form>
<jsp:include page="footer.jsp" />

</body>
</html>
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

<table align="center">
	<tr bgcolor="pink">
		<td colspan="3">Product Detail</td>	
	</tr>
	<tr>
<c:forEach items="${listProducts}" var="product">
	
		<td>
			<img src="<c:url value="/resources/images/${product.productId}.jpg"/>" style="width:100%;" height="100"/>
			<br/>
			<a href="<c:url value="/productDesc/${product.productId}"/>">${product.productName}</a>
			<br/>INR. ${product.productPrice} /-
		</td>
	
</c:forEach>
	</tr>
</table>
<jsp:include page="footer.jsp" />


</body>
</html>
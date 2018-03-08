<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>

<body>

<%-- <center> 
<a href="login">Login</a>&nbsp;&nbsp;|&nbsp;&nbsp;
<a href="register">Register</a>&nbsp;&nbsp;|&nbsp;&nbsp;
<a href="category">Category</a>&nbsp;&nbsp;|&nbsp;&nbsp;
<a href="product">Product</a>&nbsp;&nbsp;|&nbsp;&nbsp;
<a href="supplier">Supplier</a>&nbsp;&nbsp;|&nbsp;&nbsp;

<a href="productPage">Product Page</a>&nbsp;&nbsp;|&nbsp;&nbsp;
<a href="aboutus">About Us</a>&nbsp;&nbsp;|&nbsp;&nbsp;
<a href="contactus">Contact Us</a>&nbsp;&nbsp;|&nbsp;&nbsp; 
</center> --%>

<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">OnLine Shopping</a>
    </div>
    <c:if test="${!sessionScope.loggedin}">
      	<ul class="nav navbar-nav">
        	<li class="active"><a href="/FrontEnd">Home</a></li>
       		<li><a href="aboutus">About Us</a></li>
     	</ul>
    	<ul class="nav navbar-nav navbar-right">
      		<li><a href="register"><span class="glyphicon glyphicon-user" ></span> Sign Up</a></li>
      		<li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    	</ul>
    </c:if>
    <c:if test="${sessionScope.loggedin}">
       
      <c:if test="${sessionScope.role=='ADMIN'}">
      	<ul class="nav navbar-nav">
      	<li class="active"><a href="/FrontEnd">Home</a></li>
      	<li><a href="supplier">Supplier</a></li>
      	<li><a href="category">Category</a></li>
      	<li><a href="product">Product</a></li>
      	<li><a href="contactus">Contact Us</a></li>
	  	<li><a href="perform_logout">Logout</a>
	  	<li><c:out value="Hello  ${sessionScope.username}"/> </li>
    	</ul>
       </c:if>
       <c:if test="${sessionScope.role=='USER'}">
      	<ul class="nav navbar-nav">
      	<li class="active"><a href="/FrontEnd">Home</a></li>
      	<li><a href="productPage">Product Page</a></li>
		<li><a href="contactus">Contact Us</a></li>
	  	<li><a href="perform_logout">Logout</a>
	  	<li><c:out value="Hello  ${sessionScope.username}"/> </li>
    	</ul>
       </c:if>
    </c:if>
      </div>
</nav>

</center>
</body>
</html>
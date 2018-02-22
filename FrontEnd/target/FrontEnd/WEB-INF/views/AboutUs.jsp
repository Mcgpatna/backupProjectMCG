<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%-- <%@ include file="Header.jsp" %> --%>

<h3 align="center">About Us Page</h3>
<!DOCTYPE html>
<html lang="en">

<body>

<!-- <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">OnLine Shopping</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/FrontEnd">Home</a></li>
      <li><a href="supplier">Supplier</a></li>
      <li><a href="category">Category</a></li>
      <li><a href="product">Product</a></li>
      <li><a href="productPage">Product Page</a></li>
      <li><a href="login">Login</a></li>
	  <li><a href="register">Register</a></li>
	  <li><a href="aboutus">About Us</a></li>
      <li><a href="contactus">Contact Us</a></li>
    </ul>
  </div>
</nav> -->
  
<div class="container">
  <h2>Carousel Example</h2>  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="resources\images\image\m3.jpg" alt="Moto G" style="width:200%;">
      </div>

      <div class="item">
        <img src="resources\images\image\m1.jpg" alt="Moto G" style="width:200%;">
      </div>
    
      <div class="item">
        <img src="resources\images\image\m2.jpg" alt="Moto G" style="width:200%;">
      </div>
      <div class="item">
        <img src="resources\images\image\m4.jpg" alt="Moto G" style="width:200%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>


</body>
</html>

</body>
</html>
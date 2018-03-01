<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<body>
<%@ include file="Header.jsp" %>

<div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title">Please sign up for Registration</h3>
			 			</div>
			 			<div class="panel-body">
			 <c:url var="addAction" value="logins" ></c:url>
			
  			<form:form method="POST" action="InsertCustomer" modelAttribute="customer" > 
			    		<%-- <form role="form"> --%>
			   <table align="center">
			    	
           			<tr>
			    		<td>
            				<%-- <form:label path="customerFName">
               					<spring:message text="First Name"/>
            				</form:label> --%>
            				First Name
        				</td>
        				<td>
            				<form:input path="customerFName" />
        				</td> 
			    	</tr>
			    	<tr>
			    		<td>
            				<form:label path="customerLName">
               					<spring:message text="Last Name"/>
            				</form:label>
        				</td>
        				<td>
            				<form:input path="customerLName" />
        				</td> 
			    	</tr>
			    	<tr>
			    		<td>
            				<form:label path="customerAddress">
               					<spring:message text="Address"/>
            				</form:label>
        				</td>
        				<td>
            				<form:input path="customerAddress" />
        				</td> 
			    	</tr>
			    	<tr>
			    		<td>
            				<form:label path="customerCity">
               					<spring:message text="City"/>
            				</form:label>
        				</td>
        				<td>
            				<form:input path="customerCity" />
        				</td> 
			    	</tr>
			    	<tr>
			    		<td>
            				<form:label path="customerState">
               					<spring:message text="State"/>
            				</form:label>
        				</td>
        				<td>
            				<form:input path="customerState" />
        				</td> 
			    	</tr>
			    	<tr>
			    		<td>
            				<form:label path="customerCountry">
               					<spring:message text="Country"/>
            				</form:label>
        				</td>
        				<td>
            				<form:input path="customerCountry" />
        				</td> 
			    	</tr>
			    	<tr>
			    		<td>
            				<form:label path="customerMobile">
               					<spring:message text="Mobile No"/>
            				</form:label>
        				</td>
        				<td>
            				<form:input path="customerMobile" />
        				</td> 
			    	</tr>
			    	<tr>
			    		<td>
            				<form:label path="customerEmail">
               					<spring:message text="Email Id (Login Id)"/>
            				</form:label>
        				</td>
        				<td>
            				<form:input path="customerEmail" />
        				</td> 
			    	</tr>
			    	<tr>
			    		<td>
            				<form:label path="password">
                				<spring:message text="Password"/>
           					</form:label>
        				</td>
       					 <td>
           					<form:input path="password" />
           					<form:errors path="password" /> <!-- cssClass="error"/> -->
       					 </td>
			    	</tr>
			    	<tr>
			    		<td>
            				<form:label path="conf_pass">
                				<spring:message text="Confirm Password"/>
           					</form:label>
        				</td>
       					 <!-- <td>
           					<form:input path="conf_pass" />
           					
       					 </td> -->
			    	</tr>
			    	
			    	<tr>
			    		<td>
			    			<%-- <form:input path="role" value="ROLE_USER"/> --%>
			    			<form:hidden path="role" value="USER"/>
			    		</td>
			    	</tr>
			    	 <tr>
     
        				<td colspan="2">
       		 			
                			<input type="submit"  value="<spring:message text="Register Your Details"/>" />
            			 </td>
    				</tr>
			    </table>		
		</form:form>
			    	</div>
	    		</div>
    		</div>
    	</div>
    </div>
<center><b>{$msg}</b></b></center> 
<jsp:include page="footer.jsp" />
</body>
</html>
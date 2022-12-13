<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="template.jsp" %>
</head>
<body>

<%@include file="header.jsp" %>

	<div class="container mt-3">
		<c:if test="${param.act eq 'lo'}">
			<p class="text-success text-center">
				Logout Successful
			</p>
		</c:if>
		
		<c:if test="${param.act eq 'reg'}">
			<p class="text-success text-center">
				Sign Up Successful
			</p>
		</c:if>
		
		
	
		<f:form action="login" method="post" modelAttribute="login">
		
			<div class="form-group">
				<f:input path="loginName" placeholder="User Name" class="form-control" />
			</div>
			
			<div class="form-group mt-2">
				<f:password path="password" placeholder="Password" class="form-control" />

			</div>
			
			<div class="container text-center mt-2">
				<button class="btn btn-success">Login</button>
			</div>
			
		</f:form>
	</div>
</body>
</html>
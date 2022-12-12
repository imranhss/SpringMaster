<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="template.jsp"%>
</head>
<body>
<%@include file="menu.jsp"%>
	<div class="container mt-5">
		<form:form action="/register" method="post" modelAttribute="register">
			<div class="form-group">
				<form:input path="user.name" class="form-control"
					placeholder="User Full Name" />
			</div>

			<div class="form-group mt-2">
				<form:input path="user.phone" class="form-control"
					placeholder="Phone Number" />
			</div>
			<div class="form-group mt-2">
				<form:input path="user.email" class="form-control"
					placeholder="Email Address" />
			</div>
			<div class="form-group mt-2">
				<form:textarea path="user.Address" class="form-control"
					placeholder="Postal Address" />
			</div>
			
			<div class="form-group mt-2">
				<form:input path="user.loginName" class="form-control"
					placeholder="user Name" />
			</div>
			<div class="form-group mt-2">
				<form:password path="user.password" class="form-control"
					placeholder="Your Password" />
			</div>

			<div class="container text-center mt-2">
				<button class="btn btn-success">Signup</button>
			</div>
		</form:form>

	</div>
</body>
</html>
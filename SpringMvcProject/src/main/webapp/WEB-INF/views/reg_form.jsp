<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="f"  uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<%@include file="template.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>

<div class="container mt-3">
		<f:form action="/user_reg" method="post" modelAttribute="registration">
		
			<div class="form-group">
				<f:input path="user.name" placeholder="Full Name" class="form-control" />
			</div>
			
			<div class="form-group mt-2">
				<f:input path="user.email" placeholder="Email" class="form-control" />

			</div>
			<div class="form-group mt-2">
				<f:textarea path="user.address" placeholder="Address" class="form-control" />

			</div>
			
			<div class="form-group mt-2">
				<f:input path="user.phone" placeholder="Phone" class="form-control" />

			</div>
			
			<div class="form-group mt-2">
				<f:input path="user.loginName" placeholder="User Name" class="form-control" />

			</div>
			<div class="form-group mt-2">
				<f:password path="user.password" placeholder="Password" class="form-control" />

			</div>
			
			<div class="container text-center mt-2">
				<button class="btn btn-success">Sign Up</button>
			</div>
			
		</f:form>
	</div>

</body>
</html>
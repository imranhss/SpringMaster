<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="template.jsp"%>
</head>
<body>
	<div class="container mt-5">
		<form:form action="/login" method="post" modelAttribute="login">
			<div class="form-group">
				<form:input path="loginName" class="form-control"
					placeholder="User Name" />
			</div>

			<div class="form-group mt-2">
				<form:input path="password" class="form-control"
					placeholder="Enter Password" />
			</div>

			<div class="container text-center mt-2">
				<button class="btn btn-success">Signin</button>
			</div>
		</form:form>

	</div>
</body>
</html>
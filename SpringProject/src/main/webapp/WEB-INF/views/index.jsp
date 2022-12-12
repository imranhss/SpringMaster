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
		<c:if test="${param.act eq 'reg' }">
			<p class="text-success text-center">Registration Successful</p>
		</c:if>
		
			<c:if test="${param.act eq 'lo' }">
			<p class="text-success text-center">Logout Successful</p>
		</c:if>
		
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
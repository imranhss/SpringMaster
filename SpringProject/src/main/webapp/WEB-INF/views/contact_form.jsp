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
	<c:if test="${err!=null}">
		<p class="error text-center"><c:out value="${err}"></c:out></p>
	</c:if>
	
		<form:form action="/user/save_contact" method="post" modelAttribute="contact">
			
			<div class="form-group">
				<form:input path="name" class="form-control"
					placeholder="User Full Name" />
			</div>

			
			<div class="form-group mt-2">
				<form:input path="email" class="form-control"
					placeholder="Email Address" />
			</div>
			<div class="form-group mt-2">
				<form:input path="phone" class="form-control"
					placeholder="Phone" />
			</div>
			
			<div class="form-group mt-2">
				<form:textarea path="remarks" class="form-control"
					placeholder="Remarks" />
			</div>
			
			<div class="container text-center mt-2">
				<button class="btn btn-success">Add Contact</button>
			</div>
		</form:form>

	</div>
</body>
</html>
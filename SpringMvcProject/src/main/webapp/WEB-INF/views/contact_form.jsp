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
		<f:form action="/user/contact_reg" method="post" modelAttribute="contact">

			<div class="form-group">
				<f:input path="name" placeholder="Full Name"
					class="form-control" />
			</div>

			<div class="form-group mt-2">
				<f:input path="email" placeholder="Email" class="form-control" />

			</div>
			<div class="form-group mt-2">
				<f:input path="phone" placeholder="Phone"
					class="form-control" />

			</div>
			
			<div class="form-group mt-2">
				<f:textarea path="remarks" placeholder="Remark"
					class="form-control" />

			</div>


			<div class="container text-center mt-2">
				<button class="btn btn-success">Add Contact</button>
			</div>

		</f:form>
	</div>


</body>
</html>
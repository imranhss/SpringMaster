<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="template.jsp"%>
</head>
<body>
	<%@include file="menu.jsp"%>
	<table class="table table-striped">
		<tr>
			<td>SL</td>
			<td>Name</td>
			<td>Email</td>
			<td>Phone</td>
			<td>Address</td>
			<td>user Name</td>
			<td>Login Status</td>
		</tr>

		<c:if test="${empty userList}">
			<tr>
				<td colspan="7" class="error">No records found</td>
			</tr>
		</c:if>

		<c:forEach items="${userList}" var="c" varStatus="sl">
			<tr>
				<td>${sl.count}</td>
				<td>${c.name}</td>
				<td>${c.email}</td>
				<td>${c.phone}</td>
				<td>${c.address}</td>
				<td>${c.loginName}</td>
				<td>${c.loginStatus}</td>
				
				
			</tr>
		</c:forEach>

	</table>
</body>
</html>
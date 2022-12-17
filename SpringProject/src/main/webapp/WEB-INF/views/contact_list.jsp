<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="template.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<div class="container">
		<c:if test="${param.act eq 'add' }">
			<p class="text-success text-center">New Contact Added</p>
		</c:if>
		<table class="table table-stripe">
			<tr>
				<td>SR</td>
				<td>Name</td>
				<td>Email</td>
				<td>Phoe</td>
				<td>Remarks</td>
				<td>Action</td>
			</tr>

			<c:forEach items="${contactList}" var="c" varStatus="sr">
				<tr>
					<td>${sr.count}</td>
					<td>${c.name}</td>
					<td>${c.email}</td>
					<td>${c.Phone}</td>
					<td>${c.remarks}</td>
					<td>Action</td>
				</tr>
			</c:forEach>


		</table>
	</div>
</body>
</html>
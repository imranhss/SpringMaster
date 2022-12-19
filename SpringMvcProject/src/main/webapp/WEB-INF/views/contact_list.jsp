<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="template.jsp"%>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<h3 class="text-center">Contact List</h3>
		<c:if test="${param.act eq 'add' }">
			<p class="text-success text-center">New Contact Added</p>
		</c:if>

		<c:if test="${param.act eq 'del' }">
			<p class="text-success text-center">Contact Deleted</p>
		</c:if>

		<table class="table table-striped">
			<tr>
				<th>SN</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Remark</th>
				<th>Action</th>
			</tr>
			<c:forEach var="c" items="${contactList}" varStatus="sl">
				<tr>
					<td>${sl.count}</td>
					<td>${c.name}</td>
					<td>${c.email}</td>
					<td>${c.phone}</td>
					<td>${c.remarks}</td>
					<td><a href="/user/update_contact/?contactId=${c.contactId}"
						class="btn btn-warning">Update</a> <a
						href="/user/delete_contact/?contactId=${c.contactId}"
						class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>
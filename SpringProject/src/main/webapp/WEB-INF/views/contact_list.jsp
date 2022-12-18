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
		<c:if test="${param.act eq 'ed' }">
			<p class="text-success text-center">Updated Contact</p>
		</c:if>

		<c:if test="${param.act eq 'del' }">
			<p class="text-success text-center">Contact Deleted</p>
		</c:if>

		<form action="/user/contact_search">
			<input type="text" name="freeText" placeholder="Enter to Search" />
			<button>Search</button>
		</form>
		<form action="/user/bulk_delete" >
				<button style="float-right">Bulk Delete</button>
			<table class="table table-striped">
				<tr>
					<td>Select</td>
					<td>Name</td>
					<td>Email</td>
					<td>Phone</td>
					<td>Remarks</td>
					<td>Action</td>
				</tr>

				<c:if test="${empty contactList}">
					<tr>
						<td colspan="8" class="error">No records found</td>
					</tr>
				</c:if>

				<c:forEach items="${contactList}" var="c" varStatus="sr">
					<tr>
						<td><input type="checkbox" name="contactId" value="${c.contactId}"/></td>
						<td>${c.name}</td>
						<td>${c.email}</td>
						<td>${c.phone}</td>
						<td>${c.remarks}</td>
						<td><a href="/user/edit_contact?contactId=${c.contactId}"
							class="btn btn-danger">Edit</a> <a
							href="/user/contact_delete/?contactId=${c.contactId}"
							class="btn btn-warning">Delete</a></td>
					</tr>
				</c:forEach>

			</table>
		</form>
	</div>
</body>
</html>
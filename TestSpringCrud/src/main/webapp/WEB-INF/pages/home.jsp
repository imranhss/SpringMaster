<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="template.jsp"%>

</head>
<body>
	<div class="container">
		<h3 class="text-center">All Student</h3>
		<table class="table table-striped">
		
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Cell</th>
				<th>Gender</th>
				<th>Subject</th>
				<th>Action</th>
			</tr>
			
			<c:forEach items="${list}" var="s">
			<tr>
				<td>${s.id}</td>
				<td>${s.name}</td>
				<td>${s.email}</td>
				<td>${s.cell}</td>
				<td>${s.gender}</td>
				<td>${s.subject}</td>
				<td>
					<a class="btn btn-danger" href="/delete-student/${s.id}"><i class="fa-sharp fa-solid fa-trash"></i></a>
					<a class="btn btn-danger" href="/edit-student/${s.id}"><i class="fa-sharp fa-solid fa-pen-to-square"></i></a>
					
				</td>
			</tr>
			</c:forEach>
		</table>

	</div>


</body>
</html>
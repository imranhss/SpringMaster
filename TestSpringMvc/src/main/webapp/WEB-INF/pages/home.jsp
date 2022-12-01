<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title><c:out value="${page}"></c:out></title>
</head>
<body>


	<div class="container mt-3">
		<h1 class="text-center">To Do App</h1>
		<c:if test="${not empty msg}">
			<div class="alert alert-success">
			<b><c:out value="${msg}"></c:out></b>
		</div>
		
		</c:if>

		<div class="row mt-4">
			<div class="col-md-2">
				
				<div class="list-group">
					<a href="#" class="list-group-item list-group-item-action active"
						aria-current="true"> Menu </a> 
						<a href='<c:url value="/add"></c:url>'
						class="list-group-item list-group-item-action">Add To Do</a> 
						<a href='<c:url value="/"></c:url>' class="list-group-item list-group-item-action">View To Do</a> 
						
				</div>
			</div>

			<div class="col-md-10 ">		
				
				<c:if test="${page=='home'}">
					<h3 class="text-center">All List</h3>
					
					<c:forEach var="i" items="${todo}">
						<div class="card mt-2">
							<div class="body">
								<h3><c:out value="${i.title}"></c:out></h3>
								<p><c:out value="${i.content}"></c:out></p>
								<p><c:out value="${i.date}"></c:out></p>
								
							</div>
						</div>
					
					</c:forEach>
					
					
					
				</c:if>
				<c:if test="${page=='add'}">
					<h3 class="text-center">Add To Do</h3>
					
					<form:form action="saveTodo" method="post" modelAttribute="todo">
						<div class="form-group">
							<form:input path="title" class="form-control" placeholder="Title"/>
						</div>
						
						<div class="form-group mt-2">
							<form:textarea path="content" class="form-control" placeholder="Enter Your Content" rows="5"/>
						</div>
						
						<div class="container text-center mt-2">
							<button class="btn btn-success">Add ToDo</button>
						</div>
					</form:form>
					
				</c:if>
			</div>

		</div>

	</div>





	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->


	<div class="container mt-2">

		<c:forEach var="l" items="${list}">
			<div class="card" style="width: 18rem;">			
				<div class="card-body">
				  <h5 class="card-title"></h5>
				  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
				  <a href="#" class="btn btn-primary">Go somewhere</a>
				</div>
			  </div>	
						
		</c:forEach>

		
	</div>

</body>
</html>
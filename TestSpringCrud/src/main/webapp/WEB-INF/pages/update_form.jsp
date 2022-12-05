<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="template.jsp"%>
</head>
<body>

	<div class="row">
		<div class="col-md-6 offset-md-3">
			<form action="${pageContext.request.contextPath }/save-student" method="post">

				<input type="hidden" name="id" value="${student.id}">
				
				<div class="mb-3">
					<label class="form-label">Name</label> <input type="text"
						class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" name="name" value="${student.name}">

				</div>

				<div class="mb-3">
					<label class="form-label">Email</label> <input type="email"
						class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" name="email" value="${student.email}">

				</div>

				<div class="mb-3">
					<label class="form-label">Cell</label> <input type="text"
						class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" name="cell" value="${student.cell}">

				</div>

				<div class="mb-3">

					<label class="form-label">Subject</label> <select
						class="form-select" aria-label="Default select example"
						name="subject" value="${student.subject}">
						<option selected>--Select One--</option>
						<option value="JEE">JEE</option>
						<option value="Spring">Spring</option>
						<option value="JSP">JSP</option>
					</select>
				</div>


				<div class="mb-3">
					<label class="form-label">Gender</label>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="gender"
							id="flexRadioDefault1" value="Male"> <label
							class="form-check-label" for="flexRadioDefault1"> Male</label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="gender"
							id="flexRadioDefault1" value="Female"> <label
							class="form-check-label" for="flexRadioDefault1"> Female</label>
					</div>
				</div>

				<button type="submit" class="btn btn-primary">Edit</button>
			</form>
		</div>

	</div>


</body>
</html>
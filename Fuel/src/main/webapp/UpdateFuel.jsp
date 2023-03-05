<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FuelBunk</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>

<nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
   	<img alt="" src="C:\Users\DELL\OneDrive\Desktop\Mp\fuellogo.png" width="150" height="100" class="d-inline-block align-text-top">
    </a>
     <a href="index.jsp">Home</a>
  </div>
</nav>
<h1>Welcome to PetrolBunk Update.....</h1>
	<c:forEach items="${errors}" var="e">
		<span style="color: red;">${e.message}<br></span>
	</c:forEach>
	<div><span style="color:green;">${e.message}</span></div>
	
	<form action="update" method="post">
	
	<div class="mb-3">
	<label for="formFile" class="form-label">Id</label>
	<input type="text" class="form-control" name="id" readonly="readonly" value="${dto.id}"/>
	
	</div>
	<div class="mb-3">
	 <label for="formFile" class="form-label">BrandName</label>
	<input type="text" class="form-control" name="brandName" readonly="readonly" value="${dto.brandName}"/>
	
	</div>	

	 <select class="from-seect" aria-label="Default select example" name="name" required="required" >
				<option selected value="${dto.name}">${dto.name}</option>
				<c:forEach items="${name}" var="n">
					<option value="${n}">${n}</option>
				</c:forEach>
			</select>
	
	 <select class="from-seect" aria-label="Default select example" name="type" required="required" >
				<option selected value="${dto.type}">${dto.type}</option>
				<c:forEach items="${type}" var="t">
					<option value="${t}">${t}</option>
				</c:forEach>
			</select>
	Price :<div class="mb-3">
	 <label for="formFile" class="form-label">Price</label>
	<input type="text" class="form-control" name="price" readonly="readonly" value="${dto.price}"/>
	
	<input type="submit" value="update"/>
	</div>
	
	
	</form>

</body>
</html>
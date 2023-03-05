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
<h1>Welcome to PetrolBunk.....</h1>
	<c:forEach items="${errors}" var="e">
		<span style="color: red;">${e.message}<br></span>
	</c:forEach>
	
	<form action="fuel" method="post">
	<pre>

	Name : <select name="name"required="required"  >
				<option value="">SELECT</option>
				<c:forEach items="${Name}" var="n">
					<option value="${n}">${n}</option>
				</c:forEach>
			</select>
	BrandName : <input type="text" required="required" name ="brandName" value="${dto.brandName}"/>
	Type : <select name="type" required="required">
				<option value="">SELECT</option>
				<c:forEach items="${type}" var="t">
					<option value="${t}">${t}</option>
				</c:forEach>
			</select>
	Price : <input type="text" required="required" name="price" value="${dto.price}"/>
	<input type="submit" value="Fill"/>
	
	</pre>
	</form>

</body>
</html>
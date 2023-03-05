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
    <a href="fuel">Select</a>
     <a href="Search.jsp">Search</a>
      <a href=SearchbyBrandname.jsp>SearchByBrand</a>
     
  </div>
</nav>
<h3>
<span style="color:green">${message}</span>
</h3>
<h3>
<span style="color:red">${error}</span>
</h3>
<form action="delete" method="get">
Search By BrandName : <input type="text" name="brandName"/>
		<input type="submit" value="Search"/>
	</form>
	<div>
	<table class="table table-bordered">
	<tr>
	<th scope="col">ID</th>
	<th scope="col">BrandName</th>
	<th scope="col">Type</th>
	<th scope="col">Price</th>
	<th scope="col">edit</th>
	</tr>
	<c:forEach items="${dto}" var="d">
	<tr>
	<td>${t.id}</td>
	<td>${t.brandName}</td>
	<td>${t.type}</td>
	<td>${t.price}</td>
	<td><a href="update?id=${t.id}">edit</a></td>
	</tr>
	</c:forEach>
	</table>
	
</div>

</body>
</html>
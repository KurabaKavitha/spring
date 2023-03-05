<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
     <a href="index.jsp">Home</a>
  </div>
</nav>
<h1>Searching .....</h1>
<form action="Search" method="get">
Search By Id : <input type="text" name="id" required="required"/>
		<input type="submit" value="Search"/>
	
	<h3>
		<span style="">The Searched results are: </span><br>
		<span style="color:blue;">Id:</span>${dto.id}<br>
		<span style="color: blue;">Name: </span>${dto.name} <br>
		<span style="color: blue;">BrandName: </span>${dto.brandName} <br>
				
		<span style="color: blue;">Price: </span>${dto.price}
	</h3>

</form>

</body>
</html>
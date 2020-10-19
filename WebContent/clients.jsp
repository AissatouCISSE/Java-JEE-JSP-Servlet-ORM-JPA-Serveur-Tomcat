<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap-4.3.1-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<p></p>
<div class="container">
	<div class="card">
	<div class="card-header">Rechercher un Client</div>
	<div class="card-bidy">
		<form action="chercher.aissatou" method="get">
		<label>Entrer un nom:</label>
		<input type="text" name="motCle" value="${model.motCle}"/>
		<button type="submit" class="btn btn-primary">Chercher</button>
		</form>
		<table class="table table-striped">
		<tr>
		<th>ID</th>
		<th>Nom</th>
		<th>Adresse</th>
		<th>Telephone</th>
		
		</tr>
		<c:forEach items="${clients}" var="c">
		<tr>
			<td>${c.id_client}</td>
			<td>${c.nom_client}</td>
			<td>${c.adresse_client}</td>
			<td>${c.telephone_client}</td>
		</tr>
		</c:forEach>
		
		
		</table>
	
	</div>
	</div>
</div>

</body>
</html>
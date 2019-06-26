<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Continenti</title>
<link href="stile.css" rel="stylesheet" type="text/css">
</head>
<body>


	<div align="center">

		<h1>
			<b style="font-size: 70px; color: red;">CONTINENTI TERRESTRI</b>
		</h1>

		<c:forEach items="${result}" var="continente">
			<a href="nationjdbc?continent=${continente}"><b
				style="font-size: 60px; color: blue;">${continente}</b></a>
			<br>
		</c:forEach>

	</div>


</body>
</html>
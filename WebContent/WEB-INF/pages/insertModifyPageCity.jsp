<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${titlePage} CITTA</title>
<link href="stile.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div align="center">
		<h1>
			<b style="font-size: 70px; color: red;">${titlePage} CITTA</b>
		</h1>
		<form method="GET" action="${formAction}">
			<input type="hidden" value="${param.idCity}" name="idCity"> 
			Nome Città:<input type="text" name="city" value="${param.city}"><br><br> 
			Codice Nazione:
			<select>
				<option value="${param.nation}"> ${nameNation}</option>
				<c:forEach items="${result}" var="citta">
					<option value="${citta.code}"> ${citta.name} </option>
				</c:forEach>
			</select>
			<br><br> 
			<input type="submit" name="submit" value="${titlePage}">
		</form>
		
		<br> <br> <br> <br>
		<a href="cityJdbc?nation=${param.nation}">
			<img alt="back page button" src="backButton.png" width="100px">
		</a>
	</div>
</body>
</html>
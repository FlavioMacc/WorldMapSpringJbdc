<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nazioni</title>
<link href="stile.css" rel="stylesheet" type="text/css">
</head>
<body>


	<div align="center">

		<h1>
			<b style="font-size: 60px; color: red;">NAZIONI DEL CONTINENTE -${continent}-</b>
		</h1>
		<table style="width: 100%">
			<c:forEach items="${result}" var="nazione">

				<tr>
					<td style="width: 50%"><a
						href="cityJdbc?nation=${nazione.code}"><b
							style="font-size: 60px; color: blue;">${nazione.name}</b></a></td>
					<td style="width: 50%">
					</td>
				</tr>

			</c:forEach>
		</table>
		<br> <a href="continent"><img alt="back page button"
			src="backButton.png" width="100px"></a>
	</div>




</body>
</html>
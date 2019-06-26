<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<spring:url value="/go/stile.css" var="stileCSS" />
<link href="${stileCSS}" rel="stylesheet" />
<title>Città della Nazione</title>
<link href="stile.css" rel="stylesheet" type="text/css">

<style type="text/css">
#Abutton {
	-webkit-appearance: button;
	-moz-appearance: button;
	appearance: button;
	text-decoration: none;
	color: initial;
	width: 100px;
	text-align: center;
}
</style>

</head>
<body>


	<div align="center">

		<h1>
			<b style="font-size: 60px; color: red;">CITTA' DELLA NAZIONE
				-${param.nation}-</b>
		</h1>
		<table style="width: 100%">
			<tr>
				<td><b style="font-size: 40px; color: green;">NOME CITTA <a
						href="cityJdbc?nation=${param.nation}&order=${order}"
						id="Abutton">${order}</a>
				</b></td>
			</tr>

			<c:forEach items="${result}" var="citta">

				<tr>
					<td style="width: 50%"><a href=""><b
							style="font-size: 60px; color: blue;">${citta.name}</b></a><br></td>
					<td style="width: 25%"><a
						href="deleteCity?nation=${param.nation}&idCity=${citta.idCity}"
						id="Abutton"> DELETE </a></td>
					<td style="width: 25%"><a
						href="updateCityPage?nation=${param.nation}&idCity=${citta.idCity}&city=${citta.name}"
						id="Abutton"> MODIFY </a></td>
				</tr>


			</c:forEach>
		</table>
		<br> <br> <a
			href="insertCityPage?nation=${param.nation}&idCity="
			id="Abutton"> ADD CITY </a> <br> <br> <br> <b> <a
			href="nationjdbc"><img
				alt="back page button" src="backButton.png" width="100px"></a>
		</b>

	</div>


</body>
</html>
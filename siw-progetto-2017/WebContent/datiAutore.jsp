<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Autore</title>
</head>
<body>
	<f:view>
		<jsp:include page="header.jsp" />
		<div align="center">
			<h1>Dettagli Autore ${authorController.author.nome} ${authorController.author.cognome}</h1>
			<div>Nazionalita: ${authorController.author.nazionalita}</div>
			<div>Data Nascita: ${authorController.author.dataNascita}</div>
			<div>Data Morte: ${authorController.author.dataMorte}</div>
			
			Clicca <a href="/faces/listaQuadri.jsp"> QUI </a> per vedere i quadri di questo autore
		</div>
	</f:view>
</body>
</html>
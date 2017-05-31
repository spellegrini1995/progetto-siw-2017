<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Utente: "${userController.nome} ${userController.cognome}"</title>
</head>
<body>
	<f:view>
		<jsp:include page="header.jsp" />

		<div align="center">
			<h1>${userController.nome} ${userController.cognome}</h1>
			<h3>Informazioni:</h3>
			<div>Email: ${userController.email}</div>
			<div>Data Nascita: ${userController.dataNascita}</div>
			<div>Data Registrazione: ${userController.nome}</div>
			<div>Indirizzo: ${userController.address.toString}</div>
		</div>
	</f:view>
		<div>
			Clicca <a href='<c:url value="/faces/index.jsp" />'>QUI</a>	per tornare alla pagina iniziale
		</div>
</body>
</html>
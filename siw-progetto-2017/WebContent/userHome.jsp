<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title> Home Page Utente</title>
</head>
<body>
	<f:view>
		<jsp:include page="/faces/header.jsp" />
		<div align="center">
			<h1> Benvenuto <strong>${userController.currentUser.nome} ${userController.currentUser.cognome}</strong></h1>
			<h2>Informazioni</h2>
			<address>
				${userController.currentUser.address.via}
				${userController.currentUser.address.codicePostale}
				${userController.currentUser.address.comune},
				(${userController.currentUser.address.provincia})<br>
				${userController.currentUser.address.nazione}<br> 
				<abbr title="Telefono">Tel:</abbr>	${userController.currentUser.numeroTelefono}
			</address>
			<div>
				Data di Nascita:
				<h:outputText
					value="#{userController.currentUser.dataNascita}">
					<f:convertDateTime dateStyle="medium" locale="it_IT" type="date" />
				</h:outputText>
			</div>
			<div>
				Data di Registrazione:
				<h:outputText value="#{userController.currentUser.dataRegistrazione.time}">
					<f:convertDateTime dateStyle="medium" locale="it_IT" type="both" timeZone="Europe/Rome" />
				</h:outputText>
			</div>
			<h3><strong><em>Scegli un'operazione sulla barra superiore per iniziare!</em></strong></h3>
		</div>
	</f:view>
</body>
</html>
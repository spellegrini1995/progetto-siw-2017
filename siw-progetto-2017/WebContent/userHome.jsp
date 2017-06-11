<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page Utente</title>
</head>
<body
	background="http://www.sfondifree.it/sfondihd/wp-content/uploads/2015/11/Sfondo-mano-e-auto-fantasy.jpg">
	<f:view>
		<jsp:include page="header.jsp" />
		<div align="center" class="text-primary">
			<h1>
				Benvenuto <strong>${userController.currentUser.nome}
					${userController.currentUser.cognome}</strong>
			</h1>
			<h2>Informazioni</h2>
			<address>
				<strong>${userController.currentUser.address.via}
					${userController.currentUser.address.codicePostale}
					${userController.currentUser.address.comune},
					(${userController.currentUser.address.provincia})<br>
					${userController.currentUser.address.nazione}<br>
				</strong> <abbr title="Telefono"><strong>Tel:</strong></abbr><strong>
					${userController.currentUser.numeroTelefono}</strong>
			</address>
			<div class="text-primary">
				<strong>Data di Nascita: <h:outputText
						value="#{userController.currentUser.dataNascita}">
						<f:convertDateTime dateStyle="medium" locale="it_IT" type="date" />
					</h:outputText></strong>
			</div>
			<div class="text-primary">
				<strong>Data di Registrazione: <h:outputText
						value="#{userController.currentUser.dataRegistrazione.time}">
						<f:convertDateTime dateStyle="medium" locale="it_IT" type="both"
							timeZone="Europe/Rome" />
					</h:outputText></strong>
			</div>
			<h3>
				<strong><em>Scegli un'operazione sulla barra superiore
						per iniziare!</em></strong>
			</h3>
		</div>
	</f:view>
</body>
</html>
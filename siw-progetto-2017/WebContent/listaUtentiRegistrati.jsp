<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Utenti registrati</title>
</head>
<body>
	<f:view>
		<!-- Men� di testa -->
		<jsp:include page="header.jsp" />
		<!-- -------------- -->
		<div align="center">
			<h1>Utenti registrati</h1>

			<h:form>
				<table class="table">
					<tr>
						<th>E-mail</th>
						<th>Nome</th>
						<th>Cognome</th>
						<th>Telefono</th>
						<th>Data Registrazione</th>
					</tr>
					<c:forEach var="u" items="#{userController.users}">
						<tr>
							<td>${u.email}</td>
							<td>${u.nome}</td>
							<td>${u.cognome}</td>
							<td>${u.numeroTelefono}</td>
							<td><h:outputText value="#{u.dataRegistrazione.time}">
									<f:convertDateTime dateStyle="medium" locale="it_IT" type="both" timeZone="Europe/Rome" />
								</h:outputText>
							</td>
						</tr>
					</c:forEach>
				</table>
			</h:form>
		</div>
	</f:view>
</body>
</html>
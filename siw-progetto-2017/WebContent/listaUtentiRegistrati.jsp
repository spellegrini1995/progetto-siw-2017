<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Utenti registrati</title>
</head>
<body
	background="http://www.fixabay.com/reimg/resize-img.php?src=http://www.fixabay.com/images/Nature/235tuqgit2h.jpg&h=768&w=1366">
	<f:view>
		<!-- Menù di testa -->
		<jsp:include page="header.jsp" />
		<!-- -------------- -->
		<div align="center" class="text-primary">
			<h1>
				<strong>Utenti registrati</strong>
			</h1>

			<h:form>
				<table class="table text-primary">
					<tr>
						<th><strong>E-mail</strong></th>
						<th><strong>Nome</strong></th>
						<th><strong>Cognome</strong></th>
						<th><strong>Telefono</strong></th>
						<th><strong>Data Registrazione</strong></th>
					</tr>
					<c:forEach var="u" items="#{userController.users}">
						<tr>
							<td><strong><a href='<c:url value="/faces/datiUtente.jsp" />'><em>${u.email}</em></a></strong></td>
							<td><strong>${u.nome}</strong></td>
							<td><strong>${u.cognome}</strong></td>
							<td><strong>${u.numeroTelefono}</strong></td>
							<td><strong><h:outputText
										value="#{u.dataRegistrazione.time}">
										<f:convertDateTime dateStyle="medium" locale="it_IT"
											type="both" timeZone="Europe/Rome" />
									</h:outputText></strong></td>
						</tr>
					</c:forEach>
				</table>
			</h:form>
		</div>
	</f:view>
</body>
</html>
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
	background="http://www.boorp.com/sfondi_gratis_desktop_pc/sfondi_gratis/sfondi_arte_quadri/arte_orientale.jpg">
	<f:view>
		<!-- Menù di testa -->
		<jsp:include page="header.jsp" />
		<!-- -------------- -->
		<div align="center" class="text-primary">
			<h1>
				<strong>Lista Autori</strong>
			</h1>

			<h:form>
				<table class="table text-primary">
					<tr>
						<th><strong>Nome</strong></th>
						<th><strong>Cognome</strong></th>
						<th><strong>Nazionalita</strong></th>
						<th><strong>Data Nascita</strong></th>
						<th><strong>Data Morte</strong></th>
					</tr>
					<c:forEach var="a" items="#{authorController.autori}">
						<tr>
							<td><strong><a href='<c:url value="/faces/datiAutore.jsp" />'><em>${a.nome}</em></a></strong></td>
							<td><strong>${a.cognome}</strong></td>
							<td><strong>${a.nazionalita}</strong></td>
							<td><strong>${a.dataNascita}</strong></td>
							<td><strong>${a.dataMorte}</strong></td>
						</tr>
					</c:forEach>
				</table>
			</h:form>
		</div>
	</f:view>
</body>
</html>
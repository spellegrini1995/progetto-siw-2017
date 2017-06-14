<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:o="http://omnifaces.org/ui">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Lista Quadri</title>
</head>
<body>
	<f:view>
		<jsp:include page="header.jsp" />
		<div align="center">
			<h1>Lista Quadri</h1>
			<h:form>
				<table class="table">
					<tr>
					<th>Titolo</th>
					<th>Tecnica</th>
					<th>Dimensioni</th>
					<th>Autore</th>
					<th>Azione</th>
					</tr>
					<c:forEach var="quadro" items="#{paintingController.paintings}">
					<tr>
						<td><h:commandLink action="#{paintingController.findPainting}" value="#{quadro.titolo}">
								<f:param name="id" value="#{quadro.id}" />
							</h:commandLink></td>
						<td>${quadro.tecnica}</td>
						<td>${quadro.dimensioni}</td>
						<td>${quadro.autore}</td>
						<td><h:commandLink	action="#{paintingController.deletePainting}" value="Delete">
								<f:param name="id" value="#{quadro.id}" />
							</h:commandLink> - <h:commandLink action="#{paintingController.updatePainting}"	value="Update">
								<f:param name="id" value="#{quadro.id}" />
							</h:commandLink></td>
					</tr>
				</c:forEach>
				</table>
			</h:form>
		</div>
	</f:view>
</body>
</html>
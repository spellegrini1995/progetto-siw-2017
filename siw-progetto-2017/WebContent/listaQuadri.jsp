<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Products</title>
</head>
<body>
	<f:view>
		<h1>Quadri</h1>
		<h:form>
			<table>
				<tr>
					<th>Titolo</th>
					<th>Tecnica</th>
					<th>Dimensioni</th>
					<th>Autore</th>
					<th>Azione</th>
				</tr>
				<c:forEach var="quadro" items="#{paintingController.paintings}">
					<tr>
						<td><h:commandLink action="#{paintingController.findPaintng}" value="#{quadro.titolo}">
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

	</f:view>
	<div>
		<a href='<c:url value="/faces/administratorHome.jsp" />'>Home</a>
	</div>
</body>
</html>
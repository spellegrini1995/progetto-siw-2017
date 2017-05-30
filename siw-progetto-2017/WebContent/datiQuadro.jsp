<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Painting</title>
</head>
<body>
	<f:view>
		<h1>${paintingController.painting.titolo}</h1>
		<h2>Informazioni sul quadro</h2>
		<div>Anno di realizzazione: ${paintingController.painting.annoRealizzazione}</div>
		<div>Tecnica utilizzata: ${paintingController.painting.tecnica}</div>
		<div>Dimensioni: ${paintingController.painting.dimensioni}</div>
	
	<div>
		<li> Clicca <a href='<c:url value="/faces/index.jsp" />'>QUI</a> per tornare alla pagina iniziale</li> 
	</div>
	<h:form>
		<li> Clicca al seguente link per vedere la lista di tutti i quadri
			<h:commandLink action="#{productController.viewPaintings}" value="Lista Quadri" /></li>
	</h:form>
</f:view>
</body>
</html>
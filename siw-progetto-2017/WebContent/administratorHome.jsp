<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title> Admin Home</title>
</head>
<body>
	<f:view>
		<h1>Benvenuto ${administratorController.nome} ${administratorController.cognome} </h1>
		<ul>
		<li> Clicca <a href="<c:url value="/faces/inserimentoQuadro.jsp" />"> QUI </a> per inserire un nuovo quadro</li>
			<li><h:form>
					<h:commandLink action="#{paintingController.listPaintings}" value="Lista Quadri" />
				</h:form></li>
			<li><a href='<c:url value="/faces/index.jsp" />'>logout</a></li>
		</ul>
	</f:view>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Pagina Iniziale</title>
</head>
<body>
	<f:view>
		<h1>Benvenuto!</h1>
		<ul>
				<li><a href='<c:url value="/faces/newUser.jsp" />'>Registrazione Utente</a></li>
				<li><a href='<c:url value="/faces/userLogin.jsp" />'>Login User</a></li>
				<li><a href='<c:url value="/faces/administratorLogin.jsp" />'>Login Administrator</a></li>
				<h:form>
				<c:if test="${fn:length(paintingController.paintings) gt 1}">
				<li><h:commandLink action="#{paintingController.viewPaintings}" value="Lista dei Quadri" /></li>
				</c:if>
				</h:form>
		</ul>
	</f:view>
</body>
</html>
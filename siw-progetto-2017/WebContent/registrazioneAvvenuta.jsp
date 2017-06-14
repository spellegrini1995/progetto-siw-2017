<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrazione effettuata</title>
</head>
<body background="https://images5.alphacoders.com/487/thumb-1920-487176.jpg">
	<f:view>
		<!-- Menù di testa -->
		<jsp:include page="header.jsp" />
		<!-- -------------- -->
		<div align="center">
			<h:form>
				<span class="error alert alert-success">Registrazione
					avvenuta con successo! Reindirizzamento alla tua pagina
					in corso...
				</span>
				<c:choose>
					<c:when
						test="${administratorController.currentAdministrator != null}">
						<meta http-equiv="refresh" content="4; url=faces/administratorHome.jsp"/>
					</c:when>
					<c:otherwise>
						<meta http-equiv="refresh" content="4; url=faces/userHome.jsp"/>
					</c:otherwise>
				</c:choose>
			</h:form>
		</div>
	</f:view>
</body>
</html>
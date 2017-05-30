<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>User Home</title>
</head>
<body>
	<f:view>
		<h1>Benvenuto ${userController.user.nome} ${userController.user.cognome}</h1>
		<ul><h:form>
			<li>
					<h:commandLink action="#{paintingController.listPaintings}"
						value="Lista dei Quadri" />
				</li>
				<li>
					<h:commandLink action="#{userController.logout}" value="logout" />
				</li>
				</h:form>
		</ul>
	</f:view>
</body>
</html>
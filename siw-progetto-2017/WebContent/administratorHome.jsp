<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page Admin</title>
</head>
<body background="http://wallpapercave.com/wp/xMYBAks.jpg">
	<f:view>
		<jsp:include page="header.jsp" />
		<div align="center" class="text-primary">
			<c:if test="${administratorController.message != null && administratorController.message != ''}">
				<span class="error alert alert-success">${administratorController.message}</span>
				<br>
			</c:if>
		<h1><strong>Pagina di Amministrazione </strong></h1>
		<h2><strong>Benvenuto ${administratorController.currentAdministrator.firstName} ${administratorController.currentAdministrator.lastName} </strong></h2>
		<h3><strong><em>Scegli un'operazione sulla barra superiore per iniziare!</em></strong></h3>
		</div>
	</f:view>
</body>
</html>
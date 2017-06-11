<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Utente</title>
</head>

<body
	background="http://www.drogbaster.it/sfondi-spazio/orizzonte-pianeta.jpg">
	<f:view>
		<!-- Menu' di testa -->
		<jsp:include page="header.jsp" />
		<!-- -------------- -->
		<div align="center" class="text-primary">
			<h:form id="loginUser" styleClass="form-horizontal">
				<h:message for="accedi" styleClass="error alert alert-danger" />
				<div>
					<h2>
						<strong>Login utente</strong>
					</h2>
				</div>
				<div class="form-group text-primary">
					<label for="email" class="col-sm-1 control-label col-lg-offset-4"><strong>Email</strong></label>
					<div class="col-sm-2">
						<h:inputText value="#{userController.email}" required="true"
							requiredMessage="L'email e' obbligatoria!" id="email"
							styleClass="form-control" />
						<h:message for="email" style="color:red" />
					</div>
				</div>
				<div class="form-group text-primary">
					<label for="password"
						class="col-sm-1 control-label col-lg-offset-4"><strong>Password</strong></label>
					<div class="col-sm-2">
						<h:inputSecret value="#{userController.password}" required="true"
							requiredMessage="La password e' obbligatoria!" id="password"
							styleClass="form-control" />
						<h:message for="password" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-5 col-sm-2">
						<h:commandButton styleClass="btn btn-primary" id="accedi"
							value="Accedi" action="#{userController.loginUser}" />
					</div>
				</div>
				<div class="text-primary">
					<h4>oppure</h4>
				</div>
				<div class="text-success">
					<a href='<c:url value="/faces/registrazioneUtente.jsp" />'><strong><em>Registrati</em></strong></a>
				</div>
			</h:form>
		</div>
	</f:view>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login amministratore</title>
</head>

<body background="http://www.hrhwalls.com/reimg/image.php?src=http://img.hrhwalls.com/images178/f5b1v3jcusq.jpg&h=768&w=1366">
	<f:view>
		<!-- Menu' di testa -->
		<jsp:include page="header.jsp" />
		<!-- -------------- -->
		<div align="center">
			<h:form id="loginAdministrator" styleClass="form-horizontal">
				<h:message for="accediAdmin" styleClass="error alert alert-danger" />
				<div class = "text-primary text-shadow">
					<h1><strong>Sezione Amministratore</strong></h1>
				</div>
				<div class = "text-primary">
					<h2><strong>Login Amministratore</strong></h2>
				</div>
				<div class="form-group text-primary" >
					<label for="nickname"
						class="col-sm-1 control-label col-lg-offset-4"><strong>Nickname</strong></label>
					<div class="col-sm-2">
						<h:inputText value="#{administratorController.nickname}"
							required="true" requiredMessage="Il nickname e' obbligatorio!"
							id="nickname" styleClass="form-control" />
						<h:message for="nickname" style="color:red" />
					</div>
				</div>
				<div class="form-group text-primary">
					<label for="password" class="col-sm-1 control-label col-lg-offset-4"><strong>Password</strong></label>
					<div class="col-sm-2">
						<h:inputSecret value="#{administratorController.password}"
							required="true" requiredMessage="La password e' obbligatoria!"
							id="password" styleClass="form-control" />
						<h:message for="password" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-5 col-sm-2">
						<h:commandButton styleClass="btn btn-primary" id="accediAdmin"
							value="Accedi"
							action="#{administratorController.loginAdministrator}" />
					</div>
				</div>
			</h:form>
		</div>
		<div class="text-right text-primary col-md-6 col-md-offset-6">
			<h4><em><strong>Per accedere e provare la sezione amministrazione:</strong></em></h4>
			<h4><em><strong>Nickname: admin1</strong></em></h4>
			<h4><em><strong>Password: admin1</strong></em></h4>
		</div>
	</f:view>

</body>

<!-- include javascript, jQuery FIRST -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

</html>
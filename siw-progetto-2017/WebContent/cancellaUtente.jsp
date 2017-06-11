<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Cancella Utente</title>
</head>
<body background="http://www.allforwall.net/reimg/resize-img.php?src=http://downimgs.allforwall.net/images/sbqix5dtkus.jpg&h=768&w=1366">
	<f:view>
		<jsp:include page="header.jsp" />
		<div align="center" class="text-primary">
			<h:form id="deletingUser" styleClass="form-horizontal">
				<h:message for="deleteUser" styleClass="error alert alert-danger" />
				<div>
					<h2><strong>Elimina Utente</strong></h2>
					<h5><strong>Inserisci l'e-mail</strong></h5>
				</div>
				<div class="form-group text-primary">
					<label for="email" class="col-sm-1 control-label col-lg-offset-4"><strong>Email</strong></label>
					<div class="col-sm-2">
						<h:inputText value="#{administratorController.email}"
							required="true"
							requiredMessage="L'email è obbligatoria per eseguire l'operazione!"
							id="email" styleClass="form-control" />
						<h:message for="email" />
					</div>
				</div>
				<div></div>
				<div class="form-group">
					<div class="col-sm-offset-5 col-sm-2">
						<h:commandButton styleClass="btn btn-primary" id="deleteUser"
							value="Elimina Utente"
							action="#{administratorController.deleteUser}" />
					</div>
				</div>
			</h:form>
		</div>
	</f:view>
</body>
</html>
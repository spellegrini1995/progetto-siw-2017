<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Nuovo cliente</title>
</head>
<body>
	<f:view>
		<!-- Menu' di testa -->
		<jsp:include page="header.jsp" />
		<!-- -------------- -->
		<div align="center">
			<h:form id="registrationUser" styleClass="form-horizontal">
				<h:message for="signinUser" styleClass="error alert alert-danger" />
				<div>
					<h1>Registrazione utente</h1>
				</div>
				<div class="form-group">
					<label for="nome"
						class="col-sm-1 control-label col-lg-offset-3">Nome</label>
					<div class="col-sm-2">
						<h:inputText value="#{userController.nome}"
							required="true" requiredMessage="Campo Obbligatorio" id="nome"
							styleClass="form-control" />
						<h:message for="nome" style="color:red" />
					</div>
					<label for="cognome" class="col-sm-1 control-label">Cognome</label>
					<div class="col-sm-2">
						<h:inputText value="#{userController.cognome}"
							required="true" requiredMessage="Campo Obbligatorio" id="cognome"
							styleClass="form-control" />
						<h:message for="cognome" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<label for="email" class="col-sm-1 control-label col-lg-offset-3">E-mail</label>
					<div class="col-sm-2">
						<h:inputText value="#{userController.email}" required="true"
							requiredMessage="Campo Obbligatorio" id="email" styleClass="form-control" />
						<h:message for="email" style="color:red" />
					</div>
					<label for="password" class="col-sm-1 control-label">Password</label>
					<div class="col-sm-2">
						<h:inputSecret value="#{userController.password}"
							required="true" requiredMessage="Campo Obbligatorio" id="password"
							styleClass="form-control" />
						<h:message for="password" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<label for="data_nascita"
						class="col-sm-1 control-label col-lg-offset-3">Data di
						Nascita</label>
					<div class="col-sm-2">
						<t:inputDate value="#{userController.dataNascita}"
							required="true" requiredMessage="Campo Obbligatorio" id="data_nascita"
							styleClass="form-control" />
						<h:message for="data_nascita" style="color:red" />
					</div>
					<label for="numero_telefono" class="col-sm-1 control-label">Telefono</label>
					<div class="col-sm-2">
						<h:inputText value="#{userController.numeroTelefono}"
							required="true" requiredMessage="Campo Obbligatorio" id="numero_telefono"
							styleClass="form-control" />
						<h:message for="numero_telefono" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<label for="via" class="col-sm-1 control-label col-lg-offset-3">Via/Piazza</label>
					<div class="col-sm-2">
						<h:inputText value="#{userController.via}" required="true"
							requiredMessage="Campo Obbligatorio" id="via" styleClass="form-control" />
						<h:message for="via" style="color:red" />
					</div>
					<label for="codice_postale" class="col-sm-1 control-label">CAP</label>
					<div class="col-sm-2">
						<h:inputText value="#{userController.codicePostale}" required="true"
							requiredMessage="Campo Obbligatorio" id="codice_postale"
							styleClass="form-control" />
						<h:message for="codice_postale" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<label for="comune"
						class="col-sm-1 control-label col-lg-offset-3">Citta'</label>
					<div class="col-sm-2">
						<h:inputText value="#{userController.comune}" required="true"
							requiredMessage="Campo Obbligatorio" id="comune" styleClass="form-control" />
						<h:message for="comune" style="color:red" />
					</div>
					<label for="provincia" class="col-sm-1 control-label">Provincia</label>
					<div class="col-sm-2">
						<h:inputText value="#{userController.provincia}" required="true"
							requiredMessage="Campo Obbligatorio" id="provincia"
							styleClass="form-control" />
						<h:message for="provincia" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<label for="nazione"
						class="col-sm-1 control-label col-lg-offset-3">Nazione</label>
					<div class="col-sm-2">
						<h:inputText value="#{userController.nazione}" required="true"
							requiredMessage="Campo Obbligatorio" id="nazione" styleClass="form-control" />
						<h:message for="nazione" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-5 col-sm-3">
						<h:commandButton styleClass="btn btn-primary" id="signinUser"
							value="Registrati" action="#{userController.createUser}" />
					</div>
				</div>
			</h:form>
		</div>
	</f:view>
</body>
</html>
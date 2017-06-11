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
<title>Nuovo Utente</title>
</head>
<body background = "http://wallpapercave.com/wp/BipRqmd.jpg">
	<f:view>
		<!-- Menu' di testa -->
		<jsp:include page="header.jsp" />
		<!-- -------------- -->
		<div align="center">
			<h:form id="registrationUserByAdmin" styleClass="form-horizontal">
				<h:message for="signinUserByAdmin" styleClass="error alert alert-danger" />
				<div>
					<h1><strong>Registrazione utente</strong></h1>
				</div>
				<div class="form-group">
					<label for="nome"
						class="col-sm-1 control-label col-lg-offset-3"><strong>Nome</strong></label>
					<div class="col-sm-2">
						<h:inputText value="#{administratorController.firstName}"
							required="true" requiredMessage="Campo Obbligatorio" id="nome"
							styleClass="form-control" />
						<h:message for="nome" style="color:red" />
					</div>
					<label for="cognome" class="col-sm-1 control-label"><strong>Cognome</strong></label>
					<div class="col-sm-2">
						<h:inputText value="#{administratorController.lastName}"
							required="true" requiredMessage="Campo Obbligatorio" id="cognome"
							styleClass="form-control" />
						<h:message for="cognome" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<label for="email" class="col-sm-1 control-label col-lg-offset-3"><strong>E-mail</strong></label>
					<div class="col-sm-2">
						<h:inputText value="#{administratorController.email}" required="true"
							requiredMessage="Campo Obbligatorio" id="email" styleClass="form-control" />
						<h:message for="email" style="color:red" />
					</div>
					<label for="password" class="col-sm-1 control-label"><strong>Password</strong></label>
					<div class="col-sm-2">
						<h:inputSecret value="#{administratorController.passwordUser}"
							required="true" requiredMessage="Campo Obbligatorio" id="password"
							styleClass="form-control" />
						<h:message for="password" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<label for="dataNascita"
						class="col-sm-1 control-label col-lg-offset-3"><strong>Data di Nascita</strong></label>
					<div class="col-sm-2">
						<t:inputDate value="#{administratorController.dateOfBirth}"
							required="true" requiredMessage="Campo Obbligatorio" id="dateOfBirth"
							styleClass="form-control" />
						<h:message for="dateOfBirth" style="color:red" />
					</div>
					<label for="phoneNumber" class="col-sm-1 control-label"><strong>Telefono</strong></label>
					<div class="col-sm-2">
						<h:inputText value="#{administratorController.phoneNumber}"
							required="true" requiredMessage="Campo Obbligatorio" id="phoneNumber"
							styleClass="form-control" />
						<h:message for="phoneNumber" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<label for="street" class="col-sm-1 control-label col-lg-offset-3"><strong>Via/Piazza</strong></label>
					<div class="col-sm-2">
						<h:inputText value="#{administratorController.street}" required="true"
							requiredMessage="Campo Obbligatorio" id="address_street" styleClass="form-control" />
						<h:message for="address_street" style="color:red" />
					</div>
					<label for="zipcode" class="col-sm-1 control-label"><strong>CAP</strong></label>
					<div class="col-sm-2">
						<h:inputText value="#{administratorController.zipcode}" required="true"
							requiredMessage="Campo Obbligatorio" id="address_zipcode"
							styleClass="form-control" />
						<h:message for="address_zipcode" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<label for="address_city"
						class="col-sm-1 control-label col-lg-offset-3"><strong>Citta'</strong></label>
					<div class="col-sm-2">
						<h:inputText value="#{administratorController.city}" required="true"
							requiredMessage="Campo Obbligatorio" id="address_city" styleClass="form-control" />
						<h:message for="address_city" style="color:red" />
					</div>
					<label for="address_country" class="col-sm-1 control-label"><strong>Provincia</strong></label>
					<div class="col-sm-2">
						<h:inputText value="#{administratorController.country}" required="true"
							requiredMessage="Campo Obbligatorio" id="address_country"
							styleClass="form-control" />
						<h:message for="address_country" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<label for="address_state"
						class="col-sm-1 control-label col-lg-offset-3"><strong>Nazione</strong></label>
					<div class="col-sm-2">
						<h:inputText value="#{administratorController.state}" required="true"
							requiredMessage="Campo Obbligatorio" id="address_state" styleClass="form-control" />
						<h:message for="address_state" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-5 col-sm-3">
						<h:commandButton styleClass="btn btn-primary" id="signinUserByAdmin"
							value="Registra Utente" action="#{administratorController.createUser}" />
					</div>
				</div>
			</h:form>
		</div>
	</f:view>
</body>
</html>
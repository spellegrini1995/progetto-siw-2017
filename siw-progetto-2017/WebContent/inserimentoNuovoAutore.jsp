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
<title>Nuovo Autore</title>
</head>
<body background="http://www.salvatorezeno.com/wp-content/uploads/2015/10/Uomo-Salvatore-Zeno.jpg">
	<f:view>
		<!-- Menu' di testa -->
		<jsp:include page="header.jsp" />
		<!-- -------------- -->
		<div align="center" class="text-primary">
			<h:form id="newAuthor" styleClass="form-horizontal">
				<h:message for="createAuthor" styleClass="error alert alert-danger" />
				<div>
					<h1><strong>Inserimento nuovo Autore</strong></h1>
				</div>
				<div class="form-group text-primary">
					<label for="nome" class="col-sm-1 control-label col-lg-offset-3"><strong>Nome</strong></label>
					<div class="col-sm-2">
						<h:inputText id="nome" value="#{authorController.nome}"
							requiredMessage="Campo Obbligatorio" required="true" styleClass="form-control"/>
						<h:message for="nome" style="color:red" />
					</div>
					<label for="cognome" class="col-sm-1 control-label"><strong>Cognome</strong></label>
					<div class="col-sm-2">
						<h:inputText value="#{authorController.cognome}" required="true"
							requiredMessage="Campo Obbligatorio" id="cognome"
							styleClass="form-control" />
						<h:message for="cognome" style="color:red" />
					</div>
				</div>
				<div class="form-group text-primary">
					<label for="nazionalita"
						class="col-sm-1 control-label col-lg-offset-3"><strong>Paese di Nascita</strong></label>
					<div class="col-sm-2">
						<h:inputText value="#{authorController.nazionalita}"
							required="true" requiredMessage="Campo Obbligatorio"
							id="nazionalita" styleClass="form-control" />
						<h:message for="nazionalita" style="color:red" />
					</div>
					<label for="data_nascita" class="col-sm-1 control-label"><strong>Data di Nascita</strong></label>
					<div class="col-sm-2">
						<t:inputDate value="#{authorController.dataNascita}"
							id="data_nascita" styleClass="form-control" />
					</div>
				</div>
				<div class="form-group text-primary">
					<label for="data_morte"
						class="col-sm-1 control-label col-lg-offset-3"><strong>Data di Morte</strong></label>
					<div class="col-sm-2">
						<t:inputDate value="#{authorController.dataMorte}" id="data_morte"
							styleClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-5 col-sm-3">
						<h:commandButton styleClass="btn btn-primary" id="createAuthor"
							value="Inserisci" action="#{authorController.createAuthor}" />
					</div>
				</div>
			</h:form>
		</div>
	</f:view>
</body>
</html>
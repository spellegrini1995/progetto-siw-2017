<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Nuovo Quadro</title>
</head>
<body>
	<f:view>
		<jsp:include page="header.jsp" />

		<div align="center">
			
			<h:form id="newPainting" styleClass="form-horizontal">
				<h:message for="createPainting" styleClass="error alert alert-danger" />
				<div>
					<h1>Inserimento nuovo Quadro</h1>
				</div>
				<div class="form-group">
					<label for="titolo" class="col-sm-1 control-label col-lg-offset-4">Titolo</label>
					<div class="col-sm-2">
						<h:inputText styleClass="form-control"
							value="#{paintingController.titolo}" required="true"
							requiredMessage="Il titolo e' obbligatorio!" id="titolo" />
						<h:message for="titolo" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<label for="anno" class="col-sm-1 control-label col-lg-offset-4">Anno Realizzazione</label>
					<div class="col-sm-2">
						<h:inputText styleClass="form-control"
							value="#{paintingController.annoRealizzazione}" required="false"
							converterMessage="L'anno deve essere un numero" id="anno" />
						<h:message for="anno" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<label for="tecnica" class="col-sm-1 control-label col-lg-offset-4">Tecnica Utilizzata</label>
					<div class="col-sm-2">
						<h:inputText styleClass="form-control"
							value="#{paintingController.tecnica}" required="true"
							requiredMessage="La tecnica utilizzata e' obbligatoria!"
							id="tecnica" />
						<h:message for="tecnica" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<label for="dimensioni"
						class="col-sm-1 control-label col-lg-offset-4"> Dimensione </label>
					<div class="col-sm-2">
						<h:inputText styleClass="form-control"
							value="#{paintingController.dimensioni}" required="true"
							requiredMessage="La dimensione e' obbligatoria!"
							id="dimensioni" />
						<h:message for="dimensioni" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<label for="addAuthorList"
						class="col-sm-1 control-label col-lg-offset-4">Autore</label>
					<div class="col-sm-2">
						<h:selectOneMenu styleClass="form-control" id="addAuthorList"
							value="#{paintingController.nomeAutore}">
							<c:forEach var="author" items="#{administratorController.authors}">
								<f:selectItem itemValue="#{author.nome}" itemLabel="#{author.nome}" />
							</c:forEach>
						</h:selectOneMenu>
						<h:message for="authorName" style="color:red" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-5 col-sm-2">
						<h:commandButton id="createPainting" styleClass="btn btn-success" value="Inserisci"
							action="#{paintingController.createPainting}" />
					</div>
				</div>
				<c:if test="${fn:length(paintingController.paintings) gt 1}">
					<h:commandLink action="#{paintingController.paintings}" value="Lista dei Quadri" />
				</c:if>
			</h:form>
		</div>
	</f:view>
</body>
</html>
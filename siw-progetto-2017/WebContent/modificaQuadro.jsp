<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Modifica quadro</title>
</head>
<body>
	<f:view>
		<jsp:include page="header.jsp" />

		<div align="center">
				<h:form styleClass="form-horizontal">
				<h:message for="createPainting" styleClass="error alert alert-danger" />
				<div>
					<h1>Modifica Quadro</h1>
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
					<div class="col-sm-offset-5 col-sm-2">
						<h:commandButton value="Salva Modifiche"
							styleClass="btn btn-primary"
							action="#{productController.updateProduct}" />
					</div>
				</div>
			</h:form>

			<c:if test="${not empty currentPainting.autore}">
				<hr>
				<div class="form-group">
					<h:form id="removePaintingMenu">
						<div class="form-group">
							<label for="painting"
								class="col-sm-1 control-label col-lg-offset-4">Autore: </label>
							<div class="col-sm-2">
								<h:commandButton styleClass="btn btn-warning"
									id="removeAuthor" value="Rimuovi autore e salva"
									action="#{paintingController.nullAuthor}" />
							</div>
						</div>
					</h:form>
				</div>
			</c:if>
			<br> <br>
			<hr>
			<c:if test="${not empty authorsPainting}">
				<div class="form-group">
					<h:form id="addAuthorMenu">
						<div class="form-group">
							<label for="addAuthorList"
								class="col-sm-1 control-label col-lg-offset-4">Aggiungi Autore</label>
							<div class="col-sm-2">
								<h:selectOneMenu styleClass="form-control" id="addAuthorList" value="#{paintingController.nomeAutore}">
									<c:forEach var="autore" items="#{authorsPainting}">
										<f:selectItem itemValue="#{autore.id}" itemLabel="#{autore.nome}" />
									</c:forEach>
								</h:selectOneMenu>
							</div>
							<div class="col-sm-2">
								<h:commandButton styleClass="btn btn-success"
									id="removeAuthor" value="Aggiungi autore e salva"
									action="#{paintingController.setAuthor}" />
							</div>
						</div>
					</h:form>
				</div>
			</c:if>
		</div>
	</f:view>
</body>
</html>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
 

<!DOCTYPE html>
<html xmlns:o="http://omnifaces.org/ui">
<head>
<title>Quadro: "${paintingController.painting.titolo}"</title>
</head>
<body>
	<f:view>
		<jsp:include page="header.jsp" />

		<div align="center">
			<h2>${paintingController.painting.titolo}</h2>
			<h3>Dettagli</h3>
			<div>Anno Realizzazione: ${paintingController.painting.annoRealizzazione}</div>
			<div>Tecnica: ${paintingController.painting.tecnica}</div>
			<div>Dimensioni: ${paintingController.painting.dimensioni}</div>
			<div> <a href="/faces/datiAutore.jsp"> ${paintingController.painting.autore.nome} ${paintingController.painting.autore.cognome}</a></div>
            <div>Immagine:<o:graphicImage value="#{imgLoad.get(quadroController.quadroCorrente.id)}"/></div>
            
			<!-- Sono un amministratore -->
			<c:if test="${administratorController.currentAdministrator != null}">
				<h:form styleClass="form-horizontal">
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-2">
							<h:commandButton styleClass="btn btn-warning"
								action="#{administratorController.modifyPainting}"
								value="Modifica" />
						</div>
						<div class="col-sm-2">
							<h:commandButton styleClass="btn btn-danger"
								action="#{paintingController.deletePainting}" value="Elimina" />
						</div>
					</div>
				</h:form>
			</c:if>
		</div>
	</f:view>
		<div>
			Clicca <a href='<c:url value="/faces/index.jsp" />'>QUI</a>	per tornare alla pagina iniziale
		</div>
</body>
</html>
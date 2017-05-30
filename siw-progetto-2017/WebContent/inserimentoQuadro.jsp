<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New Product</title>
</head>
<body>
	<h1> Inserisci i dati del quadro </h1>
<f:view>
<h:form>
    <div>Titolo: <h:inputText value="#{paintingController.titolo}" 
                     required="true"
                     requiredMessage="Titolo obbligatorio"
                     id="titolo"/> <h:message for="titolo" />
	</div>
    <div>Anno di realizzazione: <h:inputText value="#{paintingController.anno}" 
                     required="false"
                     converterMessage="L'anno deve essere un numero"
                     id="anno"/> <h:message for="anno" />
	</div>
    <div>Tecnica utilizzata: <h:inputText value="#{paintingController.tecnica}" 
                     required="true"
                     requiredMessage="Tecnica obbligatoria"
                     id="tecnica"/> <h:message for="tecnica" />
	</div>
    <div>Dimensioni: <h:inputTextarea value="#{paintingController.dimensioni}" 
    				required="false" 
    				cols="20" 
    				rows="5" /> 
                     
	</div>   
	<div>Autore: <h:inputTextarea value="#{paintingController.autore}" 
    				required="false" 
    				cols="20" 
    				rows="5" /> 
                     
	</div>
	<div>
		<h:commandButton value="Submit"  action="#{paintingController.createProduct}"/>
	</div>
	<h:commandLink action="#{paintingController.listProducts}"
						value="List all Products" />
</h:form>
</f:view>
</body>
</html>
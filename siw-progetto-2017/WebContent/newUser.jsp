<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Registrazione utente </title>
</head>
<body>
<h1> Inserisci i dati per registrarti al sistema </h1>
<f:view>
<h:form>
    <div>Nome: <h:inputText value="#{userController.nome}" 
                     required="true"
                     requiredMessage="Nome Obbligatorio"
                     id="nome"/> <h:message for="nome" />
	</div>
    
    <div>Cognome: <h:inputText value="#{userController.cognome}" 
                     required="true"
                     requiredMessage="Cognome Obbligatorio"
                     id="cognome"/> <h:message for="cognome" />
	</div>
    
    <div>Numero di cellulare: <h:inputText value="#{userController.numeroTelefono}" 
                     required="false" />
	</div>
    <div>Email: <h:inputText value="#{userController.email}" 
    				 required="true"
                     requiredMessage="Email obbligatoria"
                     id="email"/> <h:message for="email" />
                     
	</div>
	<div>Password: <h:inputText value="#{userController.password}" 
    				 required="true"
                     requiredMessage="Password obbligatoria"
                     id="password"/> <h:message for="password" />
                     
	</div>
	<div>Data di nascita: <h:inputText value="#{userController.dataNascita}" 
                     required="false" />
    </div>
    
    <h2>Indirizzo:</h2>
    
    <div>Comune: <h:inputText value="#{addressController.comune}" 
    				 required="true"
                     requiredMessage="Comune obbligatorio"
                     id="comune"/> <h:message for="comune" />                    
	</div> 
	<div>Nazione: <h:inputText value="#{addressController.nazione}" 
    				 required="true"
                     requiredMessage="Nazione obligatoria"
                     id="nazione"/> <h:message for="nazione" />                    
	</div> 
	<div>Provincia: <h:inputText value="#{addressController.provincia}" 
    				 required="true"
                     requiredMessage="Provincia obbligatoria"
                     id="provincia"/> <h:message for="provincia" />                    
	</div> 
	<div>Via: <h:inputText value="#{addressController.via}" 
    				 required="true"
                     requiredMessage="Via obbligatoria"
                     id="via"/> <h:message for="via" />                    
	</div> 
	<div>Codice Postale: <h:inputText value="#{addressController.codicePostale}" 
    				 required="true"
                     requiredMessage="Codice Postale obligatorio"
                     id="codice_postale"/> <h:message for="codice_postale" />                    
	</div> 
	
	<div>
		<h:commandButton value="Submit" action="#{userController.createUser}" actionListener="#{addressController.createAddress}"/>
	</div>
	
</h:form>
</f:view>
</body>
</html>
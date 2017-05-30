<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Error</title>
</head>
<body>
<f:view>
<h1>Email o password invalide</h1>
<h:form>
    <div>email: <h:inputText value="#{administratorController.email}" 
                     required="true"
                     requiredMessage="Email Obbligatoria"
                     id="email"/> <h:message for="email" />
	</div>
    <div>password: <h:inputText value="#{administratorController.password}" 
                     required="true"
                     requiredMessage="Password obbligatoria"
                     id="password"/> <h:message for="password" />
	</div>
	<div>
		<h:commandButton value="Submit"  action="#{administratorController.administratorLogin}"/>
		<h:commandButton value="Home"  action="/faces/index.jsp"/>
	</div>
</h:form>
</f:view>
</body>
</html>
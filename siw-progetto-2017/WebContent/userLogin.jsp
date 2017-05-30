<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>User login</title>
</head>
<body>
<f:view>
<h:form>
    <div>email: <h:inputText value="#{userController.email}" 
                     required="true"
                     requiredMessage="Email obbligatoria"
                     id="email"/> <h:message for="email" />
	</div>
    <div>password: <h:inputSecret value="#{userController.password}" 
                     required="true"
                     requiredMessage="Password obbligatoria"
                     id="password"/> <h:message for="password" />
	</div>
	<div>
		<h:commandButton value="Submit"  action="#{userController.userLogin}"/>
	</div>
</h:form>
</f:view>
</body>
</html>

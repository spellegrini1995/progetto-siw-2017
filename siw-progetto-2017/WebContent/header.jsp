
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap-theme.css" rel="stylesheet" type="text/css">
</head>

<h:form>
	<nav class="navbar navbar-custom">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/faces/index.jsp">Home</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><h:commandLink action="#{paintingController.paintings}" value="Lista quadri" /></li>

					<!-- Menu a tendina amministratore -->
					<c:if test="${administratorController.currentAdministrator != null}">
						<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Clienti<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><h:commandLink action="#{userController.users}" value="Utenti registrati" /></li>
								<li><h:commandLink action="#{administratorController.newUser}" value="Registra un nuovo cliente" /></li>
								<li><a href='<c:url value="/faces/deleteCustomer.jsp" />'>Elimina un cliente registrato</a></li>
								<li class="divider"></li>
							</ul>
								<li class="dropdown">
								<a class="dropdown-toggle" data-toggle="dropdown" href="#">Operazioni amministrazione<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><h:commandLink
										action="#{administratorController.newPainting}" value="Inserisci un nuovo quadro" /></li>
							</ul></li>
					</c:if>

					<!-- Menu a tendina utente -->
					<c:if test="${userController.currentUser != null}">
						<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">Operazioni utente <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><h:commandLink action="#{paintingController.viewPaintings}" value="Visualizza tutti i quadri" /></li>
								<!-- bisogna fare la selezione dei dipinti per autore -->
							</ul></li>
						<c:if test="${currentOrder != null}">
							<li><a href='<c:url value="/faces/order.jsp" />'>Torna
									all'ordine corrente n° ${currentOrder.id}</a></li>
							<p>
						</c:if>
					</c:if>
				</ul>

				<!-- Login e amministrazione -->
				<ul class="nav navbar-nav navbar-right">
					<c:if
						test="${administratorController.currentAdministrator != null}">
						<li><a href='<c:url value="/faces/administratorPage.jsp" />'>Il
								mio profilo: <strong>${administratorController.currentAdministrator.nickname}</strong>
						</a></li>
						<li><h:commandLink value="Logout"
								action="#{administratorController.logoutAdministrator}" /></li>
					</c:if>

					<c:if test="${userController.currentCustomer != null}">
						<li><a href='<c:url value="/faces/userHome.jsp" />'>Il
								mio profilo: <b>${userController.currentUser.nome}${userController.currentUser.cognome}</b>
						</a></li>
						<li><h:commandLink value="Logout"
								action="#{userController.logoutUser}" /></li>
					</c:if>

					<c:if test="${administratorController.currentAdministrator == null && customerController.currentCustomer == null}">
						<li><a href='<c:url value="/faces/login.jsp" />'>Login</a></li>
						<li><a href='<c:url value="/faces/registrazioneUtente.jsp" />'>Registrati</a></li>
						<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Amministrazione<b
								class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href='<c:url value="/faces/administratorLogin.jsp" />'>Login amministratore</a></li>
							</ul></li>
					</c:if>
				</ul>

			</div>
		</div>
	</nav>
</h:form>

<!-- include javascript, jQuery FIRST -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
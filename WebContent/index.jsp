<jsp:useBean id="calcula" class="Bean.BeanJSP" type="Bean.BeanJSP"
	scope="page" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/estilo.css">
<title>Projeto 01</title>
</head>
<body>

	<div class="login-page">
		<h1>Projeto 01</h1>

		<div class="form">
			<form action="LoginServlet" method="post">

				Login: <input type="text" class="form-control"
					placeholder="username" id="login" name="login" required>

				Senha: <input type="password" class="form-control"
					placeholder="password" id="senha" name="senha" required>

				<button class="btn btn-outline-primary" type="submit" value="Logar">Logar</button>

			</form>
		</div>
	</div>

</body>
</html>
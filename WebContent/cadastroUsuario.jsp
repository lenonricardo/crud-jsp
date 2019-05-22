<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="resources/css/estiloCadastro.css">

<link rel="stylesheet" href="resources/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"
	crossorigin="anonymous">

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<title>Cadastro de Usuário</title>
</head>
<body class="body">
	<div
		class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
		<h5 class="my-0 mr-md-auto font-weight-normal">
			<a href="acessoliberado.jsp">Projeto01</a>
		</h5>

		<nav class="my-2 my-md-0 mr-md-3">
			<a class="p-2 text-dark" href="#">Sobre</a> <a class="p-2 text-dark"
				href="#">Contato</a> <a class="p-2 text-dark" href="#">Suporte</a>
		</nav>
		<form class="form-inline mt-2 mt-md-0">
			<input class="form-control mr-sm-2" type="text" placeholder="Search"
				aria-label="Search">
			<button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
		</form>
		&nbsp; <a class="btn btn-outline-danger" href="index.jsp">Sign out</a>
	</div>
	<!-- <div class="main"> -->

	<h1>Sign up</h1>
	<div class="register-page">

		<div class="form">

			${msg}

			<form method="POST" action="salvarUsuario" id="formUser">
				<h2 class="form-title">
					<a href="salvarUsuario?acao=listar"><i class="fas fa-list-ul"></i></a>
					Cadastro de Usuário
				</h2>


				<input type="text" class="form-control" placeholder="Código"
					name="id" id="id" value="${user.id}" readonly="readonly" required />





				<input type="text" class="form-control" placeholder="Login"
					name="login" id="login" value="${user.login}" required /> <input
					type="password" class="form-control" placeholder="Senha"
					name="senha" id="senha" value="${user.senha}" required /> <input
					type="text" class="form-control" placeholder="Nome" name="nome"
					id="nome" value="${user.nome}" required />



				<button type="submit" class="btn btn-primary btn-lg">Salvar</button>
				<button type="submit" class="btn btn-danger btn-lg"
					onclick="document.getElementById('formUser').action = 'salvarUsuario?acao=reset'">Cancelar</Button>

			</form>



		</div>
	</div>

	<!--  </div> -->


	<div class="table-users" id="tabela">
		<table class="table">


			<thead class="thead-light">
				<tr>
					<th scope="col">Código</th>
					<th scope="col">Login</th>
					<th scope="col">Nome</th>
					<th scope="col">Editar</th>
					<th scope="col">Excluir</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="user">
					<tr>
						<th scope="row"><c:out value="${user.id}" /></th>
						<td><c:out value="${user.login}" /></td>
						<td><c:out value="${user.nome}" /></td>
						<td><a class="edit"
							href="salvarUsuario?acao=editar&user=${user.id}"><i
								class="far fa-edit"></i></a></td>
						<td><a class="delete"
							href="salvarUsuario?acao=delete&user=${user.id}"><i
								class="far fa-trash-alt"></i></a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
        <h5 class="my-0 mr-md-auto font-weight-normal">Projeto01</h5>
        
        <nav class="my-2 my-md-0 mr-md-3">
          <a class="p-2 text-dark" href="#">Sobre</a>
          <a class="p-2 text-dark" href="#">Contato</a>
          <a class="p-2 text-dark" href="#">Suporte</a>          
        </nav>
        <form class="form-inline mt-2 mt-md-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
          </form>
          &nbsp;
        <a class="btn btn-outline-danger" href="index.jsp">Sign out</a>
      </div>
      <div class="container w-100 p-3">
        <div class="jumbotron mt-3 align-middle">
          <h1>Bem vindo ao sistema de cadastros JSP!</h1>
          <p class="lead">Clique no botão abaixo para cadastrar usuários e visualizar os usuários cadastrados!</p>
          <a class="btn btn-lg btn-primary" href="salvarUsuario?acao=listartodos" role="button">Cadastrar Usuário &raquo;</a>
        </div>
      </div>

</body>
</html>
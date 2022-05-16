<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de contato</title>
<link rel="stylesheet" href="style.css">
<title>Agenda de contato</title>
</head>
<body>
	
	<div class="content">
		<h1>Editar contato</h1>
	</div>
	
<div class="form">
  <form action="update" name="formContato">
  	<input type="hidden" name="id" id="id" readonly value="<% out.print(request.getAttribute("id")); %>">
    <label for="">Name: </label>
    <input type="text" name="nome" id="nome" value="<% out.print(request.getAttribute("nome")); %>">
	<br>
    <label for="">Fone: </label>
    <input type="text" name="fone" id="fone" value="<% out.print(request.getAttribute("fone")); %>">
	<br>
    <label for="">Email: </label>
    <input type="text" name="email" id="email" value="<% out.print(request.getAttribute("email")); %>">
  	<br>
    <input type="button" value="Salvar" class="botao1" onclick="validar()">
    <a href="main" class="botao2">Voltar</a>
  </form>
</div>
	
	<script src="javascript/validaform.js"></script>
</body>
</html>
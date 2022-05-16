<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");

%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>agenda de contato</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<div class="content">
		<a href="novo.html" class="botao1">Novo contato</a>
		<a href="report" class="botao2">Relatório</a>
	</div>
	<table>

		<tr>
			<th>id</th>
			<th>Nome</th>
			<th>Fone</th>
			<th>Email</th>
			<th>Opções </th>
			<th></th>
		</tr>

		<tr>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<td><%=lista.get(i).getId()%></td>
			<td><%=lista.get(i).getNome()%></td>
			<td><%=lista.get(i).getFone()%></td>
			<td><%=lista.get(i).getEmail()%></td>
			<td>
				<a href="select?id=<%=lista.get(i).getId()%>" class="botao1">Editar</a>
				<a href="javascript: confirmar(<%=lista.get(i).getId()%>)"class="botao2">Excluir</a>
			<td>
		</tr>

		<%
		}
		%>
	</table>

	<script src="javascript/confirma.js"></script>
</body>
</html>
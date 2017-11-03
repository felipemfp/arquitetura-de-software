<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.ifrn.prepara.modelo.Concurso" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Prepara!Concursos</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.0/css/bulma.min.css">
</head>
<body>
<div class="container">
<h1 class="title">Lista dos Concursos Cadastrados</h1>
<hr/>
<%
	List<Concurso> lista = (List<Concurso>) request.getAttribute("concursos");
	if (lista == null) {
		response.sendRedirect("/PreparaConcursos/index.html");
		return;
	}  
	if (lista.isEmpty()) {
		out.println("<h2>Nenhum concurso cadastrado!</h2>");
	} else { %>

<table class="table">
<thead>
	<tr>
		<th>ID</th>
		<th>Nome</th>
		<th>Descrição</th>
	</tr>
	</thead>
	<tbody>
	<%
		for( Concurso c : lista ) {
			out.println("<tr><td>"+c.getId()+"</td>");
			out.println("<td><a href=\"/PreparaConcursos/simulados?concurso="+c.getId()+"\">"+c.getNome()+"</a></td>");
			out.println("<td>"+c.getDescricao()+"</td></tr>");
		} 
	%>
	</tbody>
</table>
<%
	} %>
	
<%@ include file="rodape.html" %>

</div>
</body>
</html>
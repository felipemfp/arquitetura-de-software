<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.ifrn.prepara.modelo.Concurso" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Prepara!Concursos</title>
</head>
<body>
<h1>Lista dos Concursos Cadastrados</h1>
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

<table border="1">
	<tr>
		<th>ID</th>
		<th>Nome</th>
		<th>Descrição</th>
	</tr>
<%
		for( Concurso c : lista ) {
			out.println("<tr><td>"+c.getId()+"</td>");
			out.println("<td><a href=\"detalhar?idConcurso="+c.getId()+"\">"+c.getNome()+"</a></td>");
			out.println("<td>"+c.getDescricao()+"</td></tr>");
		} %>
</table>
<%
	} %>
<hr/>
&copy;Copyright Turma de Arquitetura de Software/TADS/IFRN/2017.2
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.ifrn.prepara.modelo.Concurso, br.ifrn.prepara.modelo.Simulado, br.ifrn.prepara.modelo.Questao, br.ifrn.prepara.modelo.Alternativa" %>
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

<h1 class="title">Simulado</h1>
<p class="subtitle">Concurso:&nbsp;
<%
	Concurso c = (Concurso) request.getAttribute("concurso"); 
	out.print(c.getNome()); 
%>
</p>
<hr/>

<form action="/" method="post">
<%
	Simulado s = (Simulado) request.getAttribute("simulado");
	
	for (Questao q : s.getQuestoes()) {
	%>
	
	<div class="field">
	<h4 class="title is-4"><% out.print(q.getEnunciado()); %></h4>
	
	<% for (Alternativa a : q.getAlternativas()) { %>
	
	<div class="control">
		<label class="radio">
			<input type="radio" name="questao-<%out.print(q.getId());%>">
			<% out.print(a.getEnunciado()); %>		
		</label>
	</div>
	
	<% } %>
	
	</div>
	
	
	<%
	}
%>

<div class="field is-grouped">
  <div class="control">
    <button type="submit" class="button is-link">Enviar</button>
  </div>
  <div class="control">
    <a href="/PreparaConcursos" class="button is-text">Cancelar</a>
  </div>
</div>

</form>


<%@ include file="rodape.html" %>
</div>
</body>
</html>
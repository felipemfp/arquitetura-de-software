<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap, java.util.Map, java.util.List, br.ifrn.prepara.modelo.Concurso, br.ifrn.prepara.modelo.ResultadoSimulado, br.ifrn.prepara.modelo.Simulado, br.ifrn.prepara.modelo.Resposta, br.ifrn.prepara.modelo.Questao, br.ifrn.prepara.modelo.Alternativa" %>
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

<h1 class="title">Resultado</h1>
<p class="subtitle">Concurso:&nbsp;
<%
	ResultadoSimulado r = (ResultadoSimulado) request.getAttribute("resultado");
	Concurso c = (Concurso) request.getAttribute("concurso"); 
	Simulado s = (Simulado) request.getAttribute("simulado");
	
	Map<Integer, Resposta> mapaRespostas = new HashMap<Integer, Resposta>();
	
	for(Resposta rsp: r.getRespostas()) {
		mapaRespostas.put(rsp.getQuestaoId(), rsp);
	}

	out.print(c.getNome()); 
%>
</p>
<progress class="progress is-medium is-success" value="<%=String.format("%2.0f", r.getPorcetagem())%>" max="100">String.format("%2.0f", r.getPorcetagem())% asmkamsdkm</progress>
<hr/>

<div>
<% for (Questao q : s.getQuestoes()) {%>
	
	<%
		Resposta resposta = mapaRespostas.get(q.getId());
	%>
	<div class="field">
	<h4 class="title is-4"><% out.print(q.getEnunciado()); %></h4>
	
	<% for (Alternativa a : q.getAlternativas()) { %>
	
	<div class="control">
		<label class="radio">
			<input disabled type="radio" <% out.print(resposta.getAlternativaId() == a.getId() ? "checked" : ""); %>  name="questao-<%out.print(q.getId());%>" value="<%out.print(a.getId());%>">
			<% out.print(a.getEnunciado()); %>
			<% out.print(a.isCorreta() ? "<span class=\"tag is-success\">Correta</span>" : ""); %>		
			<% out.print(resposta.getAlternativaId() == a.getId() ? "<span class=\"tag is-info\">Marcada</span>" : ""); %>
		</label>
	</div>
	
	<% } %>
	
	</div>
	
	
<% } %>

<div class="field is-grouped">
  <div class="control">
    <a href="/PreparaConcursos" class="button is-link is-primary ">Caminho de Estudo</a>
  </div>
</div>

</div>


<%@ include file="rodape.html" %>
</div>
</body>
</html>
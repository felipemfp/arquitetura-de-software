package br.ifrn.prepara.modelo;

import java.util.Date;
import java.util.List;

public class Simulado {

	private int id;
	private int concursoId;
	private Date criado;
	private List<Questao> questoes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getConcursoId() {
		return concursoId;
	}
	public void setConcursoId(int concursoId) {
		this.concursoId = concursoId;
	}
	public Date getCriado() {
		return criado;
	}
	public void setCriado(Date criado) {
		this.criado = criado;
	}
	public List<Questao> getQuestoes() {
		return questoes;
	}
	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}
	
	
}

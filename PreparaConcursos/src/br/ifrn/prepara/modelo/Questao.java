package br.ifrn.prepara.modelo;

import java.util.List;

public class Questao {

	private int id;
	private int topicoId;
	private String enunciado;
	private List<Alternativa> alternativas;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTopicoId() {
		return topicoId;
	}
	public void setTopicoId(int topicoId) {
		this.topicoId = topicoId;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public List<Alternativa> getAlternativas() {
		return alternativas;
	}
	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}
}

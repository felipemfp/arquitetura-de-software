package br.ifrn.prepara.modelo;

import java.util.ArrayList;
import java.util.List;

public class ResultadoSimulado {
	private int id;
	private int simuladoId;
	private double porcetagem;
	
	private List<Resposta> respostas;
	public List<Resposta> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	public void addResposta(Resposta r) {
		if (this.respostas == null) this.respostas = new ArrayList<Resposta>();
		this.respostas.add(r);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSimuladoId() {
		return simuladoId;
	}
	public void setSimuladoId(int simuladoId) {
		this.simuladoId = simuladoId;
	}
	public double getPorcetagem() {
		return porcetagem;
	}
	public void setPorcetagem(double porcetagem) {
		this.porcetagem = porcetagem;
	}
}

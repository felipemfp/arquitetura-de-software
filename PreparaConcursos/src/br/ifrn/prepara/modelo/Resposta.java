package br.ifrn.prepara.modelo;

public class Resposta {
	private int id;
	private int resultadoId;
	private int questaoId;
	private int alternativaId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getResultadoId() {
		return resultadoId;
	}
	public void setResultadoId(int resultadoId) {
		this.resultadoId = resultadoId;
	}
	public int getQuestaoId() {
		return questaoId;
	}
	public void setQuestaoId(int questaoId) {
		this.questaoId = questaoId;
	}
	public int getAlternativaId() {
		return alternativaId;
	}
	public void setAlternativaId(int alternativaId) {
		this.alternativaId = alternativaId;
	}
}

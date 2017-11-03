package br.ifrn.prepara.modelo;

public class Alternativa {
	private int id;
	private int questaoId;
	private String enunciado;
	private boolean correta;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuestaoId() {
		return questaoId;
	}
	public void setQuestaoId(int questaoId) {
		this.questaoId = questaoId;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public boolean isCorreta() {
		return correta;
	}
	public void setCorreta(boolean correta) {
		this.correta = correta;
	}
}

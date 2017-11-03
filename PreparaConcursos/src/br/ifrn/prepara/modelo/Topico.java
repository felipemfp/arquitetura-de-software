package br.ifrn.prepara.modelo;

public class Topico {

	private int id;
	private int concursoId;
	private String nome;
	private String descricao;
	
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}

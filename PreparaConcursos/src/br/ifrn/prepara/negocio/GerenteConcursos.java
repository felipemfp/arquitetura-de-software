package br.ifrn.prepara.negocio;

import java.util.List;

import br.ifrn.prepara.modelo.Concurso;
import br.ifrn.prepara.persistencia.ConcursoDAO;

public class GerenteConcursos {

	private ConcursoDAO dao;

	public GerenteConcursos() {
		super();
		dao = new ConcursoDAO();
	}
	
	public Concurso getConcurso(int id) {
		return dao.getConcurso(id);
	}

	public List<Concurso> listConcursos() {
		return dao.listConcursos();
	}
}

package br.ifrn.prepara.negocio;

import java.util.Collections;
import java.util.List;

import br.ifrn.prepara.modelo.Concurso;
import br.ifrn.prepara.modelo.Questao;
import br.ifrn.prepara.persistencia.ConcursoDAO;
import br.ifrn.prepara.persistencia.QuestaoDAO;

public class GerenteQuestoes {
	private QuestaoDAO dao;
	
	public GerenteQuestoes() {
		super();
		dao = new QuestaoDAO();
	}

	public List<Questao> listQuestoesPorTopico(int topicoId, int qtd) {
		List<Questao> l = dao.listQuestoes(topicoId);
		Collections.shuffle(l);
		return l.subList(0, qtd);
	}
}

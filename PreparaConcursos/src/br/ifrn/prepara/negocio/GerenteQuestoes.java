package br.ifrn.prepara.negocio;

import java.util.Collections;
import java.util.List;

import br.ifrn.prepara.modelo.Alternativa;
import br.ifrn.prepara.modelo.Concurso;
import br.ifrn.prepara.modelo.Questao;
import br.ifrn.prepara.modelo.Resposta;
import br.ifrn.prepara.persistencia.ConcursoDAO;
import br.ifrn.prepara.persistencia.QuestaoDAO;

public class GerenteQuestoes {
	private QuestaoDAO dao;
	
	public GerenteQuestoes() {
		super();
		dao = new QuestaoDAO();
	}
	
	public Questao getQuestao(int id) {
		return dao.getQuestao(id);
	}
	public List<Questao> listQuestoesPorSimulado(int simuladoId) {
		return dao.listQuestoesPorSimulado(simuladoId);
	}

	public List<Questao> listQuestoesPorTopico(int topicoId, int qtd) {
		List<Questao> l = dao.listQuestoes(topicoId);
		Collections.shuffle(l);
		return l.subList(0, qtd);
	}

	public boolean checaResposta(Resposta resposta) {
		List<Alternativa> alts = dao.listAlternativas(resposta.getQuestaoId());
		
		for (Alternativa alt: alts) {
			if (alt.getId() == resposta.getAlternativaId()) return alt.isCorreta();
		}
		
		return false;
	}
}

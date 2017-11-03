package br.ifrn.prepara.negocio;

import java.util.ArrayList;
import java.util.List;

import br.ifrn.prepara.modelo.Concurso;
import br.ifrn.prepara.modelo.Questao;
import br.ifrn.prepara.modelo.Simulado;
import br.ifrn.prepara.modelo.Topico;
import br.ifrn.prepara.persistencia.SimuladoDAO;

public class GerenteSimulados {
	private SimuladoDAO dao;
	
	public GerenteSimulados()
	{
		super();
		dao = new SimuladoDAO();
	}
	
	public Simulado getSimulado(int concursoId)
	{
		GerenteConcursos gConcurso = new GerenteConcursos();
		GerenteQuestoes gQuestao = new GerenteQuestoes();
		
		Concurso c = gConcurso.getConcurso(concursoId);
		
		Simulado s = new Simulado();
		s.setConcursoId(c.getId());
		
		List<Questao> lQuestoes = new ArrayList<Questao>();
		
		for (Topico topico : c.getTopicos()) {
			lQuestoes.addAll(gQuestao.listQuestoesPorTopico(topico.getId(), 3));
		}
		
		s.setQuestoes(lQuestoes);
		
		dao.saveSimulado(s);
		
		return s;
	}
}

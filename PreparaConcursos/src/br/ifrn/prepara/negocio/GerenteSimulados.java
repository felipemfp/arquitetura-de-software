package br.ifrn.prepara.negocio;

import java.util.ArrayList;
import java.util.List;

import br.ifrn.prepara.modelo.Concurso;
import br.ifrn.prepara.modelo.Questao;
import br.ifrn.prepara.modelo.Resposta;
import br.ifrn.prepara.modelo.ResultadoSimulado;
import br.ifrn.prepara.modelo.Simulado;
import br.ifrn.prepara.modelo.Topico;
import br.ifrn.prepara.persistencia.ResultadoSimuladoDAO;
import br.ifrn.prepara.persistencia.SimuladoDAO;

public class GerenteSimulados {
	private SimuladoDAO dao;
	private ResultadoSimuladoDAO resultadoDao;
	
	public GerenteSimulados()
	{
		super();
		dao = new SimuladoDAO();
		resultadoDao = new ResultadoSimuladoDAO();
	}
	
	public ResultadoSimulado avaliaSimulado(int simuladoId, List<Resposta> respostas)
	{
		GerenteQuestoes gQuestao = new GerenteQuestoes();

		Simulado s = getSimulado(simuladoId);
		ResultadoSimulado resultado = new ResultadoSimulado();
		resultado.setSimuladoId(simuladoId);
		
		int corretas = 0;
		
		for (Resposta resposta: respostas) {
			if (gQuestao.checaResposta(resposta)) corretas++;
			resultado.addResposta(resposta);
		}
		
		resultado.setPorcetagem(((double)corretas)/s.getQuestoes().size());
		
		resultadoDao.saveResultado(resultado);
		
		return resultado;
	}
	
	public Simulado getSimulado(int id) {
		GerenteQuestoes gQuestao = new GerenteQuestoes();
		
		Simulado s = dao.getSimulado(id);
		s.setQuestoes(gQuestao.listQuestoesPorSimulado(s.getId()));
		
		return s;
	}
	
	public Simulado getSimuladoPorConcurso(int concursoId)
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

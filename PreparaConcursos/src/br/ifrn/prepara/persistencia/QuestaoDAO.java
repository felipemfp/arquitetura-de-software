package br.ifrn.prepara.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ifrn.prepara.modelo.Alternativa;
import br.ifrn.prepara.modelo.Concurso;
import br.ifrn.prepara.modelo.Questao;
import br.ifrn.prepara.modelo.Topico;

public class QuestaoDAO {

	private Connection con = null;
	private final String USER = "postgres";
	private final String PASS = "postgres";
	
	public QuestaoDAO() {
		super();
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public List<Questao> listQuestoes(int topicoId) {
		if (con == null) return null;
		
		try {
			Statement stmt = con.createStatement();
			String SQL = "SELECT id, topicoId, enunciado FROM questoes WHERE topicoId = " + topicoId;
			ResultSet resultado = stmt.executeQuery(SQL);
			return extraiQuestoes(resultado);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public List<Questao> listQuestoesPorSimulado(int simuladoId) {
		if (con == null) return null;
		
		try {
			Statement stmt = con.createStatement();
			String SQL = "SELECT q.id, q.topicoId, q.enunciado FROM questoes q JOIN simulados_questoes s ON q.id = s.questaoId WHERE s.simuladoId = " + simuladoId;
			ResultSet resultado = stmt.executeQuery(SQL);
			return extraiQuestoes(resultado);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public Questao getQuestao(int id) {
		if (con == null) return null;
		
		try {
			Statement stmt = con.createStatement();
			String SQL = "SELECT id, topicoId, enunciado FROM questoes WHERE id = " + id + " LIMIT 1";
			ResultSet resultado = stmt.executeQuery(SQL);
			return extraiQuestao(resultado);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	private Questao extraiQuestao(ResultSet r) throws SQLException {
		
		if (r.next()) {
			Questao q = new Questao();
			q.setId(r.getInt("id"));
			q.setTopicoId(r.getInt("topicoId"));
			q.setEnunciado(r.getString("enunciado"));
			q.setAlternativas(listAlternativas(q.getId()));
			return q;
		}
		
		return null;
	} 
	
	private List<Questao> extraiQuestoes(ResultSet r) throws SQLException {
		List<Questao> l = new ArrayList<Questao>();
		while (r.next()) {
			Questao q = new Questao();
			q.setId(r.getInt("id"));
			q.setTopicoId(r.getInt("topicoId"));
			q.setEnunciado(r.getString("enunciado"));
			q.setAlternativas(listAlternativas(q.getId()));
			l.add(q);
		}
		return l;
	}
	
	public List<Alternativa> listAlternativas(int questaoId) {
		if (con == null) return null;
		
		try {
			Statement stmt = con.createStatement();
			String SQL = "SELECT id, questaoId, enunciado, correta FROM alternativas WHERE questaoId = " + questaoId;
			ResultSet resultado = stmt.executeQuery(SQL);
			return extraiAlternativas(resultado);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	private List<Alternativa> extraiAlternativas(ResultSet r) throws SQLException {
		List<Alternativa> l = new ArrayList<Alternativa>();
		while (r.next()) {
			Alternativa a = new Alternativa();
			a.setId(r.getInt("id"));
			a.setQuestaoId(r.getInt("questaoId"));
			a.setEnunciado(r.getString("enunciado"));
			a.setCorreta(r.getBoolean("correta"));
			l.add(a);
		}
		return l;
	}
}

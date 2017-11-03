package br.ifrn.prepara.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ifrn.prepara.modelo.Concurso;
import br.ifrn.prepara.modelo.Topico;

public class ConcursoDAO {

	private Connection con = null;
	private final String USER = "postgres";
	private final String PASS = "postgres";
	
	public ConcursoDAO() {
		super();
		try {
			// Carrega o driver do banco de dados na memória
			Class.forName("org.postgresql.Driver");
			// Solicita que seja estabelecia a conexão com o banco de dados
			// São informados: a URL do banco, o usuário do banco e a senha correspondente
			con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public Concurso getConcurso(int id) {
		if (con == null) return null;
		
		try {
			Statement stmt = con.createStatement();
			String SQL = "SELECT id, nome, descricao FROM concursos WHERE id = " + id + " LIMIT 1";
			ResultSet resultado = stmt.executeQuery(SQL);
			Concurso concurso = extraiConcurso(resultado);
			concurso.setTopicos(listTopicos(id));			
			return concurso;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public List<Topico> listTopicos(int concursoId) {
		if (con == null) return null;
		
		try {
			Statement stmt = con.createStatement();
			String SQL = "SELECT id, nome, descricao, concursoId FROM topicos WHERE concursoId = " + concursoId;
			ResultSet resultado = stmt.executeQuery(SQL);
			return extraiTopicos(resultado);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
	
	public Concurso extraiConcurso(ResultSet r) throws SQLException {
		Concurso c = new Concurso();
		
		if (r.next()) {
			c.setId(r.getInt(1));
			c.setNome(r.getString(2));
			c.setDescricao(r.getString(3));
		}
		
		return c;
	}
	
	public List<Concurso> listConcursos() {
		if (con != null) {
			try {
				// Criação da classe que permite a realização de consultas
				Statement stmt = con.createStatement();
				String SQL = "SELECT id, nome, descricao FROM concursos";
				// Realização da consulta ao banco
				ResultSet resultado = stmt.executeQuery(SQL);
				// Extrai os resultados da consulta
				return extraiConcursos(resultado);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	private List<Concurso> extraiConcursos(ResultSet resultado) throws SQLException {
		List<Concurso> lista = new ArrayList<Concurso>();
		while (resultado.next()) {
			Concurso c = new Concurso();
			c.setId(resultado.getInt(1));
			c.setNome(resultado.getString(2));
			c.setDescricao(resultado.getString(3));
			lista.add(c);
		}
		return lista;
	}
	
	private List<Topico> extraiTopicos(ResultSet r) throws SQLException {
		List<Topico> l = new ArrayList<Topico>();
		while (r.next()) {
			Topico t = new Topico();
			t.setId(r.getInt(1));
			t.setNome(r.getString(2));
			t.setDescricao(r.getString(3));
			t.setConcursoId(r.getInt(4));
			l.add(t);
		}
		return l;
	}

}

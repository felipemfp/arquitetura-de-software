package br.ifrn.prepara.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ifrn.prepara.modelo.Questao;
import br.ifrn.prepara.modelo.Resposta;
import br.ifrn.prepara.modelo.ResultadoSimulado;
import br.ifrn.prepara.modelo.Simulado;

public class ResultadoSimuladoDAO {

	private Connection con = null;
	private final String USER = "postgres";
	private final String PASS = "postgres";
	
	public ResultadoSimuladoDAO() {
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
	
//	public Simulado getSimulado(int id) {
//		if (con == null) return null;
//		
//		try {
//			Statement stmt = con.createStatement();
//			String SQL = "SELECT id, concursoId, criado FROM simulados WHERE id = " + id;
//			ResultSet resultado = stmt.executeQuery(SQL);
//			return extraiSimulado(resultado);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		
//		return null;
//	}
	
//	public Simulado extraiResultado(ResultSet r) throws SQLException {
//		Simulado s = new Simulado();
//		if (r.next()) {
//			s.setId(r.getInt("id"));
//			s.setConcursoId(r.getInt("concursoId"));
//			s.setCriado(r.getDate("criado"));
//		}
//		return s;
//	}
	
	public boolean saveResultado(ResultadoSimulado r) {
		if (con == null) return true;
		
		try {
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO simulados_resultados (simuladoId) VALUES (?) RETURNING id");
			pstmt.setInt(1, r.getSimuladoId());
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				r.setId(rs.getInt(1));	
				for (Resposta resp: r.getRespostas()) {
					PreparedStatement pstmt2 = con.prepareStatement("INSERT INTO simulados_respostas (resultadoId, questaoId, alternativaId) VALUES (?, ?, ?)");
					pstmt2.setInt(1, r.getId());
					pstmt2.setInt(2, resp.getQuestaoId());
					pstmt2.setInt(2, resp.getAlternativaId());
					pstmt2.execute();
					pstmt2.close();
				}
			}
			
			pstmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return false;
	}

}

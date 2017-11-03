package br.ifrn.prepara.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.ifrn.prepara.modelo.Questao;
import br.ifrn.prepara.modelo.Simulado;

public class SimuladoDAO {

	private Connection con = null;
	private final String USER = "postgres";
	private final String PASS = "postgres";
	
	public SimuladoDAO() {
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
	
	public boolean saveSimulado(Simulado s) {
		if (con == null) return true;
		
		try {
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO simulados (concursoId) VALUES (?)");
			pstmt.setInt(1, s.getConcursoId());
			pstmt.execute();
			pstmt.close();
			
			for (Questao q : s.getQuestoes()) {
				PreparedStatement pstmt2 = con.prepareStatement("INSERT INTO simulados_questoes (concursoId, questaoId) VALUES (?, ?)");
				pstmt2.setInt(1, s.getConcursoId());
				pstmt2.setInt(2, q.getId());
				pstmt2.execute();
				pstmt2.close();
			}

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return false;
	}

}

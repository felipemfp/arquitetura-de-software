package br.ifrn.prepara.apresentacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.ifrn.prepara.modelo.*;
import br.ifrn.prepara.negocio.GerenteConcursos;
import br.ifrn.prepara.negocio.GerenteQuestoes;
import br.ifrn.prepara.negocio.GerenteSimulados;

/**
 * Servlet implementation class SimuladosServlet
 */
@WebServlet("/simulados")
public class SimuladosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimuladosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GerenteSimulados negocio = new GerenteSimulados();
		GerenteConcursos gConcurso = new GerenteConcursos();
		
		String concursoId = request.getParameter("concurso");
		
		Simulado s = negocio.getSimulado(Integer.parseInt(concursoId));
		
		request.setAttribute("simulado", s);
		request.setAttribute("concurso", gConcurso.getConcurso(Integer.parseInt(concursoId)));

		request.getRequestDispatcher("exibeSimulado.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

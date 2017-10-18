package br.ifrn.prepara.apresentacao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifrn.prepara.modelo.Concurso;
import br.ifrn.prepara.negocio.GerenteConcursos;

@WebServlet("/concursos")
public class ConcursosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConcursosServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GerenteConcursos negocio = new GerenteConcursos();
		List<Concurso> lista = negocio.listConcursos();
		request.setAttribute("concursos", lista);
		request.getRequestDispatcher("exibeConcursos.jsp").forward(request, response);
	}

}

package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidatoDao;
import modelo.Candidato;


/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/")
public class CandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CandidatoDao candidatoDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidatoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.candidatoDao = new CandidatoDao();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		
		try {
		switch(action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertarUsuario(request, response);
			break;
		case "/delete":
			eliminarUsuario(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			actualizarUsuario(request, response);
			break;
		default:
			listCandidatos(request, response);
			break;
		}
		}catch (SQLException e) {
			throw new ServletException(e);
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertarUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, SQLException, IOException{
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int eleccion =  Integer.parseInt(request.getParameter("eleccion"));
		int numero =  Integer.parseInt(request.getParameter("numero"));
		
		Candidato candidato = new Candidato(documento, nombre, apellido, eleccion, numero);
		
		candidatoDao.insert(candidato);
		
		response.sendRedirect("list");
		
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Candidato candidatoActual = candidatoDao.select(id);
		
		request.setAttribute("candidato", candidatoActual);
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);
		
	}
	
	
	private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException{
		
		int id = Integer.parseInt(request.getParameter("id"));
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int eleccion =  Integer.parseInt(request.getParameter("eleccion"));
		int numero =  Integer.parseInt(request.getParameter("numero"));
		
		Candidato candidato = new Candidato(id, documento, nombre, apellido, eleccion, numero);
		
		candidatoDao.update(candidato);
		
		response.sendRedirect("list");
		
	}

	

	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
								
		candidatoDao.delete(id);
				
		response.sendRedirect("list");
	}
	
	private void listCandidatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException{
				 
		List <Candidato> listCandidatos = candidatoDao.selectAll();
		request.setAttribute("listCandidatos", listCandidatos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuariolist.jsp");
		dispatcher.forward(request, response);
		}
}
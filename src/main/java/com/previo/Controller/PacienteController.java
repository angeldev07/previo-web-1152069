package com.previo.Controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.previo.DAO.PacienteDAO;

/**
 * Servlet implementation class PacienteController
 */
@WebServlet("/")
public class PacienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PacienteDAO pDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PacienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		pDao = new PacienteDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Obtenemos la accion que se envie al controlador 
		String accion = request.getServletPath();
		
		
	}
	
	private void doAction (HttpServletRequest request, HttpServletResponse response, String accion) throws ServletException, IOException {
		switch (accion) {
		
		case "/newPaciente":
			break;
		case "/createPaciente":
			break;
		case "/actualizarPaciente":
			break;
		case "/eliminarPacinete":
			break;
			
		default:
			break;
			
		}
		
			
	}
	
	
	
	//Método para listar los paciente
	private void listPatient(HttpServletRequest request, HttpServletResponse response, String accion) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}

package com.previo.Controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.previo.DAO.PacienteDAO;
import com.previo.Entities.Paciente;

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
		doAction(request, response, accion);
		
	}
	
	private void doAction (HttpServletRequest request, HttpServletResponse response, String accion) throws ServletException, IOException {
		switch (accion) {
		
		case "/newPaciente":
			showPatientPage(request,response);
			break;
		case "/createPaciente":
			createNewPatient(request, response);
			break;
		case "/actualizarPaciente":
			updatePatient(request,response);
			break;
		case "/eliminarPaciente":
			deletePatiente(request,response);
			break;
			
		case "/mostrarPaciente":
			showPatientInfo(request,response);
			break;
		case "/editarPaciente":
			editPatient(request, response);
			break;
		default:
			listPatient(request, response);
			break;
			
		}
		
			
	}
	
	

	private void deletePatiente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//obtengo el id y lo elimino
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		pDao.delete( pDao.find(id) );
		
		//Redirecciono
		response.sendRedirect("list");
	}

	private void editPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		Paciente p = pDao.find(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("paciente", p);
		
		showPatientPage(request, response);
	}

	private void updatePatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		//Busco al paciente y lo envio como atributo
		
		//capturo todos los datos del formulario
		int id = Integer.parseInt(request.getParameter("id"));
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		Date fechaNacimiento = Date.valueOf(request.getParameter("fechaNacimiento"));
		
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		float peso = Float.parseFloat(request.getParameter("peso"));
		float estatura = Float.parseFloat(request.getParameter("estatura"));
		
		
		//Creo el usuario y lo redirecciono a la lista 
		pDao.update(new Paciente(id, documento, nombre, apellido, email, genero, fechaNacimiento, telefono, direccion, peso, estatura));
		response.sendRedirect("list");	
		
	}

	//Método para listar los paciente
	private void listPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obtengo la lista de paciente y la subo como atributo
		ArrayList<Paciente> list = (ArrayList<Paciente>) pDao.list();
		request.setAttribute("listPatient", list);
		
		//Redirecciono al jsp
		request.getRequestDispatcher("lista.jsp").forward(request, response);
		
	}
	
	//Metodo para mostrar la informacion del paciente tanto al editar como al consultar
	private void showPatientPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("paciente.jsp").forward(request, response);;
	}
	
	//Metodo para mostrar la info del paciente
	private void showPatientInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//consultar el paciente por el id y subirlo
		Paciente p = pDao.find(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("paciente", p);
		request.setAttribute("showInfo", true);
		
		showPatientPage(request, response);
		
	}
	
	//Método para registrar un nuevo paciente 
	private void createNewPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//capturo todos los datos del formulario
		
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		Date fechaNacimiento = Date.valueOf(request.getParameter("fechaNacimiento"));
		
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		float peso = Float.parseFloat(request.getParameter("peso"));
		float estatura = Float.parseFloat(request.getParameter("estatura"));
		
		
		//Creo el usuario y lo redirecciono a la lista 
		pDao.insert(new Paciente(documento, nombre, apellido, email, genero, fechaNacimiento, telefono, direccion, peso, estatura));
		response.sendRedirect("list");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}

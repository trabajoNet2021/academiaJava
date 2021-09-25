package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import entities.Persona;
import logic.PersonaLogic;

/**
 * Servlet implementation class ControlaPersona
 */
@WebServlet("/ControlaPersona")
public class ControlaPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlaPersona() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersonaLogic pLogic = new PersonaLogic();
		
		
		//int idPersona = Integer.parseInt(request.getParameter("idPersona"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String direccion = request.getParameter("direccion");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String fechaNac = request.getParameter("fechaNacimiento");
		int legajo = Integer.parseInt(request.getParameter("legajo"));
		String tipoPersona = request.getParameter("tipoPersona");
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		
		Persona per = new Persona(legajo, tipoPersona, nombre, apellido, direccion, email, telefono, fechaNac, usuario, clave);
		pLogic.newPersona(per);
		
		PrintWriter out = response.getWriter();
		
		out.append("Persona registrada correctamente");
		
		
		
		
	}

}

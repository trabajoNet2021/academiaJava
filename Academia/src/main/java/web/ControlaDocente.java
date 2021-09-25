package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import entities.DocenteCurso;
import logic.DocenteCursoLogic;


@WebServlet("/ControlaDocente")
public class ControlaDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ControlaDocente() {
        super();
    }
    
    
    public enum Modos {
    	Alta,
    	Baja,
    	Modificacion
    }
    
    
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		sesion.setAttribute("estado", Modos.Alta);
		
		DocenteCursoLogic dLogic = new DocenteCursoLogic();
		
		//Obtengo los datos desde el formulario
		String cargo = request.getParameter("cargo");
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		int idDocente = Integer.parseInt(request.getParameter("idDocente"));
		
		
		DocenteCurso doc = new DocenteCurso(idDocente, idCurso, cargo);
		dLogic.insert(doc);
		
		PrintWriter out = response.getWriter();
		
		out.append("Docente registrado correctamente");
		
		
		
	}

}

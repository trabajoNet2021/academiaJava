package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.PlanLogic;
import entities.Plan;


@WebServlet("/ControlaPlan")
public class ControlaPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ControlaPlan() {
        super();
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PlanLogic pLogic = new PlanLogic();
		String tipoABM = request.getParameter("tipoABM");
		
		
		switch(tipoABM) {
		case "alta":
			String descripcion = request.getParameter("descripcion");
			Plan planNuevo = new Plan(descripcion);
			pLogic.insert(planNuevo);
			response.getWriter().append("Plan agregado correctamente");
			break;
		
		case "modificacion":
			int idPlan = Integer.parseInt(request.getParameter("idPlan"));
			Plan pl = new Plan(idPlan);
			Plan plEncontrado = pLogic.getOne(pl);
			
			request.setAttribute("plan", plEncontrado);
			//request.getSession().setAttribute("plan", plEncontrado);
			request.getRequestDispatcher("modificacion.jsp").forward(request, response);
			break;
			
		case "baja":
			int id = Integer.parseInt(request.getParameter("idPlan"));
			Plan plEliminar = new Plan(id);
			pLogic.delete(plEliminar);
			response.getWriter().append("Plan eliminado correctamente");
		}
	}

}

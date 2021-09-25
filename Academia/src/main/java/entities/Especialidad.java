package entities;

public class Especialidad {
	
	int idEspecialidad;
	int idPlan;
	String descripcion;
	
	
	public int getIdEspecialidad() {
		return idEspecialidad;
	}
	public void setIdEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	public int getIdPlan() {
		return idPlan;
	}
	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	public Especialidad() {
		super();
	}
	
	
	//Constructor para actualizaciones
	public Especialidad(int idEspecialidad, int idPlan, String descripcion) {
		super();
		this.idEspecialidad = idEspecialidad;
		this.idPlan = idPlan;
		this.descripcion = descripcion;
	}
	
	
	//Constructor para bajas
	public Especialidad(int idEspecialidad) {
		super();
		this.idEspecialidad = idEspecialidad;
	}
	
	//Constructor para altas
	public Especialidad(int idPlan, String descripcion) {
		super();
		this.idPlan = idPlan;
		this.descripcion = descripcion;
	}
	
	
	
	@Override
	public String toString() {
		return "Especialidad [idEspecialidad=" + idEspecialidad + ", idPlan=" + idPlan + ", descripcion=" + descripcion
				+ "]";
	}
	
	
	
	
	
}

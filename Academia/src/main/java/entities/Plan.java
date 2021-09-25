package entities;

public class Plan {
	
	int idPlan;
	String descripcion;
	
	
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
	
	
	public Plan() {
		
	}
	
	
	//Constructor para bajas
	public Plan(int idPlan) {
		super();
		this.idPlan = idPlan;
	}
	
	
	//Constructor para altas
	public Plan(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
	
	//Constructor para modificaciones
	public Plan(int idPlan, String descripcion) {
		super();
		this.idPlan = idPlan;
		this.descripcion = descripcion;
	}
	
	
	@Override
	public String toString() {
		return "Plan [idPlan=" + idPlan + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
}

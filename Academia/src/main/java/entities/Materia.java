package entities;

public class Materia {
	
	int idMateria;
	int idCurso;	
	int hsSemanales;
	int hsTotales;
	int idPlan;	
	String descripcion;
	
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	public int getHsSemanales() {
		return hsSemanales;
	}
	public void setHsSemanales(int hsSemanales) {
		this.hsSemanales = hsSemanales;
	}
	public int getHsTotales() {
		return hsTotales;
	}
	public void setHsTotales(int hsTotales) {
		this.hsTotales = hsTotales;
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
	
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	
	
	public Materia() {
		super();
	}
	
	
	//Constructor para bajas
	public Materia(int idMateria) {
		super();
		this.idMateria = idMateria;
	}
	
	
	//Constructor para altas
	public Materia(int idCurso, int hsSemanales, int hsTotales, int idPlan, String descripcion) {
		super();
		this.idCurso = idCurso;
		this.hsSemanales = hsSemanales;
		this.hsTotales = hsTotales;
		this.idPlan = idPlan;
		this.descripcion = descripcion;
	}
	
	
	//Constructor para actualizaciones
	public Materia(int idMateria, int idCurso, int hsSemanales, int hsTotales, int idPlan, String descripcion) {
		super();
		this.idMateria = idMateria;
		this.idCurso = idCurso;
		this.hsSemanales = hsSemanales;
		this.hsTotales = hsTotales;
		this.idPlan = idPlan;
		this.descripcion = descripcion;
	}
	
	
	
	@Override
	public String toString() {
		return "Materia [idMateria=" + idMateria + ", hsSemanales=" + hsSemanales + ", hsTotales=" + hsTotales
				+ ", idPlan=" + idPlan + ", descripcion=" + descripcion + "]";
	}
	
	
	
	

}

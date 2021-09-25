package entities;

public class Curso {
	
	int idCurso;
	int cupo;
	int anioCalendario;
	String descripcion;
	
	public Curso() {
		
	}
	
	//Constructor para modificaciones y bajas
	public Curso( int idCurso) {
		this.idCurso = idCurso;
	}

	
	
	//Constructor para altas
	public Curso(int cupo, int anioCalendario, String descripcion) {
		super();
		this.cupo = cupo;
		this.anioCalendario = anioCalendario;
		this.descripcion = descripcion;
	}

	public int getAnioCalendario() {
		return this.anioCalendario;
	}
	public void setAnioCalendario(int anioCalendario) {
		this.anioCalendario = anioCalendario;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public int getCupo() {
		return cupo;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", cupo=" + cupo + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
}

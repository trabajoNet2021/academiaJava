package entities;

public class AlumnoInscripcion {
	
	int idInscripcion;	//Clave primaria
	int idAlumno;	//Clave for�nea a Persona
	
	public int getIdInscripcion() {
		return idInscripcion;
	}
	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}
	
	
	
	
}

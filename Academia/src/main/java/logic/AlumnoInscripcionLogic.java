package logic;

import java.util.LinkedList;

import data.DataAlumnoInscripcion;
import entities.AlumnoInscripcion;

public class AlumnoInscripcionLogic {
	
	DataAlumnoInscripcion aluInscripcionData;
	
	public AlumnoInscripcionLogic() {
		aluInscripcionData = new DataAlumnoInscripcion();
	}
	
	
	public LinkedList<AlumnoInscripcion> list() {
		LinkedList<AlumnoInscripcion> aluInscripcion = aluInscripcionData.list();
		return aluInscripcion;
	}
	
	
	public AlumnoInscripcion search(AlumnoInscripcion aluInscripcion) {
		AlumnoInscripcion ali = aluInscripcionData.search(aluInscripcion);
		return ali;
	}
	
	
	public void newAlumno(AlumnoInscripcion aluInscripcion) {
		aluInscripcionData.newAlumno(aluInscripcion);
	}
	
	
	public void delete(AlumnoInscripcion aluInscripcion) {
		aluInscripcionData.delete(aluInscripcion);
	}
	
	
	
	public void update(AlumnoInscripcion aluInscripcion) {
		aluInscripcionData.update(aluInscripcion);
	}
}
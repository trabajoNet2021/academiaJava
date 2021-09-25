package logic;

import java.util.LinkedList;

import data.DataMateriaAlumno;
import entities.MateriaAlumno;

public class MateriaAlumnoLogic {

	DataMateriaAlumno matAlumnoData;
	
	public MateriaAlumnoLogic() {
		matAlumnoData = new DataMateriaAlumno();
	}
	
	public LinkedList<MateriaAlumno> list() {
		LinkedList<MateriaAlumno> matAlumno = matAlumnoData.list();
		return matAlumno;
	}
	
	public MateriaAlumno search(MateriaAlumno matAlumno) {
		MateriaAlumno matalu = matAlumnoData.search(matAlumno);
		return matalu;
	}
	
	
	public void newMateriaAlumno(MateriaAlumno matAlumno) {
		matAlumnoData.newMateriaAlumno(matAlumno);
	}
	
	
	public void delete(MateriaAlumno matAlumno) {
		matAlumnoData.delete(matAlumno);
	}
	
	
	
	public void update(MateriaAlumno matAlumno) {
		matAlumnoData.update(matAlumno);
	}
}
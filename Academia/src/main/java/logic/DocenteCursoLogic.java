package logic;

import java.util.LinkedList;

import data.DataDocenteCurso;
import entities.DocenteCurso;

public class DocenteCursoLogic {

	DataDocenteCurso docCursoData;
	
	public DocenteCursoLogic() {
		docCursoData = new DataDocenteCurso();
	}
	
	//Done
	public LinkedList<DocenteCurso> getAll() {
		LinkedList<DocenteCurso> docCursos = docCursoData.getAll();
		return docCursos;
	}
	
	
	//Done
	public DocenteCurso getOne(DocenteCurso docCurso) {
		DocenteCurso dcu = docCursoData.getOne(docCurso);
		return dcu;
	}
	
	//Done
	public void insert(DocenteCurso docCurso) {
		docCursoData.insert(docCurso);
	}

	//Done
	public void delete(DocenteCurso docCurso) {
		docCursoData.delete(docCurso);
	}
	
	//Done
	public void update(DocenteCurso docCurso) {
		docCursoData.update(docCurso);
	}
}

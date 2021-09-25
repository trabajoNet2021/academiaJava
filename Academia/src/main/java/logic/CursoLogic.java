package logic;

import java.util.LinkedList;

import data.DataCurso;
import entities.Curso;

public class CursoLogic {
	
	DataCurso curData;
	
	
	public CursoLogic() {
		curData = new DataCurso();
	}
	
	public LinkedList<Curso> list() {
		LinkedList<Curso> curso = curData.list();
		return curso;
	}
	
	public Curso search(Curso curso) {
		Curso cur = curData.search(curso);
		return cur;
	}
	
	public void newCurso(Curso curso) {
		curData.newCurso(curso);
	}
	
	public void delete(Curso curso) {
		curData.delete(curso);
	}
	
	
	
	public void update(Curso curso) {
		curData.update(curso);
	}
	
	
}
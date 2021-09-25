package logic;

import java.util.LinkedList;

import data.DataMateria;
import entities.Materia;

public class MateriaLogic {
	
	DataMateria materiaData;
	
	public MateriaLogic() {
		materiaData = new DataMateria();
	}
	
	
	public LinkedList<Materia> getAll() {
		LinkedList<Materia> materias = materiaData.getAll();
		return materias;
	}
	
	
	public Materia getOne(Materia materia) {
		Materia mat = materiaData.getOne(materia);
		return mat;
	}
	
	
	public void insert(Materia materia) {
		materiaData.insert(materia);
	}

	
	public void delete(Materia materia) {
		materiaData.delete(materia);
	}
	
	
	public void update(Materia materia) {
		materiaData.update(materia);
	}
}

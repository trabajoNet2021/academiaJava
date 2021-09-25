package logic;

import java.util.LinkedList;

import data.DataEspecialidad;
import entities.Especialidad;

public class EspecialidadLogic {

	DataEspecialidad especialidadData;
	
	public EspecialidadLogic() {
		especialidadData = new DataEspecialidad();
	}
	
	
	public LinkedList<Especialidad> getAll() {
		LinkedList<Especialidad> especialidades = especialidadData.getAll();
		return especialidades;
	}
	
	
	public Especialidad getOne(Especialidad especialidad) {
		Especialidad esp = especialidadData.getOne(especialidad);
		return esp;
	}
	
	
	public void insert(Especialidad especialidad) {
		especialidadData.insert(especialidad);
	}

	
	public void delete(Especialidad especialidad) {
		especialidadData.delete(especialidad);
	}
	
	
	public void update(Especialidad especialidad) {
		especialidadData.update(especialidad);
	}
}

package logic;

import java.util.LinkedList;

import data.DataPersona;
import entities.Persona;

public class PersonaLogic {
	
	DataPersona perData;
	
	public PersonaLogic() {
		perData = new DataPersona();
	}
	
	public LinkedList<Persona> list() {
		LinkedList<Persona> persona = perData.list();
		return persona;
	}
	
	
	public Persona search(Persona pers) {
		Persona per = perData.search(pers);
		return per;
	}
	
	
	public void newPersona(Persona pers) {
		perData.newPersona(pers);
	}
	
	
	public void delete(Persona pers) {
		perData.delete(pers);
	}
	
	
	
	public void update(Persona pers) {
		perData.update(pers);
	}
}
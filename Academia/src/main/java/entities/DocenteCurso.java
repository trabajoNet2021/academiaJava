package entities;

public class DocenteCurso {
	
	int idDocente;
	int idDictado;
	int idCurso;
	String cargo;
	
	
	public DocenteCurso() {
		super();
	}


	//Constructor para modificaciones
	public DocenteCurso(int idDocente, int idDictado, int idCurso, String cargo) {
		super();
		this.idDocente = idDocente;
		this.idDictado = idDictado;
		this.idCurso = idCurso;
		this.cargo = cargo;
	}
	
	
	//Constructor para bajas
	public DocenteCurso(int idDictado) {
		super();
		this.idDictado = idDictado;
	}
	

	//Constructor para altas
	public DocenteCurso(int idDocente, int idCurso, String cargo) {
		super();
		this.idDocente = idDocente;
		this.idCurso = idCurso;
		this.cargo = cargo;
	}


	public int getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(int idDocente) {
		this.idDocente = idDocente;
	}
	public int getIdDictado() {
		return idDictado;
	}
	public void setIdDictado(int idDictado) {
		this.idDictado = idDictado;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	@Override
	public String toString() {
		return "DocenteCurso [idDocente=" + idDocente + ", idDictado=" + idDictado + ", idCurso=" + idCurso + ", cargo="
				+ cargo + "]";
	}
	
	
	
		
}

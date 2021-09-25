package entities;

public class Persona {
	
	int idPersona;
	int legajo;
	String tipoPersona;
	String nombre;
	String apellido;
	String direccion;
	String email;
	String telefono;
	String fechaNacimiento;
	String nombreUsuario;
	String clave;
	
	
	public Persona() {
		
	}
	
	
	//Constructor para bajas y modificaciones
	public Persona( int idPersona) {
		this.idPersona = idPersona;
	}
	
	

	
	
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public String getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", legajo=" + legajo + ", tipoPersona=" + tipoPersona + ", nombre="
				+ nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", email=" + email + ", telefono="
				+ telefono + ", fechaNacimiento=" + fechaNacimiento + ", nombreUsuario=" + nombreUsuario + ", clave="
				+ clave + "]";
	}


	public Persona(int legajo, String tipoPersona, String nombre, String apellido, String direccion, String email,
			String telefono, String fechaNacimiento, String nombreUsuario, String clave) {
		super();
		this.legajo = legajo;
		this.tipoPersona = tipoPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
	}
	
	
	
	
	
}

//11/02/2026 14:14
package model;
public class Atendiente {
	
	private String dni;
	private String contraseña;
	private String nombre;
	private String apellidos;
	private String email;
	private static int atendientesCreados;
	
	//CONSTRUCTORES
	
	public Atendiente() {
		atendientesCreados++;
	}
	
	public Atendiente(String dni, String contraseña, String nombre, String apellidos, String email) {
		this();
		this.dni = dni;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.apellidos = apellidos;
		this.email = email;
	}
	
	//GETTERS
	public String getDni() {
		return dni;
	}
	
	public static int getAtendientesCreados() {
		return atendientesCreados;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	
	//SETTERS
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return "ATENDIENTE " + this.getNombre() + "\n  DNI = '" + this.getDni() + '\'' + "\n  Apellidos = '"
				+ this.getApellidos() + '\'' + "\n  Email = '" + this.getEmail() + '\'';
	}
	
	//EQUALS OBJETO
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Atendiente otro = (Atendiente) obj;
		return java.util.Objects.equals(this.dni, otro.dni);
	}
}

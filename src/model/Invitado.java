//11/02/2026 14:17
package model;
public class Invitado {
	
	private static int invitadosCreados;
	private int id;
	private String nombreUsuario;
	private String primerApellido;
	private String segundoApellido;
	private String telefono;
	private String carrera;
	private String correo;
	private String contrasena;
	
	//CONSTRUCTORES
	
	public Invitado() {
		invitadosCreados++;
		this.id = invitadosCreados;
	}
	
	public Invitado(String nombreUsuario, String primerApellido, String segundoApellido, String telefono,
			String carrera, String correo, String contrasena) {
		
		this();
		this.nombreUsuario = nombreUsuario;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.telefono = telefono;
		this.carrera = carrera;
		this.correo = correo;
		this.contrasena = contrasena;
	}
	
	//GETTERS
	public static int getInvitadosCreados() {
		return invitadosCreados;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public String getPrimerApellido() {
		return primerApellido;
	}
	
	public String getSegundoApellido() {
		return segundoApellido;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public String getCarrera() {
		return carrera;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	//SETTERS
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	//EQUALS OBJETO
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Invitado invitado = (Invitado) o;
		return id == invitado.id;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return "INVITADO " + this.getNombreUsuario() + "\n  Apellidos: '" + this.getPrimerApellido() + " "
				+ this.getSegundoApellido() + '\'' + "\n  Telefono: '" + this.getTelefono() + '\'' + "\n  Email: '"
				+ this.getCorreo() + '\'';
	}
}




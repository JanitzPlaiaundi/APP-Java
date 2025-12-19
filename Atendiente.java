public class Atendiente  {
	private String dni;
	private String contraseña;
	private String nombre;
	private String apellidos;
	private String email;
	
	public Atendiente(){}
	
	public Atendiente(String dni, String contraseña, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
		this.contraseña = contraseña;
		
		this.apellidos = "Sin especificar";
		this.email = "Sin especificar";
	}
	
	public Atendiente(String dni, String contraseña, String nombre, String apellidos, String email) {
		this.dni = dni;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.apellidos = apellidos;
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getContraseña() {
		return contraseña;
	}

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

	@Override
	public String toString() {
		return "Atendiente DNI=" + dni + ", Contraseña=" + contraseña + ", Nombre=" + nombre + ", Apellidos="
				+ apellidos + ", Email=" + email;
	}
	
}

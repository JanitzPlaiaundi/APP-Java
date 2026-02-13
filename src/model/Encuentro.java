//11/02/2026 14:25
package model;
import java.time.LocalDate;
public class Encuentro {
	
	private int id;
	private String lugar;
	private String nombre;
	private LocalDate dateStart;
	private LocalDate dateEnd;
	static private int encuentrosCreados;
	
	//CONSTRUCTORES
	public Encuentro() {
		encuentrosCreados++;
		this.id = encuentrosCreados;
	}
	
	public Encuentro(LocalDate dateStart, LocalDate dateEnd, String lugar, String nombre) {
		this();
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.lugar = lugar;
		this.nombre = nombre;
	}
	
	//GETTERS
	public int getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getLugar() {
		return this.lugar;
	}
	
	public LocalDate getDateStart() {
		return this.dateStart;
	}
	
	public LocalDate getDateEnd() {
		return this.dateEnd;
	}
	
	public static int getEncuentrosCreados() {
		return encuentrosCreados;
	}
	
	//SETTERS
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}
	
	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return "ENCUENTRO " + this.getNombre() + "\n  Ubicacion: '" + this.getLugar() + '\'' + "\n  Fecha: '"
				+ this.getDateStart() + " - " + this.getDateEnd() + '\'';
	}
	
	//EQUALS OBJETO
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Encuentro otro = (Encuentro) obj;
		return this.id == otro.id;
	}
}




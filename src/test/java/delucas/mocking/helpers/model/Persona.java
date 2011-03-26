package delucas.mocking.helpers.model;

public class Persona {

	private Integer edad;
	private String nombre;
	
	public Persona() {
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona: " + nombre + ", edad: " + edad;
	}
	
}

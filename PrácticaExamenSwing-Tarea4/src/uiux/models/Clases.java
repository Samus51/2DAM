package uiux.models;

public class Clases {

	private String nombre;
	private String profesor;
	private String turno;

	public Clases(String nombre, String profesor, String turno) {
		this.nombre = nombre;
		this.profesor = profesor;
		this.turno = turno;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the profesor
	 */
	public String getProfesor() {
		return profesor;
	}

	/**
	 * @return the turno
	 */
	public String isTurno() {
		return turno;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param profesor the profesor to set
	 */
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	/**
	 * @param turno the turno to set
	 */
	public void setTurno(String turno) {
		this.turno = turno;
	}
}

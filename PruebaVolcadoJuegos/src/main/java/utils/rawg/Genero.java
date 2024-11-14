package utils.rawg;

public class Genero {
	private int id_genero;
	private String nombre;

	/**
	 * @return the id_genero
	 */
	public int getId_genero() {
		return id_genero;
	}

	/**
	 * @param id_genero the id_genero to set
	 */
	public void setId_genero(int id_genero) {
		this.id_genero = id_genero;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param id_genero
	 * @param nombre
	 */
	public Genero(int id_genero, String nombre) {
		this.id_genero = id_genero;
		this.nombre = nombre;
	}

	@Override
	public String toString() {

		return "[Id del Género: " + id_genero + ", Nombre del Género: " + nombre + "]";
	}
}

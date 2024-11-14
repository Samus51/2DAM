package utils.rawg;

public class Plataforma {

	private int id_plataforma;
	private String nombre;

	/**
	 * @return the id_plataforma
	 */
	public int getId_plataforma() {
		return id_plataforma;
	}

	/**
	 * @param id_plataforma the id_plataforma to set
	 */
	public void setId_plataforma(int id_plataforma) {
		this.id_plataforma = id_plataforma;
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
	 * @param id_plataforma
	 * @param nombre
	 */
	public Plataforma(int id_plataforma, String nombre) {
		this.id_plataforma = id_plataforma;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "[Plataforma: "+nombre+", Id de la plataforma: "+id_plataforma+" ]";
	}
}

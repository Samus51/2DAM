package utils.rawg;

import java.util.List;

public class PlataformaPadre {
	private int id_padre;
	private String name;
	private List<Plataforma> plataformas;

	/**
	 * @param id_padre
	 * @param name
	 * @param plataformas
	 */
	public PlataformaPadre(int id_padre, String name, List<Plataforma> plataformas) {
		this.id_padre = id_padre;
		this.name = name;
		this.plataformas = plataformas;
	}

	/**
	 * @return the id_padre
	 */
	public int getId_padre() {
		return id_padre;
	}

	/**
	 * @param id_padre the id_padre to set
	 */
	public void setId_padre(int id_padre) {
		this.id_padre = id_padre;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the plataformas
	 */
	public List<Plataforma> getPlataformas() {
		return plataformas;
	}

	/**
	 * @param plataformas the plataformas to set
	 */
	public void setPlataformas(List<Plataforma> plataformas) {
		this.plataformas = plataformas;
	}

}

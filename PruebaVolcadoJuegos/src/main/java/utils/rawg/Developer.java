package utils.rawg;

public class Developer {

	private int id_dev;
	private String name_dev;

	/**
	 * @return the id_dev
	 */
	public int getId_dev() {
		return id_dev;
	}

	/**
	 * @param id_dev the id_dev to set
	 */
	public void setId_dev(int id_dev) {
		this.id_dev = id_dev;
	}

	/**
	 * @return the name_dev
	 */
	public String getName_dev() {
		return name_dev;
	}

	/**
	 * @param name_dev the name_dev to set
	 */
	public void setName_dev(String name_dev) {
		this.name_dev = name_dev;
	}

	/**
	 * @param id_dev
	 * @param name_dev
	 */
	public Developer(int id_dev, String name_dev) {
		this.id_dev = id_dev;
		this.name_dev = name_dev;
	}

	
	@Override
	public String toString() {
		return "Developer [Nombre: "+name_dev+", Id del Dev: "+id_dev+"]";
	}
}

package models;

public class Reparacion {
	private Vehiculo vehiculoAReparar;
	private String estado;

	/**
	 * @return the vehiculoAReparar
	 */
	public Vehiculo getVehiculoAReparar() {
		return vehiculoAReparar;
	}

	/**
	 * @param vehiculoAReparar the vehiculoAReparar to set
	 */
	public void setVehiculoAReparar(Vehiculo vehiculoAReparar) {
		this.vehiculoAReparar = vehiculoAReparar;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @param vehiculoAReparar
	 * @param estado
	 */
	public Reparacion(Vehiculo vehiculoAReparar, String estado) {
		this.vehiculoAReparar = vehiculoAReparar;
		this.estado = estado;
	}

}

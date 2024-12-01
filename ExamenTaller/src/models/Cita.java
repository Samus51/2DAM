package models;

import java.util.Date;

public class Cita {

	private Vehiculo vehiculo;
	private Date fechaCita;

	/**
	 * @return the vehiculo
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	/**
	 * @param vehiculo the vehiculo to set
	 */
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	/**
	 * @return the fechaCita
	 */
	public Date getFechaCita() {
		return fechaCita;
	}

	/**
	 * @param fechaCita the fechaCita to set
	 */
	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	/**
	 * @param vehiculo
	 * @param fechaCita
	 */
	public Cita(Vehiculo vehiculo, Date fechaCita) {
		this.vehiculo = vehiculo;
		this.fechaCita = fechaCita;
	}

}

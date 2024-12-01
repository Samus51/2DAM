package models;

public class Reparacion {
	private Cita cita;
	private String estado;
	private String observaciones;
	private double importe;
	private Empleado encargado;
	/**
	 * @return the cita
	 */
	public Cita getCita() {
		return cita;
	}
	/**
	 * @param cita the cita to set
	 */
	public void setCita(Cita cita) {
		this.cita = cita;
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
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}
	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	/**
	 * @return the importe
	 */
	public double getImporte() {
		return importe;
	}
	/**
	 * @param importe the importe to set
	 */
	public void setImporte(double importe) {
		this.importe = importe;
	}
	/**
	 * @param cita
	 * @param estado
	 * @param observaciones
	 * @param importe
	 */
	public Reparacion(Cita cita, String estado, String observaciones, double importe, Empleado encargado) {
		this.cita = cita;
		this.estado = estado;
		this.observaciones = observaciones;
		this.importe = importe;
		this.encargado = encargado;
	}
	/**
	 * @return the encargado
	 */
	public Empleado getEncargado() {
		return encargado;
	}
	/**
	 * @param encargado the encargado to set
	 */
	public void setEncargado(Empleado encargado) {
		this.encargado = encargado;
	}

}

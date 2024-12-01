package models;

import java.util.List;

public class Empleado extends Usuario {

	private List<Reparacion> lstReparaciones;

	public Empleado(String nombre, String apellidos, String telefono, String email, String contraseña,
			String metodoContacto, List<Reparacion> listaDeReparaciones) {
		super(nombre, apellidos, telefono, email, contraseña, metodoContacto);
		this.lstReparaciones = listaDeReparaciones;
	}

	/**
	 * @return the lstReparaciones
	 */
	public List<Reparacion> getLstReparaciones() {
		return lstReparaciones;
	}

	/**
	 * @param lstReparaciones the lstReparaciones to set
	 */
	public void setLstReparaciones(List<Reparacion> lstReparaciones) {
		this.lstReparaciones = lstReparaciones;
	}

}

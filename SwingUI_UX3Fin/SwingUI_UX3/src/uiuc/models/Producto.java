package uiuc.models;

import java.io.Serializable;

public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3360982350538212423L;
	private static String nombre;
	private double precioUnitario;
	private boolean esPerecedero;
	
	public Producto(String nombre, double precioUnitario, boolean esPerecedero) {
		Producto.nombre = nombre;
		this.precioUnitario = precioUnitario;
		this.esPerecedero = esPerecedero;
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
		Producto.nombre = nombre;
	}

	/**
	 * @return the precioUnitario
	 */
	public double getPrecioUnitario() {
		return precioUnitario;
	}

	/**
	 * @param precioUnitario the precioUnitario to set
	 */
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	/**
	 * @return the esPerecedero
	 */
	public boolean isEsPerecedero() {
		return esPerecedero;
	}

	/**
	 * @param esPerecedero the esPerecedero to set
	 */
	public void setEsPerecedero(boolean esPerecedero) {
		this.esPerecedero = esPerecedero;
	}
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true; // Comparar referencias
	    if (obj == null || getClass() != obj.getClass()) return false; // Verificar tipo

	    Producto pro = (Producto) obj;

	    // Comparar por nombre
	    return nombre != null ? nombre.equals(Producto.nombre) : Producto.nombre == null; // Comparar nombres
	}
	    }


	


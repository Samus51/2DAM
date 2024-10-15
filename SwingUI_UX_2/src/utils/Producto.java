package utils;

import java.io.Serializable;

public class Producto implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String nombre;
    private double precio;
    private boolean perecedero;

    public Producto(String nombre, double precio, boolean perecedero) {
        this.nombre = nombre;
        this.precio = precio;
        this.perecedero = perecedero;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean getCategoria() {
        return perecedero;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Producto)) return false;
        Producto other = (Producto) obj;
        return nombre.equalsIgnoreCase(other.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode();
    }

    public String toString() {
      return "Nombre: " + nombre + ", Precio: " + precio + ", Perecedero: " + getPerecedero();
  }

		private String getPerecedero() {
			// TODO Auto-generated method stub
			if(perecedero) {
				return "Si";
			}else {
				return "No";
			}
		}
}

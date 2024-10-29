package uiuc.models;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7573718444589877967L;
	private String nombre;
	private String apellidos;
	private String email;
	private String provincia;
	private String edad;

	public Cliente(String nombre, String apellidos, String email, String provincia, String edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.provincia = provincia;
		this.edad = edad;
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
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return the edad
	 */
	public String getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(String edad) {
		this.edad = edad;
	}
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        // Comparar los clientes por un campo único, como el email
        return email.equals(cliente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

	
	
}

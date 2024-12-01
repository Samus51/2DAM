package models;

public class Usuario {
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;
	private String contraseña;
	private String metodoContacto;

	/**
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 * @param email
	 * @param contraseña
	 * @param metodoContacto
	 */
	public Usuario(String nombre, String apellidos, String telefono, String email, String contraseña,
			String metodoContacto) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.contraseña = contraseña;
		if (metodoContacto.equals("Telefono") || metodoContacto.equals("Email")) {
			this.metodoContacto = metodoContacto;

		} else {
			throw new IllegalArgumentException("Valor de metodo de contacto inválido");
		}
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
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
	 * @return the contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	/**
	 * @return the metodoContacto
	 */
	public String getMetodoContacto() {
		return metodoContacto;
	}

	/**
	 * @param metodoContacto the metodoContacto to set
	 */
	public void setMetodoContacto(String metodoContacto) {
		this.metodoContacto = metodoContacto;
	}

}

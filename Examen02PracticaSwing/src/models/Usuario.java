package models;

import java.util.Date;

public class Usuario {

	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private Boolean esEntrenador;
	private String emails;
	private String pass;
	
	
	
	/**
	 * @param nombre
	 * @param apellidos
	 * @param fechaNacimiento
	 * @param esEntrenador
	 * @param emails
	 * @param pass
	 */
	public Usuario(String nombre, String apellidos, Date fechaNacimiento, Boolean esEntrenador, String emails,
			String pass) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.esEntrenador = esEntrenador;
		this.emails = emails;
		this.pass = pass;
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
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	/**
	 * @return the esEntrenador
	 */
	public Boolean getEsEntrenador() {
		return esEntrenador;
	}
	/**
	 * @param esEntrenador the esEntrenador to set
	 */
	public void setEsEntrenador(Boolean esEntrenador) {
		this.esEntrenador = esEntrenador;
	}
	/**
	 * @return the emails
	 */
	public String getEmail() {
		return emails;
	}
	/**
	 * @param emails the emails to set
	 */
	public void setEmails(String emails) {
		this.emails = emails;
	}
	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}
	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
	    return nombre + " " + apellidos; // Devuelve el nombre completo
	}

}

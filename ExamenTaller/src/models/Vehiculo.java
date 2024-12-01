package models;

public class Vehiculo {

	private String matricula;
	private String marca;
	private String modelo;
	private Usuario propietario;
	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Usuario getPropietario() {
	    return propietario;
	}

	public void setPropietario(Usuario propietario) {
	    this.propietario = propietario;
	}

	/**
	 * @param matricula
	 * @param marca
	 * @param modelo
	 */
	public Vehiculo(String matricula, String marca, String modelo, Usuario Propietario) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.propietario = Propietario;
	}

	
	
}

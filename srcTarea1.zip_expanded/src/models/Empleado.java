package models;

import java.io.Serializable;

public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Empresa;
	private int edad;
	private int num_empleados;

	
	
	
	
	public Empleado(String empresa, int edad, int num_empleados) {
		Empresa = empresa;
		this.edad = edad;
		this.num_empleados = num_empleados;
	}

	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return Empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the num_empleados
	 */
	public int getNum_empleados() {
		return num_empleados;
	}

	/**
	 * @param num_empleados the num_empleados to set
	 */
	public void setNum_empleados(int num_empleados) {
		this.num_empleados = num_empleados;
	}

	public String toString() {

		return "Empresa: " + Empresa + "\nEdad: " + edad + "\nNumero empleados: " + num_empleados;
	}

}

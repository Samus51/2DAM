package models;

import java.util.List;

import examen.mainApp.Launcher;

public class Equipo {
	private String nombre;
	private int anyoCreacion;
	private String genero;
	private String horario;
	private List<Usuario> lstJugadores;
	private Usuario entrenador;

	/**
	 * @param nombre
	 * @param anyoCreacion
	 * @param genero
	 * @param horario
	 * @param lstJugadores
	 * @param entrenador
	 */
	public Equipo(String nombre, int anyoCreacion, String genero, String horario, List<Usuario> lstJugadores,
			Usuario entrenador) {
		this.nombre = nombre;
		this.anyoCreacion = anyoCreacion;
		this.genero = genero;
		this.horario = horario;
		this.lstJugadores = lstJugadores;
		this.entrenador = entrenador;
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
	 * @return the anyoCreacion
	 */
	public int getAnyoCreacion() {
		return anyoCreacion;
	}

	/**
	 * @param anyoCreacion the anyoCreacion to set
	 */
	public void setAnyoCreacion(int anyoCreacion) {
		this.anyoCreacion = anyoCreacion;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the horario
	 */
	public String getHorario() {
		return horario;
	}

	/**
	 * @param horario the horario to set
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}

	/**
	 * @return the lstJugadores
	 */
	public List<Usuario> getLstJugadores() {
		return lstJugadores;
	}

	/**
	 * @param lstJugadores the lstJugadores to set
	 */
	public void setLstJugadores(List<Usuario> lstJugadores) {
		this.lstJugadores = lstJugadores;
	}

	/**
	 * @return the entrenador
	 */
	public Usuario getEntrenador() {
		return entrenador;
	}

	/**
	 * @param entrenador the entrenador to set
	 */
	public void setEntrenador(Usuario entrenador) {
		this.entrenador = entrenador;
	}

	
}

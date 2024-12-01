package examen.mainApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import examen.views.VentanaLogin;
import models.Equipo;
import models.Usuario;

public class Launcher {

	public static List<Usuario> lstJugadores;
	public static List<Equipo> lstEquipos;
	public static List<Usuario> lstUsuarios;

	public static void main(String[] args) throws ParseException {
	lstEquipos = new ArrayList<Equipo>();
	lstJugadores = new ArrayList<Usuario>();
	lstUsuarios = new ArrayList<Usuario>();
	Usuario us1 = new Usuario("Paco", "Mejido", new SimpleDateFormat("dd-MM-YYYY").parse("24-01-1995"), true, "a", "a");
	Usuario us2 = new Usuario("Laura", "Fernandez", new SimpleDateFormat("dd-MM-YYYY").parse("03-05-2001"), false, "b", "b");

	lstUsuarios.add(us1);
	lstUsuarios.add(us2);
	
	List<Usuario> lstJugadoresCadeteA = new ArrayList<Usuario>();
	lstJugadoresCadeteA.add(us2);
	
	Equipo eq1 = new Equipo("Cadete A",2010, "Femenino", "Lunes-Miercoles 15:00-17:30", lstJugadoresCadeteA,us1);
	Equipo eq2 = new Equipo("Juvenil B",2004, "Masculino", "Martes-Viernes 16:00-19:30", new ArrayList<Usuario>(),us1);

	lstEquipos.add(eq1);
	lstEquipos.add(eq2);

	
	VentanaLogin ventana = new VentanaLogin();
	ventana.setVisible(true);
	System.out.println("Usuarios cargados: " + Launcher.lstUsuarios.size());
	System.out.println("Equipos : "+lstEquipos.size());
	}
}

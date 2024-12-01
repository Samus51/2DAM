package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import models.Cita;
import models.Empleado;
import models.Reparacion;
import models.Usuario;
import models.Vehiculo;
import views.VentanaLogin;

public class Launcher {

	public static List<Usuario> lstClientes;
	public static List<Vehiculo> lstVehiculos;
	public static List<Cita> lstCitas;
	public static List<Reparacion> lstReparaciones;
	public static List<Empleado> lstEmpleados;

	public static void main(String[] args) throws ParseException {
		lstVehiculos = new ArrayList<Vehiculo>();
		lstClientes = new ArrayList<Usuario>();
		lstReparaciones = new ArrayList<Reparacion>();
		lstEmpleados = new ArrayList<Empleado>();
		lstCitas = new ArrayList<Cita>();
		Usuario c1 = new Usuario("Nacho", "Lorenzo", "123456789", "a", "a", "Telefono");
		Empleado e1 = new Empleado("Enrique", "Martínez", "987654321", "b", "b", "Email", lstReparaciones);
		Vehiculo vMaster = new Vehiculo("123ABC", "Tesla", "Ultimate",c1);
		Vehiculo vSpeeder = new Vehiculo("456ABC", "Tesla", "Roadster",c1);

		Cita citaNacho  = new Cita(vMaster, new SimpleDateFormat("dd-MM-yyyy").parse("01-12-2024"));
		Cita citaNacho2 = new Cita(vMaster, new SimpleDateFormat("dd-MM-yyyy").parse("01-12-2024"));
		Reparacion rep1 = new Reparacion(citaNacho, "Finalizado", "Bateria muerta", 250.34,e1);
		Reparacion repAnon = new Reparacion(citaNacho2, "Pendiente", "", 0, null);
		lstReparaciones.add(rep1);
		lstReparaciones.add(repAnon);
		lstVehiculos.add(vMaster);
		lstClientes.add(c1);
		lstEmpleados.add(e1);
		lstCitas.add(citaNacho);
		VentanaLogin ventana = new VentanaLogin();
		ventana.setVisible(true);
		System.out.println(lstCitas.size());
	}
}

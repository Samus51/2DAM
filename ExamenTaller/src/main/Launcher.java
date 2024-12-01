package main;

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

	public static void main(String[] args) {
		lstClientes = new ArrayList<Usuario>();
		lstReparaciones = new ArrayList<Reparacion>();
		Usuario c1 = new Usuario("Nacho", "Lorenzo", "123456789", "a", "a", "Telefono");
		Empleado e1 = new Empleado("Enrique", "Martínez", "987654321", "b", "b", "Email", lstReparaciones);
		Vehiculo vMaster = new Vehiculo("123ABC", "Tesla", "Ultimate");

		lstClientes.add(c1);
		VentanaLogin ventana = new VentanaLogin();
		ventana.setVisible(true);
	}
}

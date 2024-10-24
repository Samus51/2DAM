package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import models.Empleado;

public class UtilsFicheroArray {

	// Lee los empleados desde un archivo CSV y los almacena en una lista
	public static List<Empleado> empleadosToArray(String archivo) {
		List<Empleado> empleados = new ArrayList<>();
		try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
			lector.readLine(); // Saltamos la cabecera
			String linea;
			while ((linea = lector.readLine()) != null) {
				String[] campos = linea.split(",");
				String empresa = campos[0].replace("\"", "").trim();
				int edad = Integer.parseInt(campos[1].trim());
				int numEmpleados = Integer.parseInt(campos[2].trim());
				empleados.add(new Empleado(empresa, edad, numEmpleados));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return empleados;
	}

	// Guarda la lista de empleados en un archivo de texto, agregando la cabecera
	public static void toArchivoTexto(List<Empleado> empleados, String archivo) {
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {
			escritor.write("EMPRESA,EDAD,NUM_EMPLEADOS"); // Cabecera
			escritor.newLine();
			for (Empleado emp : empleados) {
				escritor.write(emp.getEmpresa() + "," + emp.getEdad() + "," + emp.getNum_empleados());
				escritor.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Guarda los empleados en formato binario, pero en orden inverso
	public static void toArchivoBinarioInverso(List<Empleado> empleados, String archivo) {
		try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(archivo))) {
			for (int i = empleados.size() - 1; i >= 0; i--) {
				escritor.writeObject(empleados.get(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Lee los empleados desde un archivo CSV
	public static List<Empleado> leerEmpleados(String archivo) {
		return empleadosToArray(archivo); // Reutilizamos el método para leer empleados
	}

	// Lee los empleados desde un archivo binario
	public static List<Empleado> leerEmpleadosB(String archivo) {
		List<Empleado> empleados = new ArrayList<>();
		try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(archivo))) {
			while (true) {
				try {
					Empleado empleado = (Empleado) lector.readObject();
					empleados.add(empleado);
				} catch (EOFException eof) {
					break; // Fin del archivo
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return empleados;
	}

	public static void main(String[] args) {
		// Lista de empleados de prueba
		List<Empleado> mana = new ArrayList<>();
		Empleado emp1 = new Empleado("Paco", 31, 1);
		Empleado emp2 = new Empleado("Pepe", 25, 2);
		Empleado emp3 = new Empleado("Manu", 43, 4);
		mana.add(emp1);
		mana.add(emp2);
		mana.add(emp3);

		// Guardar y leer en archivo de texto
		String rutaTexto = "src/utils/empleados.txt";
		toArchivoTexto(mana, rutaTexto);
		List<Empleado> empleadosTexto = leerEmpleados(rutaTexto);
		System.out.println("Empleados leídos del archivo de texto: " + empleadosTexto);

		// Guardar y leer en archivo binario
		String rutaBinario = "src/utils/empleados.bin";
		toArchivoBinarioInverso(mana, rutaBinario);
		List<Empleado> empleadosBinario = leerEmpleadosB(rutaBinario);
		System.out.println("Empleados leídos del archivo binario: " + empleadosBinario);
	}
}

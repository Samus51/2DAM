package tarea2.metodos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Libreria {

	public static void fichero_CSV_To_Binario(String archivoCSV) throws IOException {
		if (!archivoCSV.endsWith(".csv")) {
			throw new IllegalArgumentException(); // Verificación antes de procesar
		}
		String archivoBinario = archivoCSV.replace(".csv", ".dat");

		try (BufferedReader lector = new BufferedReader(new FileReader(archivoCSV));
				ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(archivoBinario))) {

			String linea;
			while ((linea = lector.readLine()) != null) {
				escritor.writeObject(linea); // Escribir cada línea
			}
		}
	}

	public static void fichero_Binario_To_CSV(String archivoBinario) {
		// Verificamos que el archivo tenga la extensión correcta.
		if (!archivoBinario.endsWith(".dat")) {
			throw new IllegalArgumentException(); // Verificación antes de procesar
		}
		// Generamos el nombre para el archivo CSV.
		String archivoCSV = archivoBinario.replace(".dat", "4.csv");

		try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(archivoBinario));
				BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoCSV))) {

			Object objeto;
			while ((objeto = lector.readObject()) != null) {
				// Escribimos cada objeto leído en el CSV como una línea de texto.
				escritor.write(objeto.toString());
				escritor.newLine();
			}
		} catch (EOFException e) {
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}
	}

	/**
	 * 
	 * @param ruta
	 * @return
	 */
	public static void ordenar_Archivo_CSV(String archivoCSV) {
		// Verificamos que el archivo tenga la extensión correcta.
		if (!archivoCSV.endsWith(".csv")) {
			throw new IllegalArgumentException("El archivo debe tener extensión .csv"); // Verificación antes de
																						// procesar
		}

		// Generamos el nombre para el archivo ordenado.
		String archivoOrdenado = archivoCSV.replace(".csv", "_ord.csv");

		// Lista para guardar cada línea del archivo
		List<String> lineas = new ArrayList<>();

		// Leer el archivo CSV
		try (BufferedReader lector = new BufferedReader(new FileReader(archivoCSV))) {
			String linea;
			while ((linea = lector.readLine()) != null) {
				lineas.add(linea); // Agregar cada línea a la lista
			}
		} catch (FileNotFoundException e) {
			System.err.println("El archivo no se encontró: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error al leer el archivo: " + e.getMessage());
		}

		// Ordenamos las líneas ignorando mayúsculas y minúsculas.
		Collections.sort(lineas, String.CASE_INSENSITIVE_ORDER);

		// Escribimos las líneas ordenadas en el nuevo archivo.
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoOrdenado))) {
			for (String linea : lineas) {
				escritor.write(linea);
				escritor.newLine(); // Agregar un salto de línea
			}
		} catch (IOException e) {
			System.err.println("Error al escribir en el archivo: " + e.getMessage());
		}
	}

	/**
	 * Metodo que lee el archivo guarda en lista ,ordena la lista y luego la escribe
	 * en el nuevo archivo _ord.bin
	 * 
	 * @param ruta
	 */
	public static void ordenar_Archivo_Binario(String archivoBinario) throws IOException {
		// Verificamos que el archivo tenga la extensión correcta.
		if (!archivoBinario.endsWith(".dat")) {
			throw new IllegalArgumentException(); // Verificación antes de procesar
		} // Generamos el nombre para el archivo ordenado
		String archivoOrdenado = archivoBinario.replace(".dat", "_ord.dat");

		List<String> lineas = new ArrayList<>();

		try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(archivoBinario))) {
			while (true) {
				// Almacenamos cada objeto como cadena de texto.
				lineas.add(lector.readObject().toString());
			}
		} catch (IOException | ClassNotFoundException e) {

			// Ordenamos las líneas ignorando mayúsculas y minúsculas.
			Collections.sort(lineas, String.CASE_INSENSITIVE_ORDER);

			try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(archivoOrdenado))) {
				for (String linea : lineas) {
					// Escribimos las líneas ordenadas en el archivo binario.
					escritor.writeObject(linea);
				}
			} catch (IOException e1) {

			}
		}
	}

	public static void fichero_Binario_To_CSV_Ordenado(String archivoBinario)
			throws IOException, ClassNotFoundException {
		// Verificamos que el archivo tenga la extensión correcta.
		if (!archivoBinario.endsWith(".dat")) {
			throw new IllegalArgumentException(); // Verificación antes de procesar
		}
		// Generamos el nombre para el archivo CSV ordenado.
		String archivoCSV = archivoBinario.replace(".dat", "_ord4.csv");

		List<String> lineas = new ArrayList<>();

		try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(archivoBinario))) {
			while (true) {
				// Almacenamos cada objeto como cadena de texto.
				lineas.add(lector.readObject().toString());
			}
		} catch (EOFException e) {

		}

		// Ordenamos las líneas ignorando mayúsculas y minúsculas.
		Collections.sort(lineas, String.CASE_INSENSITIVE_ORDER);

		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoCSV))) {
			for (String linea : lineas) {
				// Escribimos las líneas ordenadas en el archivo CSV.
				escritor.write(linea);
				escritor.newLine();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Inicio del programa...");

		try {

			System.out.println("Comprobando: fichero_CSV_To_Binario...");
			fichero_CSV_To_Binario("nuevo.csv");
			System.out.println("Conversión CSV a binario completada.");

			System.out.println("Comprobando: ordenar_Archivo_CSV...");
			ordenar_Archivo_CSV("nuevo.csv");
			System.out.println("Archivo CSV ordenado correctamente.");

			System.out.println("Comprobando: fichero_Binario_To_CSV...");
			fichero_Binario_To_CSV("nuevo.dat");
			System.out.println("Conversión binario a CSV completada.");

			System.out.println("Comprobando: ordenar_Archivo_Binario...");
			ordenar_Archivo_Binario("nuevo.dat");
			System.out.println("Archivo binario ordenado correctamente.");

			System.out.println("Comprobando: fichero_Binario_To_CSV_Ordenado...");
			fichero_Binario_To_CSV_Ordenado("nuevo.dat");
			System.out.println("Conversión y ordenación de binario a CSV completada.");

		} catch (Exception e) {
			System.err.println("Ocurrió un error durante la ejecución: " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("Programa finalizado.");
	}

}

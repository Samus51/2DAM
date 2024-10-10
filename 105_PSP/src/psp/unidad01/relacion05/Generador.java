package psp.unidad01.relacion05;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Generador {

	public static void main(String[] args) {

		generadorMethod();
	}

	/**
	 * 
	 */
	private static void generadorMethod() {
		String nombreArchivo = "Ejemplo2";
		List<String> lineas = new ArrayList<String>();
		String lin1 = "Hola este es un archivo de ejemplo";
		String lin2 = "fin del texto";
		lineas.add(lin1);
		lineas.add(lin2);

		File archivo = new File(nombreArchivo + ".txt");
		try (BufferedWriter entrada = new BufferedWriter(new FileWriter(archivo))) {
			for (int i = 0; i < lineas.size(); i++) {
				entrada.write(lineas.get(i));
				entrada.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Archivo creado y rellenado exitosamente");
	}
}

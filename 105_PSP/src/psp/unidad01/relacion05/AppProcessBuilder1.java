package psp.unidad01.relacion05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppProcessBuilder1 {

	public static void main(String[] args) {
		String origen = "C:\\Windows\\explorer.exe";
		String destino = "C:\\Users\\Alumnado2DAM\\eclipse-workspace\\105_PSP";

		ProcessBuilder pb = new ProcessBuilder("xcopy", origen, destino, "/Y");

		try {
			System.out.println("Copiando Fichero...");
			pb.start();
			System.out.println("Fichero Copiado con Éxito");
		} catch (IOException e) {
			// Mostrar detalles del error
			System.err.println("Error al copiar el fichero: " + e.getMessage());

		}
	}
}

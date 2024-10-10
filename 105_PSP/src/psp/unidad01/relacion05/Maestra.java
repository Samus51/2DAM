package psp.unidad01.relacion05;

import java.io.IOException;

public class Maestra {

	public static void main(String[] args) {

		ProcessBuilder ejecucion = new ProcessBuilder("java","-jar","Ejercicio02Generador.jar");
		try {
			ejecucion.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

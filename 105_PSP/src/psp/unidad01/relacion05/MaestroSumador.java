package psp.unidad01.relacion05;

import java.io.File;
import java.io.IOException;

public class MaestroSumador {

	public static void main(String[] args) {
		ProcessBuilder p1 = new ProcessBuilder();
		p1.command("java", "-jar", "sumador.jar");

		File numeros = new File("nums.txt");
		File resultado = new File("salida.txt");

		p1.redirectInput(numeros);
		p1.redirectOutput(resultado);

		try {
			p1.start();
			System.out.println("Proceso Realizado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

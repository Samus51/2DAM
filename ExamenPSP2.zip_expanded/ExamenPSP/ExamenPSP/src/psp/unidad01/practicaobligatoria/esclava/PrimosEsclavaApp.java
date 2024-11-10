package psp.unidad01.practicaobligatoria.esclava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrimosEsclavaApp {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			// Leer los valores desde la entrada estándar proporcionados por el maestro
			int inicioRango = Integer.parseInt(reader.readLine().trim());
			int finRango = Integer.parseInt(reader.readLine().trim());

			if (inicioRango > finRango) {
				System.out.println("El inicio del rango no puede ser mayor que el fin del rango.");
				return;
			}

			ArrayList<Integer> primos = new ArrayList<>();
			for (int num = inicioRango; num <= finRango; num++) {
				if (esPrimo(num)) {
					primos.add(num);
				}
			}

			// Imprimir los primos encontrados
			if (primos.isEmpty()) {
				System.out.println("No se encontraron primos en el rango.");
			} else {
				for (int i = 0; i < primos.size(); i++) {
					if (i < primos.size() - 1) {
						System.out.print(primos.get(i) + ", ");
					} else {
						System.out.print(primos.get(i));
					}
				}
				System.out.println();
			}

		} catch (Exception e) {
			System.err.println("Error al procesar los rangos: " + e.getMessage());
		}
	}

	// Método para verificar si un número es primo
	static boolean esPrimo(long numero) {
		if (numero == 2) {
			return true;
		}
		if (numero % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= numero; i += 2) {
			if (numero % i == 0) {
				return false;
			}
		}
		return true;
	}
}

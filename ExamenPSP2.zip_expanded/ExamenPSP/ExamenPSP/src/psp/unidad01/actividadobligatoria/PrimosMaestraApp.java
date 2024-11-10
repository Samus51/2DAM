package psp.unidad01.actividadobligatoria;

import java.io.*;
import java.util.*;

public class PrimosMaestraApp {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Uso: java -jar PrimosMaestraApp.jar <lim1> <lim2> [numCores]");
			System.exit(0);
		}

		int lim1 = Integer.parseInt(args[0]);
		int lim2 = Integer.parseInt(args[1]);
		int numCores = (args.length == 3) ? Integer.parseInt(args[2]) : 0;

		if (lim1 < 2 || lim1 > 2147483647 || lim2 < 2 || lim2 > 2147483647 || lim1 > lim2) {
			System.out.println("Enteros no válidos, valores válidos entre 2 y 2.147.483.647");
			mostrarUso();
			System.exit(0);
		}

		if (numCores == 0) {
			numCores = Runtime.getRuntime().availableProcessors();
		}

		int maxCores = Runtime.getRuntime().availableProcessors();

		if (numCores > maxCores) {
			System.out.println("Se solicitan más procesos que núcleos disponibles (" + maxCores + ") tiene el sistema");
			mostrarUso();
			System.exit(0);
		}

		if (numCores > lim2 - lim1 + 1) {
			System.out.println("Se solicitan más procesos que números se quieren analizar");
			mostrarUso();
			System.exit(0);
		}

		int numProcesos = Math.min(numCores, lim2 - lim1 + 1);
		int rangoPorProceso = (lim2 - lim1 + 1) / numProcesos;
		int sobrante = (lim2 - lim1 + 1) % numProcesos;

		ArrayList<Process> procesos = new ArrayList<>();
		Set<Integer> primos = new HashSet<>();
		long totalAnalizados = lim2 - lim1 + 1;

		long inicioTotal = System.currentTimeMillis();

		// Crear y lanzar los procesos
		for (int i = 0; i < numProcesos; i++) {
			long inicioRango = lim1 + i * rangoPorProceso;
			long finRango = inicioRango + rangoPorProceso - 1;

			if (i < sobrante) {
				finRango++;
			}

			if (inicioRango <= finRango) {
				try {
					ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp",
							"C:\\Users\\Pc\\Downloads\\ExamenPSP\\ExamenPSP\\bin",
							"psp.unidad01.practicaobligatoria.esclava.PrimosEsclavaApp", String.valueOf(inicioRango),
							String.valueOf(finRango));

					processBuilder.redirectOutput(ProcessBuilder.Redirect.PIPE);
					Process proceso = processBuilder.start();
					procesos.add(proceso);
				} catch (Exception e) {
					System.err.println("Error al iniciar el proceso esclavo: " + e.getMessage());
					System.exit(0);
				}
			}
		}

		// Esperar que los procesos terminen y leer los resultados
		for (int i = 0; i < procesos.size(); i++) {
			Process proceso = procesos.get(i);
			long inicioRango = lim1 + i * rangoPorProceso;
			long finRango = inicioRango + rangoPorProceso - 1;

			if (i < sobrante) {
				finRango++;
			}

			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
				String linea;
				Set<Integer> primosPorProceso = new HashSet<>();
				long inicioProceso = System.currentTimeMillis();

				while ((linea = reader.readLine()) != null) {
					for (String primo : linea.split(",")) {
						primo = primo.trim();
						if (!primo.isEmpty()) {
							try {
								int numeroPrimo = Integer.parseInt(primo);
								primosPorProceso.add(numeroPrimo);
							} catch (NumberFormatException e) {
							}
						}
					}
				}

				long finProceso = System.currentTimeMillis();
				long tiempoProceso = finProceso - inicioProceso;

				System.out.println("Proceso P" + i + " ha encontrado " + primosPorProceso.size() + " primos entre los "
						+ (finRango - inicioRango + 1) + " analizados. Tiempo de ejecución: " + tiempoProceso + " ms.");

				primos.addAll(primosPorProceso);
				proceso.waitFor();
			} catch (IOException | InterruptedException e) {
				System.err.println("Error al leer los resultados del proceso: " + e.getMessage());
				System.exit(0);
			}
		}

		long finTotal = System.currentTimeMillis();
		long tiempoTotal = finTotal - inicioTotal;

		System.out.println("Tiempo total empleado en el programa: " + tiempoTotal + " ms.");
		System.out.println("Se han encontrado " + primos.size() + " números primos entre los " + totalAnalizados
				+ " analizados, omitidos " + (totalAnalizados - primos.size()) + " pares.");

		List<Integer> listaPrimos = new ArrayList<>(primos);
		Collections.sort(listaPrimos);

		System.out.print("Lista ordenada de primos: ");
		for (int i = 0; i < listaPrimos.size(); i++) {
			System.out.print(listaPrimos.get(i));
			if (i < listaPrimos.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

	private static void mostrarUso() {
		System.out.println("USO:");
		System.out.println("Ingrese el primer extremo del rango (valor1) entre 2 y 2.147.483.647");
		System.out.println("Ingrese el segundo extremo del rango (valor2) entre 2 y 2.147.483.647");
		System.out.println("Ingrese el número de procesos (opcional, 0 para usar los núcleos disponibles)");
	}
}

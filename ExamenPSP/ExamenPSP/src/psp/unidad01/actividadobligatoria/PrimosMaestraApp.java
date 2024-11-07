package psp.unidad01.actividadobligatoria;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class PrimosMaestraApp {
    public static void main(String[] args) {
        // Comprobación de parámetros
        if (args.length < 2) {
            System.out.println("Insuficiente número de parámetros");
            mostrarUso();
            System.exit(1);
        }

        // Validación de parámetros
        long lim1 = 0, lim2 = 0, numCores = 0;
        try {
            lim1 = Long.parseLong(args[0]);
            lim2 = Long.parseLong(args[1]);

            // Comprobación de los valores dentro del rango válido
            if (lim1 < 2 || lim1 > 2147483647 || lim2 < 2 || lim2 > 2147483647 || lim1 > lim2) {
                System.out.println("Enteros no válidos, valores válidos entre 2 y 2.147.483.647");
                mostrarUso();
                System.exit(0);
            }

            // Verificar número de procesos (valor3, opcional)
            if (args.length == 3) {
                try {
                    numCores = Integer.parseInt(args[2]);
                    if (numCores <= 0) {
                        throw new NumberFormatException("El número de procesos debe ser positivo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("El valor del número de procesos no es positivo o no es un entero.");
                    mostrarUso();
                    System.exit(1);
                }
            } else {
                // Si no se especifica valor3, se usa el número de núcleos disponibles
                numCores = Runtime.getRuntime().availableProcessors();
            }

            int maxCores = Runtime.getRuntime().availableProcessors();

            // Comprobación de que el número de procesos no sea mayor que los núcleos disponibles
            if (numCores > maxCores) {
                System.out.println("Se solicitan más procesos que núcleos disponibles (" + maxCores + ") tiene el sistema");
                mostrarUso();
                System.exit(0);
            }

            // Verificar que no se pidan más procesos de los que el rango permite
            if (numCores > lim2 - lim1 + 1) {
                System.out.println("Se solicitan más procesos que números se quieren analizar");
                mostrarUso();
                System.exit(0);
            }

        } catch (NumberFormatException e) {
            System.err.println("Los parámetros deben ser números enteros válidos");
            mostrarUso();
            System.exit(0);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            mostrarUso();
            System.exit(0);
        }

        // Número de procesos a lanzar, no más que los núcleos disponibles
        int numProcesos = (int) Math.min(numCores, lim2 - lim1 + 1);

        // Dividir el rango entre los procesos
        long rangoPorProceso = (lim2 - lim1 + 1) / numProcesos;

        ArrayList<Process> procesos = new ArrayList<>();
        ArrayList<String> resultados = new ArrayList<>();

        long inicioTotal = System.currentTimeMillis(); // Agregar la medición de tiempo total

        // Lanzar los procesos esclavos
        for (int i = 0; i < numProcesos; i++) {
            long inicioRango = lim1 + i * rangoPorProceso;
            long finRango = (i == numProcesos - 1) ? lim2 : inicioRango + rangoPorProceso - 1;



            // Verificar que el rango no esté vacío
            if (inicioRango <= finRango) {
                ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp",
                        "C:\\Users\\Pc\\Downloads\\ExamenPSP\\ExamenPSP\\bin", // Ruta completa al directorio bin
                        "psp.unidad01.practicaobligatoria.esclava.PrimosEsclavaApp", String.valueOf(inicioRango),
                        String.valueOf(finRango));
                try {
                    long inicioProceso = System.currentTimeMillis();
                    Process proceso = processBuilder.start();
                    procesos.add(proceso);

                    // Esperar a que termine el proceso y obtener los resultados
                    BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                    String linea;
                    StringBuilder resultado = new StringBuilder();
                    while ((linea = reader.readLine()) != null) {
                        resultado.append(linea).append(",");
                    }
                    long finProceso = System.currentTimeMillis();
                    long tiempoProceso = finProceso - inicioProceso;

                    // Agregar la salida del proceso y el tiempo de ejecución
                    resultados.add("Proceso P" + i + " tiempo empleado: " + tiempoProceso + " ms. "
                            + "Se han encontrado: " + resultado.toString());
                } catch (Exception e) {
                    System.err.println("Error al iniciar el proceso esclavo: " + e.getMessage());
                    System.exit(1);
                }
            }
        }

        // Esperar a que todos los procesos terminen
        for (Process proceso : procesos) {
            try {
                proceso.waitFor(); // Espera a que termine el proceso
            } catch (InterruptedException e) {
                System.err.println("Error al esperar el proceso: " + e.getMessage());
            }
        }

        // Mostrar resultados
        long finTotal = System.currentTimeMillis();
        long tiempoTotal = finTotal - inicioTotal;

        System.out.println("Resultados de los procesos:");
        ArrayList<Integer> primos = new ArrayList<>();

        for (String resultado : resultados) {
            System.out.println(resultado); // Mostrar el tiempo y los primos encontrados por cada proceso

            // Separar los primos encontrados de cada proceso
            String[] primosEnRango = resultado.split(",");
            for (String primo : primosEnRango) {
                try {
                    primo = primo.trim();
                    if (!primo.isEmpty()) {
                        primos.add(Integer.parseInt(primo));
                    }
                } catch (NumberFormatException e) {
                    // Ignorar si no es un número válido
                }
            }
        }

        // Ordenar y mostrar la lista completa de primos
        Collections.sort(primos);
        System.out.println("Tiempo total de ejecución: " + tiempoTotal + " ms.");
        System.out.println(
                "Se han encontrado " + primos.size() + " primos entre los " + (lim2 - lim1 + 1) + " analizados.");
        System.out.print("Lista ordenada de primos: ");
        for (int i = 0; i < primos.size(); i++) {
            System.out.print(primos.get(i));
            if (i < primos.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(); // Para un salto de línea al final
    }

    // Función para mostrar el uso del programa
    private static void mostrarUso() {
        System.out.println("USO:");
        System.out.println("java -jar maestra.jar valor1 valor2 valor3");
        System.out.println(
                "valor1 -> (obligatorio) primer extremo del rango de valores a analizar (entre 2 y 2.147.483.647)");
        System.out.println(
                "valor2 -> (obligatorio) segundo extremo del rango de valores a analizar (entre 2 y 2.147.483.647)");
        System.out.println("valor3 -> (opcional) número de procesos a lanzar. Su equipo tiene "
                + Runtime.getRuntime().availableProcessors() + " núcleos");
    }
}

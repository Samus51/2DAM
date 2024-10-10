package psp.unidad01.ejercicio06;

import java.io.*;
import java.util.Scanner;

public class Maestro {
    
	public static void main(String[] args) {
        try {
            // Crear un proceso esclavo
            
        		ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", "C:\\Users\\Alumnado2DAM\\eclipse-workspace\\105_PSP\\bin", "psp.unidad01.ejercicio06.Esclavo");
            processBuilder.redirectErrorStream(true); // Redirige los errores al flujo de salida
            Process procesoEsclavo = processBuilder.start(); // Inicia el proceso esclavo
            
            // Configurar los streams de comunicación
            OutputStream esclavoEntrada = procesoEsclavo.getOutputStream(); // Flujo para enviar datos al esclavo
            InputStream esclavoSalida = procesoEsclavo.getInputStream(); // Flujo para recibir datos del esclavo
            
            BufferedReader lectorEsclavo = new BufferedReader(new InputStreamReader(esclavoSalida)); // Lee del esclavo
            PrintWriter escritorEsclavo = new PrintWriter(esclavoEntrada, true); // Escribe al esclavo, con auto-flush

            // Ciclo para pedir texto al usuario
            Scanner scanner = new Scanner(System.in);
            String texto;
            System.out.println("Introduce un texto (deja vacío para salir): ");
            
            while (true) {
                // Leer el texto del usuario
                texto = scanner.nextLine(); // Espera a que el usuario escriba algo
                
                // Si el usuario ingresa un texto vacío, se termina el programa
                if (texto.isEmpty()) {
                    break; // Salir del ciclo
                }
                
                // Enviar el texto al proceso esclavo
                escritorEsclavo.println(texto); // Envía el texto al esclavo
                
                // Leer y mostrar la respuesta del esclavo
                String respuesta = lectorEsclavo.readLine(); // Espera a que el esclavo responda
                System.out.println("Respuesta del esclavo: " + respuesta); // Muestra la respuesta
            }
            
            // Cerrar streams y proceso
            escritorEsclavo.close(); // Cierra el flujo de salida
            lectorEsclavo.close(); // Cierra el flujo de entrada
            procesoEsclavo.destroy(); // Termina el proceso esclavo

        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}

package psp.unidad01.ejercicio06;
import java.io.*;
import java.util.Random;

public class Esclavo {
    public static void main(String[] args) {
        try {
            BufferedReader lectorMaestro = new BufferedReader(new InputStreamReader(System.in)); // Lee del maestro
            PrintWriter escritorMaestro = new PrintWriter(System.out, true); // Escribe al maestro, con auto-flush

            Random random = new Random(); // Para seleccionar operaciones aleatorias
            String texto;

            // Leer el texto del proceso maestro y realizar una operación aleatoria
            while ((texto = lectorMaestro.readLine()) != null) {
                int operacion = random.nextInt(3); // Genera un número entre 0 y 2
                String resultado;

                switch (operacion) {
                    case 0: // Mayusculizar
                        resultado = texto.toUpperCase(); // Convierte a mayúsculas
                        break;
                    case 1: // Minusculizar
                        resultado = texto.toLowerCase(); // Convierte a minúsculas
                        break;
                    case 2: // Capitalizar
                        resultado = capitalizarTexto(texto); // Capitaliza el texto
                        break;
                    default:
                        resultado = texto; // Solo por seguridad
                }

                // Enviar el resultado al proceso maestro
                escritorMaestro.println(resultado); // Envía la respuesta al maestro
            }

        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores
        }
    }

    // Método para capitalizar el texto
    private static String capitalizarTexto(String texto) {
        String[] palabras = texto.toLowerCase().split(" "); 
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {
            if (palabra.length() > 0) {
                resultado.append(Character.toUpperCase(palabra.charAt(0))) 
                         .append(palabra.substring(1)) 
                         .append(" "); 
            }
        }
        return resultado.toString().trim(); 
    }
}

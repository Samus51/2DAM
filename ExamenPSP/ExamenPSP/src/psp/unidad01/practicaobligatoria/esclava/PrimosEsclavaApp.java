package psp.unidad01.practicaobligatoria.esclava;

import java.util.ArrayList;

public class PrimosEsclavaApp {
    public static void main(String[] args) {
        long inicioRango = Long.parseLong(args[0]);
        long finRango = Long.parseLong(args[1]);
        
        System.out.println("Comenzando a verificar primos entre " + inicioRango + " y " + finRango);
        
        ArrayList<Long> primos = new ArrayList<>();
        for (long num = inicioRango; num <= finRango; num++) {
            if (esPrimo(num)) {
                primos.add(num);
            }
        }
        
        if (primos.isEmpty()) {
            System.out.println("No se encontraron primos en el rango.");
        } else {
            // Imprimir primos separados por comas
            for (int i = 0; i < primos.size(); i++) {
                if (i < primos.size() - 1) {
                    System.out.print(primos.get(i) + ", ");  // Separados por coma
                } else {
                    System.out.print(primos.get(i));  // Último primo, sin coma
                }
            }
            System.out.println();  // Nueva línea al final
        }
    }

   static boolean esPrimo(long numero) {
        if (numero == 2) {
            return true; // El 2 es primo, porque es el único primo par
        }
        if (numero % 2 == 0) {
            return false; // Descarta los demás números pares
        }
        for (int i = 3; i * i <= numero; i += 2) { // Empezamos desde 3 e incrementamos de dos en dos para evitar pares
            if (numero % i == 0) {
                return false;
            }
        }
        return true; // Si no se divide por nada más, es primo
    }

}

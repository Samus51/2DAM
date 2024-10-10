package psp.unidad01.relacion05;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneradorModificado {
    public static void main(String[] args) {
        String nombreArchivo;
        if (args.length == 0 || args[0] == null) {
            nombreArchivo = "default";
        } else {
            nombreArchivo = args[0];
        }

        List<String> lineas = new ArrayList<>();
        String lin1 = "Hola este es un archivo de ejemplo";
        String lin2 = "fin del texto";
        lineas.add(lin1);
        lineas.add(lin2);

        File archivo = new File(nombreArchivo + ".txt");
        try (BufferedWriter entrada = new BufferedWriter(new FileWriter(archivo))) {
            for (String linea : lineas) {
                entrada.write(linea);
                entrada.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Archivo creado y rellenado exitosamente");
    }
}

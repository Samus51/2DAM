package hlc.ud03.examen.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BloqueDatosEnFichero implements BloqueDatos {

  private String rutaArchivo = null;
  Map<String, String> datos;
  
  public BloqueDatosEnFichero(String ruta) {
    this.rutaArchivo = ruta;
    datos = new HashMap<>();
    procesaFichero();
  }
  
  private void procesaFichero() {
    if (rutaArchivo == null) {
      throw new BloqueDatosException("No se ha proporcionado la ruta al archivo");
    }
    BufferedReader reader = null;
    // Limpia el buffer
    datos.clear();
    try {
      // Abre el archivo
      reader = new BufferedReader(new FileReader(rutaArchivo));
      // Para cada linea
      String linea = null;
      while ((linea = reader.readLine()) != null) {
        // Procesa la linea
        procesaLinea(linea.trim());
      }
    } catch (IOException | BloqueDatosException e) {
      // Limpia el buffer
      datos.clear();
      throw new BloqueDatosException(e);
    } finally {
      if (reader != null) {
        // Cierra el fichero
        try {
          reader.close();
        } catch (IOException e) {}
      }
    }
  }

  private void procesaLinea(String linea) {
    // Si la linea es válida
    if (linea.matches("\\w+=[^=]+")) {
      // Extrae la clave y el valor
      int indiceIgual = linea.indexOf('=');
      String clave = linea.substring(0, indiceIgual);
      String valor = linea.substring(indiceIgual + 1);
      // Si no hay colision
      if (datos.containsKey(clave)) {
        // Lanza una excepcion
        throw new BloqueDatosException("Hay un dato duplicado (" + clave + ") en el archivo");
      } else {
        // Guarda el dato
        datos.put(clave, valor);
      }
    }
  }

  @Override
  public boolean contieneDato(String nombre) {
    return datos.containsKey(nombre);
  }

  @Override
  public String getDato(String nombre) {
    return datos.get(nombre);
  }
}

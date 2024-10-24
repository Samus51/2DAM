package mainApp;

import java.util.ArrayList;
import models.Empleado;

public class MainApp extends utils.UtilsFicheroArray {

	public static void main(String[] args) {
    // Crear una lista de empleados y añadir algunos empleados de ejemplo
    ArrayList<Empleado> mana = new ArrayList<Empleado>();
    Empleado emp1 = new Empleado("Paco", 31, 1);
    Empleado emp2 = new Empleado("Pepe", 25, 2);
    Empleado emp3 = new Empleado("Manu", 43, 4);
    mana.add(emp1);
    mana.add(emp2);
    mana.add(emp3);

    // Mensaje inicial
    System.out.println("Iniciando el proceso...");

    // Guardar en archivo de texto
    System.out.println("Guardando empleados en archivo de texto 'empleados2.txt'...");
    empleadosToArray("src/utils/empleados2.txt");
    System.out.println("Empleados guardados en 'empleados2.txt'.\n");

    // Guardar la lista en archivo de texto vacío
    System.out.println("Guardando empleados en archivo de texto vacío 'empleados_vacio.txt'...");
    toArchivoTexto(mana, "src/utils/empleados_vacio.txt");
    System.out.println("Empleados guardados en 'empleados_vacio.txt'.\n");

    // Guardar en archivo binario inverso
    System.out.println("Guardando empleados en archivo binario 'binario_vacio.txt'...");
    toArchivoBinarioInverso(mana, "src/utils/binario_vacio.txt");
    System.out.println("Empleados guardados en 'binario_vacio.txt'.\n");

    // Leer empleados desde archivo de texto
    System.out.println("Leyendo empleados desde 'empleados2.txt'...");
    leerEmpleados("src/utils/empleados2.txt");
    System.out.println("Lectura de empleados desde 'empleados2.txt' completada.\n");

    // Leer empleados desde archivo binario
    System.out.println("Leyendo empleados desde 'empleados.bin'...");
    leerEmpleadosB("src/utils/empleados.bin");
    System.out.println("Lectura de empleados desde 'empleados.bin' completada.\n");

    // Mensaje final
    System.out.println("Proceso completo.");
}


}

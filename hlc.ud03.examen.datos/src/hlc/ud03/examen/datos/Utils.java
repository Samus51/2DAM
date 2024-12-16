package hlc.ud03.examen.datos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	public static void validarCorrecto(String rutaFichero) {
		if (comprobarReferencia(rutaFichero) && comprobarNombre(rutaFichero) && comprobarDoubles(rutaFichero)
				&& comprobarMarca(rutaFichero) && comprobarFecha(rutaFichero) && comprobarDominio(rutaFichero)
				&& comprobarUrl(rutaFichero) && comprobarEmail(rutaFichero)
				&& comprobarPuntosFuertesYDebiles(rutaFichero)) {
			System.out.println(rutaFichero + " , Válido");
		} else {
			System.out.println(rutaFichero + " , Inválido");
		}
	}

	
	public static void validarFicheros(String rutaFichero) {
		for (int i = 1; i <= 33; i++) {
			String numeroArchivo = String.format("%03d", i);
			String ruta = "datos_previos/conErrores/datos" + numeroArchivo + ".txt";

			// Aquí se hace la validación para cada archivo individualmente
			if (comprobarReferencia(ruta) && comprobarNombre(ruta) && comprobarDoubles(ruta) && comprobarMarca(ruta)
					&& comprobarFecha(ruta) && comprobarDominio(ruta) && comprobarUrl(ruta) && comprobarEmail(ruta)
					&& comprobarPuntosFuertesYDebiles(ruta)) {
				System.out.println(ruta + " , Válido");
			} else {
				System.out.println(ruta + " , Inválido");
			}
		}
	}

	private static boolean comprobarNombre(String rutaFichero) {
		BloqueDatosEnFichero bloque = new BloqueDatosEnFichero(rutaFichero);

		if (!bloque.contieneDato("nombre")) {
			return false;
		}
		String nombre = bloque.getDato("nombre");
		Pattern patron = Pattern.compile("([A-Za-z]{2,}\\s){1,2}[A-Z0-9]{2,4}");
		Matcher matcheador = patron.matcher(nombre);

		if (matcheador.matches()) {
			return true;
		} else {
			return false;
		}

	}

	private static void contieneObligatorios(String rutaFichero) {
		BloqueDatosEnFichero bloque = new BloqueDatosEnFichero(rutaFichero);

		if (!bloque.contieneDato("marca") || !bloque.contieneDato("referencia") || !bloque.contieneDato("precio")
				|| !bloque.contieneDato("correo_pedidos")) {
			throw new BloqueDatosException("El fichero " + rutaFichero + " no contiene los datos obligatorios");
		}
		System.out.println("Correcto");
	}

	private static boolean comprobarReferencia(String rutaFichero) {
		BloqueDatosEnFichero bloque = new BloqueDatosEnFichero(rutaFichero);
		if (!bloque.contieneDato("referencia")) {
			return false;
		}

		String referencia = bloque.getDato("referencia");
		if (!referencia.equals("3567578964321")) {
			return false;
		}
		return true;
	}

	private static boolean comprobarDoubles(String rutaFichero) {
		BloqueDatosEnFichero bloque = new BloqueDatosEnFichero(rutaFichero);

		if (!bloque.contieneDato("puntuacion") || !bloque.contieneDato("precio")) {
			return false;
		}

		String precio = bloque.getDato("precio");
		String puntuacion = bloque.getDato("puntuacion");

		if (precio.contains(",") || puntuacion.contains(",")) {
			return false;
		}

		String[] decimalesPrecio = precio.split("\\.");
		String[] decimalesPuntuacion = puntuacion.split("\\.");

		// Verifica que el precio tenga exactamente 2 decimales (si tiene punto)
		if (decimalesPrecio.length == 2 && decimalesPrecio[1].length() != 2) {
			return false; 
		}

		// Verifica que la puntuación tenga exactamente 1 decimal (si tiene punto)
		if (decimalesPuntuacion.length == 2 && decimalesPuntuacion[1].length() != 1) {
			return false; 
		}

		// Si no tiene punto, no hay decimales, lo que es válido
		if (decimalesPrecio.length == 1 || decimalesPuntuacion.length == 1) {
			return false; 
		}

		return true;
	}

	private static boolean comprobarPuntosFuertesYDebiles(String rutaFichero) {
		BloqueDatosEnFichero bloque = new BloqueDatosEnFichero(rutaFichero);

		String fuertes = bloque.getDato("puntos_fuertes");
		String debiles = bloque.getDato("puntos_debiles");

		List<String> valoresFuertes = List.of("Precio", "Tecnologia", "Durabilidad", "Disponibilidad", "Marca");
		List<String> valoresDebiles = List.of("Sostenible", "Calidad", "Tamaño", "Precio", "Tecnologia");

		List<String> fuertesHijos = Arrays.asList(fuertes.split(","));
		List<String> debilesHijos = Arrays.asList(debiles.split(","));

		if (tieneValoresRepetidos(fuertesHijos) || tieneValoresRepetidos(debilesHijos)) {
			return false;
		}

		if (!contieneExactamente(fuertesHijos, valoresFuertes) || !contieneExactamente(debilesHijos, valoresDebiles)) {
			return false;
		}

		return true;
	}

	// Método para comprobar valores repetidos en una lista
	private static boolean tieneValoresRepetidos(List<String> lista) {
		for (String valor : lista) {
			if (Collections.frequency(lista, valor) > 1) {
				return true;
			}
		}
		return false;
	}

	// Método para comprobar que una lista contiene exactamente los valores
	// esperados
	private static boolean contieneExactamente(List<String> lista, List<String> valoresEsperados) {
		if (lista.size() != valoresEsperados.size()) {
			return false;
		}
		for (String valor : valoresEsperados) {
			if (!lista.contains(valor)) {
				return false;
			}
		}
		return true;
	}

	private static boolean comprobarMarca(String rutaFichero) {
		BloqueDatosEnFichero bloque = new BloqueDatosEnFichero(rutaFichero);
		if (!bloque.contieneDato("marca") || !bloque.contieneDato("nombre")) {
			System.out.println("No existe el valor Marca o Nombre");
			return false;
		} else {
			String nombre = bloque.getDato("nombre");
			String[] marcaNombre = nombre.split(" ");
			String marcaReal = marcaNombre[1];

			String marca = bloque.getDato("marca");
			if (marca.equals(marcaReal)) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static boolean comprobarFecha(String rutaFichero) {
		BloqueDatosEnFichero bloque = new BloqueDatosEnFichero(rutaFichero);

		if (!bloque.contieneDato("fecha_inicio_venta")) {
			return false;
		}

		String fecha = bloque.getDato("fecha_inicio_venta");

		// Expresión regular para comprobar el formato dd/mm/yyyy
		String regex = "^([0-2][0-9]|(3)[0-1])/(0[1-9]|1[0-2])/(\\d{4})$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(fecha);

		if (!matcher.matches()) {
			return false;
		}

		String[] partes = fecha.split("/");
		int dia = Integer.parseInt(partes[0]);
		int mes = Integer.parseInt(partes[1]);
		int anio = Integer.parseInt(partes[2]);

		// Verifica si el día es válido según el mes
		if (mes == 4 || mes == 6 || mes == 9 || mes == 11) { // Meses con 30 días
			if (dia > 30) {
				return false;
			}
		} else if (mes == 2) { 
			if (dia > 28) {
				return false;
			}
		} else { // Meses con 31 días
			if (dia > 31) {
				return false;
			}
		}

		if (anio < 1900 || anio > 2100) {
			return false;
		}

		return true;
	}

	private static boolean comprobarEmail(String rutaFichero) {
		BloqueDatosEnFichero bloque = new BloqueDatosEnFichero(rutaFichero);

		if (!bloque.contieneDato("correo_pedidos")) {
			return false;
		}

		String correo = bloque.getDato("correo_pedidos");

		if (correo.matches("[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
			return true;
		} else {
			return false;
		}

	}

	private static boolean comprobarUrl(String rutaFichero) {
		BloqueDatosEnFichero bloque = new BloqueDatosEnFichero(rutaFichero);

		if (!bloque.contieneDato("url")) {
			return false;
		}

		String url = bloque.getDato("url");
		Pattern patron = Pattern.compile("^http://www\\..+\\.[a-zA-Z0-9_-]+/$");
		Matcher matcher = patron.matcher(url);

		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean comprobarDominio(String rutaFichero) {
		BloqueDatosEnFichero bloque = new BloqueDatosEnFichero(rutaFichero);

		if (!bloque.contieneDato("dominio")) {
			return false;
		}

		String dominio = bloque.getDato("dominio");
		Pattern patron = Pattern.compile("^www\\.[a-zA-Z]{1,63}\\.[a-zA-Z]{2,}");
		Matcher matcher = patron.matcher(dominio);

		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

}

package rawg.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import utils.rawg.Conexion;
import utils.rawg.Developer;
import utils.rawg.Genero;
import utils.rawg.Juego;
import utils.rawg.Plataforma;
import utils.rawg.PlataformaPadre;

public class Volcado {

	private static final String API_URL_JUEGOS = "https://api.rawg.io/api/games?key=b468c1c7580c4f269ba2638debdf4c84&page_size=20";
	private static final String API_URL_1JUEGO = "https://api.rawg.io/api/games/3497?key=b468c1c7580c4f269ba2638debdf4c84";

	public static void main(String[] args) {

		System.out.println(getJuego().getName());
	}

	public static List<Juego> getJuegos() {
		List<Juego> listaJuegos = new ArrayList<>();

		try {
			URI uri = new URI(API_URL_JUEGOS);
			URL url = uri.toURL();
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			System.out.println("Código de Conexión: " + connection.getResponseCode());

			if (connection.getResponseCode() == 200) {
				BufferedReader entradaApi = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder response = new StringBuilder();
				String line;

				while ((line = entradaApi.readLine()) != null) {
					response.append(line);
				}
				entradaApi.close();
				JSONObject objetoJSON = new JSONObject(response.toString());
				JSONArray juegosArray = objetoJSON.getJSONArray("results");

				// Obtener listas de desarrolladores, géneros y plataformas
			//	List<Developer> listaDevs = getListaDevs();
				List<Genero> listaGeneros = getListaGeneros();
				List<PlataformaPadre> listaPlataformasPadres = getGrupoPlataformas();

				for (int i = 0; i < juegosArray.length(); i++) {
					JSONObject juegoJSON = juegosArray.getJSONObject(i);

					String nombre = juegoJSON.optString("name", "Nombre no disponible");
					String descripcion = juegoJSON.optString("description", "Descripción no disponible");
					String fechaLanzamiento = juegoJSON.optString("released", "No disponible");
					int tiempoDeJuego = juegoJSON.optInt("playtime", 0);

					// Obtener el ID del desarrollador
					int idDesarrollador = -1;
					/*
					 * if (juegoJSON.has("developers") && juegoJSON.get("developers") instanceof
					 * JSONArray) { JSONArray developers = juegoJSON.getJSONArray("developers"); if
					 * (developers.length() > 0) { String nombreDev =
					 * developers.getJSONObject(0).optString("name", ""); for (Developer dev :
					 * listaDevs) { if (dev.getName_dev().equalsIgnoreCase(nombreDev)) {
					 * idDesarrollador = dev.getId_dev(); break; } } } }
					 */

					// Obtener el ID del género
					int idGenero = -1;
					if (juegoJSON.has("genres") && juegoJSON.get("genres") instanceof JSONArray) {
						JSONArray generos = juegoJSON.getJSONArray("genres");
						if (generos.length() > 0) {
							String nombreGenero = generos.getJSONObject(0).optString("name", "");
							for (Genero genero : listaGeneros) {
								if (genero.getNombre().equalsIgnoreCase(nombreGenero)) {
									idGenero = genero.getId_genero();
									break;
								}
							}
						}
					}

					// Obtener el ID de la plataforma
					int idPlataforma = -1;
					if (juegoJSON.has("platforms") && juegoJSON.get("platforms") instanceof JSONArray) {
						JSONArray plataformas = juegoJSON.getJSONArray("platforms");
						if (plataformas.length() > 0) {
							String nombrePlataforma = plataformas.getJSONObject(0).getJSONObject("platform")
									.optString("name", "");
							for (PlataformaPadre plataformaPadre : listaPlataformasPadres) {
								for (Plataforma plataformaHijo : plataformaPadre.getPlataformas()) {
									if (plataformaHijo.getNombre().equalsIgnoreCase(nombrePlataforma)) {
										idPlataforma = plataformaHijo.getId_plataforma();
										break;
									}
								}
							}
						}
					}

					// Crear el objeto Juego
					Juego juego = new Juego(nombre, descripcion, fechaLanzamiento, -1, idGenero,
							idPlataforma, false, // creadoPorUsuario
							-1, // idUsuario (por defecto -1)
							tiempoDeJuego);

					// Agregar el juego a la lista
					listaJuegos.add(juego);
				}
			}
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Volcado Exitoso");
		}

		return listaJuegos;
	}

	public static Juego getJuego() {
    Juego juego = null;
    try {
        URI uri = new URI(API_URL_1JUEGO);
        URL url = uri.toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        System.out.println("Código de Conexión: " + connection.getResponseCode());

        if (connection.getResponseCode() == 200) {
            BufferedReader entradaApi = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = entradaApi.readLine()) != null) {
                response.append(line);
            }
            entradaApi.close();
            JSONObject juegoJSON = new JSONObject(response.toString());

            String nombre = juegoJSON.optString("name", "Nombre no disponible");
            String descripcion = juegoJSON.optString("description", "Descripción no disponible");
            String fechaLanzamiento = juegoJSON.optString("released", "No disponible");
            int tiempoDeJuego = juegoJSON.optInt("playtime", 0);

            // Obtener listas de generos y plataformas
            List<Genero> listaGeneros = getListaGeneros();
            List<PlataformaPadre> listaPlataformasPadres = getGrupoPlataformas();

            // Obtener el ID del desarrollador
            int idDesarrollador = -1;
            if (juegoJSON.has("developers") && juegoJSON.get("developers") instanceof JSONArray) {
                JSONArray developers = juegoJSON.getJSONArray("developers");
                if (developers.length() > 0) {
                    String nombreDev = developers.getJSONObject(0).optString("name", "");
                    idDesarrollador = developers.getJSONObject(0).optInt("id", 404);
                    System.out.println("Developer Name: " + nombreDev);
                    System.out.println("Id Developer: " + idDesarrollador);
                }
            }

            // Obtener el ID del género
            int idGenero = -1;
            if (juegoJSON.has("genres") && juegoJSON.get("genres") instanceof JSONArray) {
                JSONArray generos = juegoJSON.getJSONArray("genres");
                if (generos.length() > 0) {
                    String nombreGenero = generos.getJSONObject(0).optString("name", "");
                    for (Genero genero : listaGeneros) {
                        if (genero.getNombre().equalsIgnoreCase(nombreGenero)) {
                            idGenero = genero.getId_genero();
                            break;
                        }
                    }
                }
            }

            // Obtener las plataformas y almacenarlas en una lista
            List<Plataforma> plataformasList = new ArrayList<>();
            if (juegoJSON.has("platforms") && juegoJSON.get("platforms") instanceof JSONArray) {
                JSONArray plataformas = juegoJSON.getJSONArray("platforms");
                for (int i = 0; i < plataformas.length(); i++) {
                    String nombrePlataforma = plataformas.getJSONObject(i).getJSONObject("platform").optString("name", "");
                    int idPlataforma = plataformas.getJSONObject(i).getJSONObject("platform").optInt("id", 404);

                    // Crear un objeto Plataforma con los datos obtenidos
                    Plataforma plataforma = new Plataforma(idPlataforma, nombrePlataforma);

                    // Añadir la plataforma a la lista
                    plataformasList.add(plataforma);
                }
            }

            // Crear el objeto Juego, pasando la lista de plataformas
            juego = new Juego(nombre, descripcion, fechaLanzamiento, idDesarrollador, idGenero, plataformasList, false, // creadoPorUsuario
                    -1, // idUsuario (por defecto -1)
                    tiempoDeJuego);
        }
    } catch (URISyntaxException | IOException e) {
        e.printStackTrace();
    }

    return juego;
}

	private static List<PlataformaPadre> getGrupoPlataformas() {
		String PlataformasPadreUri = "https://api.rawg.io/api/platforms/lists/parents?key=b468c1c7580c4f269ba2638debdf4c84";
		List<PlataformaPadre> listaPlataformasPadres = new ArrayList<>();

		try {
			URL urlPlataformas = new URI(PlataformasPadreUri).toURL();
			HttpURLConnection plataformasConnection = (HttpURLConnection) urlPlataformas.openConnection();
			plataformasConnection.setRequestMethod("GET");

			if (plataformasConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				try (BufferedReader entradaApi = new BufferedReader(
						new InputStreamReader(plataformasConnection.getInputStream()))) {

					StringBuilder response = new StringBuilder();
					String line;
					while ((line = entradaApi.readLine()) != null) {
						response.append(line);
					}

					JSONObject objetoJSON = new JSONObject(response.toString());
					JSONArray plataformasArray = objetoJSON.getJSONArray("results");

					for (int i = 0; i < plataformasArray.length(); i++) {
						JSONObject parentPlatform = plataformasArray.getJSONObject(i);
						int idParent = parentPlatform.getInt("id");
						String nameParent = parentPlatform.getString("name");
						JSONArray plataformasHijoArray = parentPlatform.getJSONArray("platforms");

						List<Plataforma> plataformasHijo = new ArrayList<>();
						for (int j = 0; j < plataformasHijoArray.length(); j++) {
							JSONObject plataformaHijoJSON = plataformasHijoArray.getJSONObject(j);
							int idPlataforma = plataformaHijoJSON.getInt("id");
							String nombrePlataforma = plataformaHijoJSON.getString("name");

							Plataforma plataformaHijo = new Plataforma(idPlataforma, nombrePlataforma);
							plataformasHijo.add(plataformaHijo);
						}

						PlataformaPadre plataformaPadre = new PlataformaPadre(idParent, nameParent, plataformasHijo);
						listaPlataformasPadres.add(plataformaPadre);
					}
				}
			} else {
				System.err.println("Error en la conexión: Código HTTP " + plataformasConnection.getResponseCode());
			}

		} catch (URISyntaxException | MalformedURLException e) {
			System.err.println("Error de URL: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error de I/O: " + e.getMessage());
		}

		return listaPlataformasPadres;
	}

	private static List<Genero> getListaGeneros() throws IOException {
		List<Genero> listaGenero = new ArrayList<>();
		String generosUrl = "https://api.rawg.io/api/genres?key=b468c1c7580c4f269ba2638debdf4c84";
		HttpURLConnection generosConnection = null;

		try {
			generosConnection = (HttpURLConnection) new URI(generosUrl).toURL().openConnection();
			generosConnection.setRequestMethod("GET");

			if (generosConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				try (BufferedReader entradaApi = new BufferedReader(
						new InputStreamReader(generosConnection.getInputStream()))) {

					StringBuilder response = new StringBuilder();
					String line;
					while ((line = entradaApi.readLine()) != null) {
						response.append(line);
					}

					JSONObject objetoJSON = new JSONObject(response.toString());
					if (objetoJSON.has("results")) {
						JSONArray generosArray = objetoJSON.getJSONArray("results");

						for (int i = 0; i < generosArray.length(); i++) {
							JSONObject genero = generosArray.getJSONObject(i);
							String nombreGenero = genero.getString("name");
							int idGenero = genero.getInt("id");

							Genero gen = new Genero(idGenero, nombreGenero);
							listaGenero.add(gen);
						}
					}
				}
			} else {
				System.err.println("Error en la conexión: Código HTTP " + generosConnection.getResponseCode());
			}

		} catch (MalformedURLException | URISyntaxException e) {
			throw new IOException("Error en la URL o URI: " + e.getMessage(), e);
		} catch (IOException e) {
			throw new IOException("Error de I/O al obtener los géneros: " + e.getMessage(), e);
		} finally {
			if (generosConnection != null) {
				generosConnection.disconnect();
			}
		}

		return listaGenero;
	}

	public static List<Developer> getListaDevs() throws IOException {
	    List<Developer> listaDevs = new ArrayList<>();
	    String devsUrl = "https://api.rawg.io/api/developers?key=b468c1c7580c4f269ba2638debdf4c84&page_size=500";
	    HttpURLConnection devConnection = null;

	    long startTime = System.currentTimeMillis(); // Tiempo de inicio

	    try {
	        while (devsUrl != null) { // Mientras haya más páginas
	            devConnection = (HttpURLConnection) new URI(devsUrl).toURL().openConnection();
	            devConnection.setRequestMethod("GET");

	            if (devConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
	                try (BufferedReader entradaApi = new BufferedReader(new InputStreamReader(devConnection.getInputStream()))) {
	                    StringBuilder response = new StringBuilder();
	                    String line;
	                    while ((line = entradaApi.readLine()) != null) {
	                        response.append(line);
	                    }

	                    JSONObject objetoJSON = new JSONObject(response.toString());
	                    if (objetoJSON.has("results")) {
	                        JSONArray devsArray = objetoJSON.getJSONArray("results");

	                        for (int i = 0; i < devsArray.length(); i++) {
	                            JSONObject dev = devsArray.getJSONObject(i);
	                            String nombreDev = dev.getString("name");
	                            int idDev = dev.getInt("id");

	                            Developer dev1 = new Developer(idDev, nombreDev);
	                            listaDevs.add(dev1);
	                        }
	                    }

	                    // Obtener la URL de la siguiente página, si existe
	                    devsUrl = objetoJSON.optString("next", null);

	                    // Mostrar el tiempo transcurrido en cada página en segundos
	                    long elapsedTime = (System.currentTimeMillis() - startTime) / 1000; // Tiempo transcurrido en segundos
	                    System.out.println("Tiempo transcurrido hasta ahora: " + elapsedTime + " segundos.");
	                }
	            } else {
	                System.err.println("Error en la conexión: Código HTTP " + devConnection.getResponseCode());
	                break;
	            }
	        }
	    } catch (MalformedURLException | URISyntaxException e) {
	        throw new IOException("Error en la URL o URI: " + e.getMessage(), e);
	    } catch (IOException e) {
	        throw new IOException("Error de I/O al obtener los desarrolladores: " + e.getMessage(), e);
	    } finally {
	        if (devConnection != null) {
	            devConnection.disconnect();
	        }
	    }

	    // Después de obtener todos los desarrolladores, volcar los datos a la base de
	    // datos
	    volcarDevsABBDD(listaDevs);

	    long totalTime = (System.currentTimeMillis() - startTime) / 1000; // Tiempo total en segundos
	    System.out.println("Tiempo total de ejecución: " + totalTime + " segundos.");

	    return listaDevs;
	}


	private static void volcarDevsABBDD(List<Developer> listaDevs) {
	    String sql = "INSERT INTO desarrolladores (id_desarrollador, nombre) VALUES (?, ?)";
	    int totalDevs = listaDevs.size();
	    try (Connection conezion = Conexion.conectar(); PreparedStatement pstmt = conezion.prepareStatement(sql)) {
	        
	        conezion.setAutoCommit(false);  // Desactivar auto-commit
	        int count = 0;
	        
	        for (Developer dev : listaDevs) {
	            pstmt.setInt(1, dev.getId_dev());
	            pstmt.setString(2, dev.getName_dev());
	            pstmt.addBatch();  // Añadir cada insert a un lote
	            
	            if (++count % 500 == 0) { 
	                pstmt.executeBatch();
	                pstmt.clearBatch();
	                System.out.println("Insertados " + count + " de " + totalDevs + " desarrolladores.");
	            }
	        }
	        
	        pstmt.executeBatch(); // Ejecutar el batch final
	        conezion.commit();    // Confirmar todos los cambios
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}

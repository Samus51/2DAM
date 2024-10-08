import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ad.swing.Films;

/**
 * film_id smallint UN AI PK title varchar(128) description text release_year
 * year
 */
public class MainApp {
	private static final String SQL_SELECT_ALL = "Select *, film_actor.*,film.* from actor \r\n"
			+ "inner join film_actor on film_actor.actor_id = actor.actor_id\r\n"
			+ "inner join film on film_actor.film_id = film.film_id;";

	public static void main(String[] args) {
		List<Films> listaPelis = new ArrayList<Films>();
		try {
			Connection conexion = Conector.conectar();
			PreparedStatement sentencia = conexion.prepareStatement(SQL_SELECT_ALL);
			ResultSet rs = sentencia.executeQuery();
			while (rs.next()) {
				System.out.println("ID_Actor: " + rs.getInt(1) + "\n");
				System.out.println("Actor_Name: " + rs.getString(2) + "\n");
				System.out.println("Film Title: " + rs.getString(9) + "\n");
				System.out.println("Release Year: " + rs.getInt(11) + "\n");
				System.out.println("-------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace(); // Mostrar la excepción para facilitar la depuración
		}

	}
}

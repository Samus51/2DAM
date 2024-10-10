package ad.jdbc.ejercicio03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainApp {

	private static final String SQL_INSERT_PROFESOR = "INSERT INTO profesor(NIF_P,Nombre,Especialidad,Telefono) VALUES (?,?,?,?)";
	private static final String SQL_INSERT_ASIGNATURA = "INSERT INTO asignatura(CodAsignatura,Nombre,IdProfesor) VALUES (?,?,?)";

	public static void toArchivoTextoList(String fichero) {

		try (Connection Conecter = Conexion.conectar();) {
			String linea;
			int idProfesor = 20;
			try (BufferedReader entrada = new BufferedReader(new FileReader(fichero))) {
				Conecter.setAutoCommit(false);

				while ((linea = entrada.readLine()) != null) {
					String[] datos = linea.replace("\"", "").split(";");

					if (datos[0].equals("Profesor")) {
						PreparedStatement sentencia = Conecter.prepareStatement(SQL_INSERT_PROFESOR,
								PreparedStatement.RETURN_GENERATED_KEYS);
						sentencia.setString(1, datos[1]);
						sentencia.setString(2, datos[2]);
						sentencia.setString(3, datos[3]);
						sentencia.setString(4, datos[4]);

						sentencia.executeUpdate();

						ResultSet rs = sentencia.getGeneratedKeys();
						if (rs.next()) {
							idProfesor = rs.getInt(1);
						}

					} else if (datos[0].equals("Asignatura") && idProfesor != 20) {
						PreparedStatement sentencia = Conecter.prepareStatement(SQL_INSERT_ASIGNATURA);
						sentencia.setString(1, datos[1]);
						sentencia.setString(2, datos[2]);
						sentencia.setInt(3, idProfesor);
						sentencia.executeUpdate();
					}
				}
				Conecter.commit();

			} catch (IOException | SQLException e) {
				e.printStackTrace();
				try {
					Conecter.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

	public static void main(String[] args) {
		toArchivoTextoList("info.csv");
	}
}

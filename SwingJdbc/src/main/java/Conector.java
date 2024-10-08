

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conector {
	private static final String URL = "jdbc:mysql://localhost:3306/";
  private static final String BBDD = "sakila";
//  private static final String PARAMETROS = "?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
  private static final String PARAMETROS = "?serverTimezone=UTC";
  private static final String USUARIO = "root";
  private static final String CLAVE = "1234";

  public static Connection conectar() {
      Connection conexion = null;
      
      try {
          conexion = DriverManager.getConnection(URL+BBDD+PARAMETROS, USUARIO, CLAVE);
          System.out.println("Conexion Exitosa");
      } catch (SQLException e) {
          System.out.println("Error en la conexion");
          e.printStackTrace();
      }
      
      return conexion;
  }


public static void main(String[] args) {

	}

}

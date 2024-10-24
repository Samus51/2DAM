package mainApp;

import java.util.ArrayList;
import java.util.List;

import modelos.Usuario;
import vistas.Login;

public class App {

	public static List<Usuario> listUsers;

	public static void main(String[] args) {
		listUsers = new ArrayList<Usuario>();

		Login ventanalogin = new Login();
		ventanalogin.setVisible(true);

	}

}

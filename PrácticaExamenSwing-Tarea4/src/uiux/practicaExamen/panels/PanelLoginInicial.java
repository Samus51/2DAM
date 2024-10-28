package uiux.practicaExamen.panels;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;

public class PanelLoginInicial extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;

	/**
	 * Create the panel.
	 */
	public PanelLoginInicial() {
		setBackground(new Color(175, 238, 238));
		setLayout(null);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUser.setForeground(new Color(65, 105, 225));
		lblUser.setBounds(24, 40, 46, 14);
		add(lblUser);
		
		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setForeground(new Color(65, 105, 225));
		lblPassword.setBounds(24, 74, 67, 14);
		add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(80, 37, 131, 20);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(101, 71, 131, 20);
		add(txtPassword);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.setBounds(101, 102, 113, 23);
		btnIniciarSesion.setBackground(new Color(30, 144, 255)); // Color rosa fuerte
		btnIniciarSesion.setForeground(Color.WHITE); // Color del texto blanco
		btnIniciarSesion.setOpaque(true); // Hacer el botón opaco
		btnIniciarSesion.setContentAreaFilled(true); // Llenar el área de contenido con el color de fondo
		btnIniciarSesion.setFocusPainted(false); // Elimina el borde de enfoque cuando se hace clic
		btnIniciarSesion.setBorderPainted(false); // Quitar borde del botón

		add(btnIniciarSesion);
		
		JButton btnLogin = new JButton("Pulse aquí para Registrarse");
		btnLogin.setBackground(new Color(30, 144, 255)); // Color rosa fuerte
		btnLogin.setForeground(Color.WHITE); // Color del texto blanco
		btnLogin.setOpaque(true); // Hacer el botón opaco
		btnLogin.setContentAreaFilled(true); // Llenar el área de contenido con el color de fondo
		btnLogin.setFocusPainted(false); // Elimina el borde de enfoque cuando se hace clic
		btnLogin.setBorderPainted(false); // Quitar borde del botón

		btnLogin.setBounds(101, 136, 198, 23);
		add(btnLogin);

	}
}

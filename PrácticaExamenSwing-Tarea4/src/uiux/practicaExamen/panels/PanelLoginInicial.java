package uiux.practicaExamen.panels;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import uiux.practicaExamen.VentanaLogin;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;

public class PanelLoginInicial extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	VentanaLogin pantallaPrincipal;

	/**
	 * Create the panel.
	 */
	public PanelLoginInicial(JFrame parent, boolean modal) {
		pantallaPrincipal = (VentanaLogin) parent;

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
		btnIniciarSesion.setBackground(new Color(30, 144, 255));
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setOpaque(true);
		btnIniciarSesion.setContentAreaFilled(true);
		btnIniciarSesion.setFocusPainted(false);
		btnIniciarSesion.setBorderPainted(false);

		add(btnIniciarSesion);

		JButton btnLogin = new JButton("Pulse aquí para Registrarse");
		btnLogin.setBackground(new Color(30, 144, 255));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setOpaque(true);
		btnLogin.setContentAreaFilled(true);
		btnLogin.setFocusPainted(false);
		btnLogin.setBorderPainted(false);

		btnLogin.setBounds(101, 136, 198, 23);
		add(btnLogin);

	}
}

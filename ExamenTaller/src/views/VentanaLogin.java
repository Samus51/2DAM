package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Launcher;
import models.Empleado;
import models.Usuario;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCrearCuenta;
	private JTextField txtUsuario;
	private JButton btnIniciarSesion;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Talleres Picasso");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setIcon(new ImageIcon(VentanaLogin.class.getResource("/resources/cocheAzul.png")));
		panel.add(lblNewLabel);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(135, 206, 250));
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(3, 2, 0, 30));

		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_2);

		txtUsuario = new JTextField();
		panel_4.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Contraseña");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_3);

		passwordField = new JPasswordField();
		panel_4.add(passwordField);

		lblCrearCuenta = new JLabel("¿No tienes Cuenta?");
		lblCrearCuenta.setForeground(new Color(0, 0, 255));
		lblCrearCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCrearCuenta.setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblCrearCuenta.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				abrirRegistro();
			}
		});
		lblCrearCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblCrearCuenta);

		btnIniciarSesion = new JButton("Iniciar Sesión");
		btnIniciarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIniciarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnIniciarSesion.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				iniciarSesion();
			}
		});
		panel_4.add(btnIniciarSesion);
	}

	protected void iniciarSesion() {
	    String email = txtUsuario.getText();
	    String contraseña = new String(passwordField.getPassword());
	    boolean usuarioEncontrado = false;

	    for (Usuario clienteLogueado : Launcher.lstClientes) {
	        if (clienteLogueado.getEmail().equals(email) && clienteLogueado.getContraseña().equals(contraseña)) {
	            usuarioEncontrado = true;
	            dispose();
	            HomeCliente home = new HomeCliente(clienteLogueado);
	            home.setVisible(true);
	            break;
	        }
	    }
	    
	    for (Empleado empleadoLogueado : Launcher.lstEmpleados) {
	        if (empleadoLogueado.getEmail().equals(email) && empleadoLogueado.getContraseña().equals(contraseña)) {
	            usuarioEncontrado = true;
	            dispose();
	            HomeEmpleado home = new HomeEmpleado(empleadoLogueado);
	            home.setVisible(true);
	            break;
	        }
	    }

	    if (!usuarioEncontrado) {
	        JOptionPane.showMessageDialog(null, "El usuario es incorrecto o no existe", "Error",
	                                      JOptionPane.ERROR_MESSAGE);
	    }
	}

	protected void abrirRegistro() {

		Registro reg = new Registro();
		reg.setVisible(true);
	}

}

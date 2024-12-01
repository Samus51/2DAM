package examen.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import examen.mainApp.Launcher;
import models.Usuario;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField passwordField;
	private JLabel lblCuenta;
	private JButton btnSesion;

	/**
	 * Create the frame.
	 */
	public VentanaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 408);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(30, 144, 255));
		contentPane.add(panel_3, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaLogin.class.getResource("/utils/Logo.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel);

		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new MigLayout("", "[188px][188px,grow]", "[76px][76px][76px]"));

		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_2, "cell 0 0,grow");

		txtUser = new JTextField();
		txtUser.setPreferredSize(new Dimension(20, 20));
		txtUser.setHorizontalAlignment(SwingConstants.LEFT);
		panel_4.add(txtUser, "cell 1 0,growx,aligny center");
		txtUser.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1, "cell 0 1,alignx center,growy");

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		panel_4.add(passwordField, "cell 1 1,growx");

		lblCuenta = new JLabel("¿No tienes Cuenta?");
		lblCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				crearCuenta();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				cambiarRatonHand();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				cambiarRatonDefault();
			}
		});
		lblCuenta.setForeground(new Color(0, 0, 255));
		lblCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblCuenta, "cell 0 2,grow");

		btnSesion = new JButton("Login");
		btnSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				iniciarSesion();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				entrarRaton();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				salirRaton();
			}
		});
		panel_4.add(btnSesion, "cell 1 2,growx,aligny center");
	}

	protected void salirRaton() {
		btnSesion.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	protected void entrarRaton() {
		btnSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));

	}

	protected void iniciarSesion() {
	    String email = txtUser.getText();
	    String pass = new String(passwordField.getPassword());

	    for (Usuario us1 : Launcher.lstUsuarios) {
	        if (email.equals(us1.getEmail()) && pass.equals(us1.getPass())) {
	            if (us1.getEsEntrenador()) {
	                this.dispose();
	                HomeEntrenador home = new HomeEntrenador(us1);
	                home.setVisible(true);
	                System.out.println("Entrenador");
	                System.out.println();
	            } else {
	                this.dispose();
	                HomeJugador home = new HomeJugador(us1);
	                home.setVisible(true);
	                System.out.println("Jugador");
	            }
	            return;
	        }
	    }

	    // Si no encontró ningún usuario válido
	    JOptionPane.showMessageDialog(null, "El usuario es incorrecto o no existe", "Error",
	            JOptionPane.ERROR_MESSAGE);
	}
	protected void cambiarRatonDefault() {
		lblCuenta.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	protected void cambiarRatonHand() {
		lblCuenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	protected void crearCuenta() {
		Registro reg = new Registro();
		reg.setVisible(true);

	}

}

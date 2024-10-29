package uiux.practicaExamen;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import uiux.models.Clases;
import uiux.models.Usuario;
import uiux.practicaExamen.panels.PanelHomeAdministrador;
import uiux.practicaExamen.panels.PanelHomeCliente;
import uiux.practicaExamen.panels.PanelRegistro;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	public static ArrayList<Usuario> listUsuario;
	public static ArrayList<Clases> listClases;

	private JPasswordField passwordField;

	public VentanaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(902, 557);
		setMinimumSize(new Dimension(600, 400));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		listUsuario = new ArrayList<>();
		listClases = new ArrayList<>();
		cargarUsuarios();
		cargarClases();
		inicializarComponentes();
	}

	public static ArrayList<Usuario> getListUsuarios() {
		return listUsuario;
	}

	public static ArrayList<Clases> getListClases() {
		return listClases;
	}

	private void inicializarComponentes() {
		JPanel panelPrincipal = new JPanel(new BorderLayout());
		contentPane.add(panelPrincipal, BorderLayout.CENTER);

		JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelSuperior.setBackground(new Color(175, 238, 238));
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);

		JLabel lblLogo = new JLabel("         GYM Picasso");
		lblLogo.setForeground(new Color(0, 255, 255));
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogo.setIcon(new ImageIcon(VentanaLogin.class.getResource("/resources/logoApp.png")));
		panelSuperior.add(lblLogo);

		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(255, 255, 255));
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblFotoLogin = new JLabel();
		lblFotoLogin.setIcon(new ImageIcon(VentanaLogin.class.getResource("/resources/imgLogin.png")));
		lblFotoLogin.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentral.add(lblFotoLogin);

		JPanel panelDerecha = new JPanel(new BorderLayout());
		panelCentral.add(panelDerecha);
		panelDerecha.setPreferredSize(new Dimension(451, 300)); // Tamaño inicial que se puede ajustar
		panelDerecha.setMinimumSize(new Dimension(200, 200)); // Tamaño mínimo

		JPanel panelTituloLogin = new JPanel(new GridLayout(1, 1));
		panelTituloLogin.setBackground(new Color(30, 144, 255));
		panelTituloLogin.setPreferredSize(new Dimension(0, 100)); // Ajusta el alto del título
		panelDerecha.add(panelTituloLogin, BorderLayout.NORTH);

		JLabel lblTituloLogin = new JLabel("Bienvenidos a la aplicación GYM Picasso", SwingConstants.CENTER);
		lblTituloLogin.setForeground(Color.WHITE);
		lblTituloLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelTituloLogin.add(lblTituloLogin);

		JPanel panelFormulario = new JPanel();

		panelDerecha.add(panelFormulario, BorderLayout.CENTER);
		GridBagLayout gbl_panelFormulario = new GridBagLayout();
		gbl_panelFormulario.columnWidths = new int[] { 60, 86, 0 };
		gbl_panelFormulario.rowHeights = new int[] { 20, 20, 0, 0, 0, 0, 0 };
		gbl_panelFormulario.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelFormulario.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelFormulario.setLayout(gbl_panelFormulario);

		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 1;
		panelFormulario.add(lblUsuario, gbc_lblUsuario);
		txtUser = new JTextField(10);
		GridBagConstraints gbc_txtUser = new GridBagConstraints();
		gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUser.anchor = GridBagConstraints.NORTH;
		gbc_txtUser.insets = new Insets(0, 0, 5, 0);
		gbc_txtUser.gridx = 1;
		gbc_txtUser.gridy = 1;
		panelFormulario.add(txtUser, gbc_txtUser);

		JLabel lblContrasena = new JLabel("Contraseña:");
		GridBagConstraints gbc_lblContrasena = new GridBagConstraints();
		gbc_lblContrasena.anchor = GridBagConstraints.EAST;
		gbc_lblContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasena.gridx = 0;
		gbc_lblContrasena.gridy = 2;
		panelFormulario.add(lblContrasena, gbc_lblContrasena);

		JButton btnNewButton_1 = new JButton("Pulse aqui para registrasrse");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarse();
			}
		});

		JButton btnNewButton = new JButton("Iniciar Sesión");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarSesion();
			}
		});

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 2;
		panelFormulario.add(passwordField, gbc_passwordField);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		panelFormulario.add(btnNewButton, gbc_btnNewButton);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 5;
		panelFormulario.add(btnNewButton_1, gbc_btnNewButton_1);
	}

	protected void registrarse() {

		PanelRegistro paneli = new PanelRegistro();
		paneli.setVisible(true);
	}

	protected void iniciarSesion() {
		String linea;
		String usuario = txtUser.getText();
		String contraseña = new String(passwordField.getPassword());
		boolean usuarioEncontrado = false;

		try {
			BufferedReader br = new BufferedReader(new FileReader("Usuarios.txt"));
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(",");

				if (datos[4].equals(usuario) && datos[5].equals(contraseña)) {
					usuarioEncontrado = true;
					System.out.println("Entrada Exitosa, Bienvenido " + usuario);
					dispose();

					if (datos[3].equalsIgnoreCase("administrador")) {
						PanelHomeAdministrador home = new PanelHomeAdministrador();
						System.out.println("Administrador");
						home.setVisible(true);
					} else if (datos[3].equalsIgnoreCase("cliente")) {
						PanelHomeCliente home = new PanelHomeCliente();
						home.setVisible(true);
						System.out.println("Cliente");
					}
					break;
				}
			}

			if (!usuarioEncontrado) {
				JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
				txtUser.setText("");
				passwordField.setText("");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error: Archivo no encontrado");
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error al leer el archivo");
		}
	}

	public static void saveUsuarios() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Usuarios.txt"))) {
			for (Usuario us1 : VentanaLogin.getListUsuarios()) {
				String linea = String.join(",", us1.getNombre(), us1.getApellidos(), us1.getFechaNacimiento(), us1.getPerfil(),
						us1.getEmail(), us1.getContraseña());
				writer.write(linea);
				writer.newLine();
			}
			System.out.println("Usuarios guardados con éxito.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveClases() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Clases.txt"))) {
			for (Clases cl1 : VentanaLogin.getListClases()) {
				String linea = String.join(",", cl1.getNombre(), cl1.getProfesor(), cl1.isTurno());
				writer.write(linea);
				writer.newLine();
			}
			System.out.println("Clases guardados con éxito.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void cargarUsuarios() {
		File file = new File("Usuarios.txt");

		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("Archivo de Usuarios creado: " + file.getName());
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al crear el archivo: " + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String linea;
			boolean isEmpty = true;

			while ((linea = reader.readLine()) != null) {
				Usuario user = parsearCliente(linea);
				VentanaLogin.getListUsuarios().add(user);
				isEmpty = false;
			}

			if (isEmpty) {
				JOptionPane.showMessageDialog(null, "El archivo de Usuarios está vacío.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			} else {
				System.out.println("Usuarios cargados con éxito.");
			}
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar los Usuarios: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private Usuario parsearCliente(String linea) {
		if (linea == null || linea.trim().isEmpty()) {
			throw new IllegalArgumentException("Linea nula");
		}

		String[] datos = linea.split(",");

		if (datos.length < 6) {
			System.out.println("Línea inválida: " + linea);
			throw new IllegalArgumentException("Datos incompletos");
		}

		return new Usuario(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
	}

	private Clases parsearClases(String linea) {
		if (linea == null || linea.trim().isEmpty()) {
			throw new IllegalArgumentException("Linea nula");
		}

		String[] datos = linea.split(",");

		if (datos.length < 3) {
			System.out.println("Línea inválida: " + linea);
			throw new IllegalArgumentException("Datos incompletos");
		}

		return new Clases(datos[0], datos[1], datos[2]);
	}

	
	
	private void cargarClases() {
		File file = new File("Clases.txt");

		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("Archivo de Clases creado: " + file.getName());
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al crear el archivo: " + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String linea;
			boolean isEmpty = true;

			while ((linea = reader.readLine()) != null) {
				Clases clase = parsearClases(linea);
				VentanaLogin.getListClases().add(clase);
				isEmpty = false;
			}

			if (isEmpty) {
				JOptionPane.showMessageDialog(null, "El archivo de Clases está vacío.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			} else {
				System.out.println("Clases cargados con éxito.");
			}
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar los Usuarios: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}

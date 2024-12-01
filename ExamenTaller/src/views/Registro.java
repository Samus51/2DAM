package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Launcher;
import models.Usuario;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;

public class Registro extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JRadioButton rdbTelefono;
	private JRadioButton rdbEmail;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private final ButtonGroup botonesInfo = new ButtonGroup();
	private JPasswordField confirmPassword;
	private JPasswordField passwordField;

	/**
	 * Create the dialog.
	 */
	public Registro() {
		inicializarComponentes();
		this.setModal(true);
	}

	private void inicializarComponentes() {
		setBounds(100, 100, 485, 637);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(135, 206, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 0, 139));
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(0, 0, 139));
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JLabel lblNewLabel_7 = new JLabel("New label");
					panel_1.add(lblNewLabel_7);
				}
				{
					JLabel lblNewLabel_8 = new JLabel("Registro Cliente");
					lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
					lblNewLabel_8.setForeground(new Color(255, 255, 255));
					lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
					panel_1.add(lblNewLabel_8);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(7, 2, 0, 20));
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_1);
			}
			{
				txtNombre = new JTextField();
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Apellidos");
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_2);
			}
			{
				txtApellidos = new JTextField();
				panel.add(txtApellidos);
				txtApellidos.setColumns(10);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Télefono");
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_3);
			}
			{
				txtTelefono = new JTextField();
				panel.add(txtTelefono);
				txtTelefono.setColumns(10);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Email");
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_4);
			}
			{
				txtEmail = new JTextField();
				panel.add(txtEmail);
				txtEmail.setColumns(10);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("Contraseña");
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_5);
			}
			{
				passwordField = new JPasswordField();
				panel.add(passwordField);
			}
			{
				JLabel lblNewLabel_6 = new JLabel("Confirmar Contraseña");
				lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_6);
			}
			{
				confirmPassword = new JPasswordField();
				panel.add(confirmPassword);
			}
			{
				JLabel lblNewLabel = new JLabel("Método de Contacto");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(255, 255, 255));
				panel.add(panel_1);
				panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
				{
					rdbTelefono = new JRadioButton("Télefono");
					botonesInfo.add(rdbTelefono);
					rdbTelefono.setBackground(new Color(255, 255, 255));
					panel_1.add(rdbTelefono);
				}
				{
					rdbEmail = new JRadioButton("Email");
					botonesInfo.add(rdbEmail);
					rdbEmail.setBackground(new Color(255, 255, 255));
					panel_1.add(rdbEmail);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(135, 206, 250));
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));

					}

					@Override
					public void mouseExited(MouseEvent e) {
						btnRegistrar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						registrar();
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));

					}

					@Override
					public void mouseExited(MouseEvent e) {
						btnCancelar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

					}

					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}

	protected void registrar() {
		String nombre = txtNombre.getText();
		String apellidos = txtApellidos.getText();
		String telefono = txtTelefono.getText();
		String email = txtEmail.getText();
		String contraseña = new String(passwordField.getPassword());
		String confirmPasswordString = new String(confirmPassword.getPassword());
		String modoContacto = "";

		if (rdbEmail.isSelected()) {
			modoContacto = "Email";
		} else {
			modoContacto = "Telefono";
		}

		if (nombre.isBlank() || apellidos.isBlank() || email.isBlank() || contraseña.isBlank()
				|| confirmPasswordString.isBlank() || telefono.isBlank()) {
			JOptionPane.showMessageDialog(null, "Debes completar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (!rdbEmail.isSelected() && !rdbTelefono.isSelected()) {
			JOptionPane.showMessageDialog(null, "Debes elegir un perfil de usuario", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (contraseña.equals(confirmPasswordString)) {

			boolean encontrado = false;
			for (Usuario cliente : Launcher.lstClientes) {
				if (cliente.getEmail().equalsIgnoreCase(email)) {
					encontrado = true;
					break;
				}
			}
			if (encontrado) {
				JOptionPane.showMessageDialog(null, "El cliente con este email ya existe.", "Error",
						JOptionPane.ERROR_MESSAGE);

			} else {
				Usuario c1 = new Usuario(nombre, apellidos, telefono, email, contraseña, modoContacto);
				JOptionPane.showMessageDialog(null, "El cliente" + nombre + " ha sido creado con éxito");
				Launcher.lstClientes.add(c1);
				System.out.println(Launcher.lstClientes.size());

			}

		} else {
			JOptionPane.showMessageDialog(null, "La contraseña no coincide con la de confirmacion", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

	}

}

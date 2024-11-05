package uiux.practicaExamen.panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uiux.models.Usuario;
import uiux.practicaExamen.VentanaLogin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PanelEliminarCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel panelPadre = new JPanel();
	private JTextField txtNombre;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PanelEliminarCliente dialog = new PanelEliminarCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PanelEliminarCliente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		panelPadre.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelPadre, BorderLayout.CENTER);
		panelPadre.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelTitulo = new JPanel();
			panelTitulo.setBackground(new Color(127, 255, 212));
			panelPadre.add(panelTitulo, BorderLayout.NORTH);
			{
				JLabel lblTitulo = new JLabel("Eliminar Cliente");
				lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblTitulo.setForeground(new Color(255, 255, 255));
				panelTitulo.add(lblTitulo);
			}
		}
		{
			JPanel panelCentral = new JPanel();
			panelCentral.setBackground(new Color(135, 206, 235));
			panelPadre.add(panelCentral, BorderLayout.CENTER);
			GridBagLayout gbl_panelCentral = new GridBagLayout();
			gbl_panelCentral.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_panelCentral.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_panelCentral.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					Double.MIN_VALUE };
			gbl_panelCentral.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panelCentral.setLayout(gbl_panelCentral);
			{
				JLabel lblNombre = new JLabel("Nombre");
				lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNombre.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblNombre = new GridBagConstraints();
				gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
				gbc_lblNombre.gridx = 1;
				gbc_lblNombre.gridy = 2;
				panelCentral.add(lblNombre, gbc_lblNombre);
			}
			{
				txtNombre = new JTextField();
				GridBagConstraints gbc_txtNombre = new GridBagConstraints();
				gbc_txtNombre.gridwidth = 5;
				gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
				gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtNombre.gridx = 4;
				gbc_txtNombre.gridy = 2;
				panelCentral.add(txtNombre, gbc_txtNombre);
				txtNombre.setColumns(10);
			}
			{
				JLabel lblEmail = new JLabel("Email");
				lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblEmail.setForeground(new Color(255, 255, 255));
				GridBagConstraints gbc_lblEmail = new GridBagConstraints();
				gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
				gbc_lblEmail.gridx = 1;
				gbc_lblEmail.gridy = 3;
				panelCentral.add(lblEmail, gbc_lblEmail);
			}
			{
				txtEmail = new JTextField();
				GridBagConstraints gbc_txtEmail = new GridBagConstraints();
				gbc_txtEmail.gridwidth = 5;
				gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
				gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtEmail.gridx = 4;
				gbc_txtEmail.gridy = 3;
				panelCentral.add(txtEmail, gbc_txtEmail);
				txtEmail.setColumns(10);
			}
			{
				JButton btnEliminar = new JButton("Eliminar");
				btnEliminar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						borrarCliente();
					}
				});
				GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
				gbc_btnEliminar.gridx = 8;
				gbc_btnEliminar.gridy = 6;
				panelCentral.add(btnEliminar, gbc_btnEliminar);
				btnEliminar.setActionCommand("Cancel");
			}
		}
	}

	protected void borrarCliente() {
		String nombre = txtNombre.getText();
		String email = txtEmail.getText();
		String linea;
		boolean usuarioEncontrado = false;

		List<String> lineasRestantes = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader("Usuarios.txt"))) {
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(",");
				String nombreDatos = datos[0];
				String emailDatos = datos[4];

				if (!nombreDatos.equals(nombre) || !emailDatos.equals(email)) {
					lineasRestantes.add(linea);
				} else {
					usuarioEncontrado = true; 
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (usuarioEncontrado) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter("Usuarios.txt"))) {
				for (String lineaActual : lineasRestantes) {
					bw.write(lineaActual);
					bw.newLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			for (int i = 0; i < VentanaLogin.getListUsuarios().size(); i++) {
				Usuario usuario = VentanaLogin.getListUsuarios().get(i);
				if (usuario.getNombre().equals(nombre) && usuario.getEmail().equals(email)) {
					VentanaLogin.getListUsuarios().remove(i);
				}
			}
			VentanaLogin.saveUsuarios();

			JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente");
		} else {
			JOptionPane.showMessageDialog(this, "El usuario a eliminar no existe");
		}
	}
}

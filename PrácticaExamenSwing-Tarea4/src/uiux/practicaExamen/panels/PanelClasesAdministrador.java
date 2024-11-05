package uiux.practicaExamen.panels;

import javax.swing.JFrame;
import javax.swing.JPanel;
import uiux.models.Clases;
import uiux.practicaExamen.VentanaLogin;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelClasesAdministrador extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombreClase;
	private JTextField txtProfesor;
	private JRadioButton rdbMañana;
	private JRadioButton rdbTarde;
	PanelHomeAdministrador padre;

	private PanelHomeAdministrador home;
	/**
	 * Create the panel.
	 */
	public PanelClasesAdministrador(JFrame parent, boolean modal) {
		initialize();
		padre = (PanelHomeAdministrador) parent;
		this.setModal(modal);
	}

	/**
	 * Metodo que inicializa los componentes de la ventana
	 */
	private void initialize() {
		setSize(new Dimension(600, 400));
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(72, 209, 204));
		getContentPane().add(panelTitulo, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Nueva Clase");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelTitulo.add(lblNewLabel);

		JPanel panelCentral = new JPanel();
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		GridBagLayout gbl_panelCentral = new GridBagLayout();
		gbl_panelCentral.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panelCentral.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panelCentral.setLayout(gbl_panelCentral);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 2;
		panelCentral.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtNombreClase = new JTextField();
		GridBagConstraints gbc_txtNombreClase = new GridBagConstraints();
		gbc_txtNombreClase.gridwidth = 2;
		gbc_txtNombreClase.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreClase.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreClase.gridx = 4;
		gbc_txtNombreClase.gridy = 2;
		panelCentral.add(txtNombreClase, gbc_txtNombreClase);
		txtNombreClase.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Profesor");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 3;
		panelCentral.add(lblNewLabel_2, gbc_lblNewLabel_2);

		txtProfesor = new JTextField();
		GridBagConstraints gbc_txtProfesor = new GridBagConstraints();
		gbc_txtProfesor.gridwidth = 2;
		gbc_txtProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_txtProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtProfesor.gridx = 4;
		gbc_txtProfesor.gridy = 3;
		panelCentral.add(txtProfesor, gbc_txtProfesor);
		txtProfesor.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Turno");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 4;
		panelCentral.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addClase();
			}
		});

		rdbMañana = new JRadioButton("Mañana");
		GridBagConstraints gbc_rdbMañana = new GridBagConstraints();
		gbc_rdbMañana.insets = new Insets(0, 0, 5, 5);
		gbc_rdbMañana.gridx = 4;
		gbc_rdbMañana.gridy = 4;
		panelCentral.add(rdbMañana, gbc_rdbMañana);

		rdbTarde = new JRadioButton("Tarde");
		GridBagConstraints gbc_rdbTarde = new GridBagConstraints();
		gbc_rdbTarde.insets = new Insets(0, 0, 5, 5);
		gbc_rdbTarde.gridx = 4;
		gbc_rdbTarde.gridy = 5;
		panelCentral.add(rdbTarde, gbc_rdbTarde);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 9;
		gbc_btnNewButton.gridy = 8;
		panelCentral.add(btnNewButton, gbc_btnNewButton);

	}

	/**
	 * Metodo que añade una clase al repertorio de clases que elegir para los
	 * clientes
	 */
	protected void addClase() {
		String nombre = txtNombreClase.getText();
		String profesor = txtProfesor.getText();
		String turno = "";

		if (nombre.isBlank() || profesor.isBlank()) {
			JOptionPane.showMessageDialog(this, "Debes rellenar los campos para crear la clase");
			return;
		}

		if (!rdbMañana.isSelected() && !rdbTarde.isSelected()) {
			JOptionPane.showMessageDialog(this, "Debes seleccionar un turno (Mañana o Tarde)");
			return;
		}

		if (rdbMañana.isSelected() && rdbTarde.isSelected()) {
			JOptionPane.showMessageDialog(this, "No puedes crear una clase con 2 turnos");
			return;
		}

		if (rdbMañana.isSelected()) {
			turno = "Mañana";
		} else {
			turno = "Tarde";
		}

		for (Clases cl : VentanaLogin.getListClases()) {
			if (cl.getNombre().trim().equalsIgnoreCase(nombre) && cl.getProfesor().trim().equalsIgnoreCase(profesor)
					&& cl.getTurno().trim().equalsIgnoreCase(turno)) {
				JOptionPane.showMessageDialog(this, "No puedes crear una Clase ya existente.");
				return;
			}
		}

		Clases clases = new Clases(nombre, profesor, turno);
		VentanaLogin.getListClases().add(clases);
		VentanaLogin.saveClases();
		JOptionPane.showMessageDialog(this, "Clase de " + nombre + " creada con éxito");
		dispose();
	}
}

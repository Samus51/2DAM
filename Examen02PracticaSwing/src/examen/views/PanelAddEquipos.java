package examen.views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import com.toedter.calendar.JYearChooser;

import examen.mainApp.Launcher;
import models.Equipo;
import models.Usuario;

import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class PanelAddEquipos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private final ButtonGroup botonesGenero = new ButtonGroup();
	private JComboBox cbEntrenador;
	private JTextField txtHorario;
	private JPanel panelBotones;
	private JYearChooser añoEquipo;
	private JRadioButton rbtFem;
	private JRadioButton rbtMasc;

	/**
	 * Create the panel.
	 */
	public PanelAddEquipos() {
		inicializarComponentes();
		cargaEquipos();
	}

	private void cargaEquipos() {
	    DefaultComboBoxModel<Usuario> model = (DefaultComboBoxModel) cbEntrenador.getModel();
	    for (Usuario eq : Launcher.lstUsuarios) {
	        if (eq.getEsEntrenador() && model.getIndexOf(eq) == -1) { // Evita duplicados
	            model.addElement(eq);
	        }
	    }
	}
	private void inicializarComponentes() {
		setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Añade Equipo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 2, 0, 0));

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);

		txtNombre = new JTextField();
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Año");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);

		añoEquipo = new JYearChooser();
		panel.add(añoEquipo);

		JLabel lblNewLabel_4 = new JLabel("Genero");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_4);

		panelBotones = new JPanel();
		panel.add(panelBotones);
		panelBotones.setLayout(new GridLayout(1, 1, 0, 0));

		rbtFem = new JRadioButton("Femenino");
		botonesGenero.add(rbtFem);
		rbtFem.setHorizontalAlignment(SwingConstants.CENTER);
		panelBotones.add(rbtFem);

		rbtMasc = new JRadioButton("Masculino");
		botonesGenero.add(rbtMasc);
		panelBotones.add(rbtMasc);

		JLabel lblNewLabel_5 = new JLabel("Horario Entrenamiento");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_5);

		txtHorario = new JTextField();
		panel.add(txtHorario);
		txtHorario.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Entrenador");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_6);

		cbEntrenador = new JComboBox();
		panel.add(cbEntrenador);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);

		JButton btnAdd = new JButton("Añadir");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addEquipo();
			}
		});
		panel_2.add(btnAdd);
	}

	protected void addEquipo() {
		String nombre = txtNombre.getText();
		int año = añoEquipo.getYear();
		String genero = null;
		if (rbtMasc.isSelected()) {
			genero = "Masculino";
		} else {
			genero = "Femenino";
		}
		String horario = txtHorario.getText();
	    Usuario Entrenador = (Usuario) cbEntrenador.getSelectedItem();
		Equipo nuevoEquipo = new Equipo(nombre, año, genero, horario, new ArrayList<Usuario>(), Entrenador);
		JOptionPane.showMessageDialog(null, "El equipo " + nombre + " fue añadido correctamente");
		Launcher.lstEquipos.add(nuevoEquipo);

	}

}

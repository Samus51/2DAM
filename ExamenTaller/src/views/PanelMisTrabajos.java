package views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import main.Launcher;
import models.Empleado;
import models.Reparacion;
import models.Usuario;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.Color;

public class PanelMisTrabajos extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private Empleado userLogado;

	/**
	 * Create the panel.
	 */
	public PanelMisTrabajos(Empleado clienteLogueado) {
		inicializarComponentes();
		this.setModal(true);
		this.userLogado = clienteLogueado;
		cargarReparaciones();
	}

	private void inicializarComponentes() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		setBounds(100, 100, 524, 444);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Mis Reparaciones");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnVolver.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
		});
		panel_1.add(btnVolver);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "Matricula", "Fecha", "Estado", "Importe", "Obervaciones" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(102);
		table.getColumnModel().getColumn(1).setPreferredWidth(116);
		table.getColumnModel().getColumn(2).setPreferredWidth(127);
		table.getColumnModel().getColumn(3).setPreferredWidth(97);
		table.getColumnModel().getColumn(4).setPreferredWidth(142);
		scrollPane.setViewportView(table);
	}

	private void cargarReparaciones() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Limpiar la tabla antes de cargar nuevas filas

		for (Reparacion rep : Launcher.lstReparaciones) {
			// Verificar si la reparación está asociada a un vehículo del cliente logueado

			try {
				// Añadir la reparación correspondiente en la tabla
				model.addRow(new Object[] { rep.getCita().getVehiculo().getMatricula(),
						new SimpleDateFormat("dd-MM-yyyy").format(rep.getCita().getFechaCita()), // Formato de
																									// fecha
						rep.getEstado(), rep.getImporte(), // Suponiendo que `getImporte()` existe en Reparacion
						rep.getObservaciones() // Suponiendo que `getObservaciones()` existe en Reparacion
				});
			} catch (Exception e) {
				e.printStackTrace(); // Gestionar la excepción si algo falla al agregar la fila
			}
		}
	}

}

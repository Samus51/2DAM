package examen.views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import models.Equipo;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMiEquipo extends JPanel {

	private static final long serialVersionUID = 1L;
	private List<Equipo> lstEquiposUsuario;
	private int indice;
	private Equipo equipoActual;
	private JPanel panelInf;
	private JLabel lblNombre;
	private JLabel lblAño;
	private JLabel lblGenero;
	private JLabel lblHorario;
	private JLabel lblEntrenador;

	public PanelMiEquipo(List<Equipo> equipoUsuario) {
		indice = 0;
		inicializarComponentes();
		cargarDatos(equipoUsuario);
	}

	private void cargarDatos(List<Equipo> equipoUsuario) {
		this.lstEquiposUsuario = equipoUsuario; // Asignar correctamente la lista de equipos

		if (equipoUsuario.size() == 1) {
			this.panelInf.setVisible(false);
		} else {
			this.panelInf.setVisible(true);
		}
		actualizarEquipo(); // Cargar los datos del primer equipo
	}

	private void inicializarComponentes() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Mi Equipo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.WEST);

		panelInf = new JPanel();
		add(panelInf, BorderLayout.SOUTH);

		JLabel lblAnterior = new JLabel("Anterior");
		lblAnterior.setOpaque(true);
		lblAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				anteriorEquipo();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblAnterior.setBackground(Color.BLUE);
				lblAnterior.setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblAnterior.setBackground(Color.WHITE);
				lblAnterior.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
		});
		lblAnterior.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAnterior.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblAnterior.setIcon(new ImageIcon(PanelMiEquipo.class.getResource("/utils/Izquierda.png")));
		panelInf.add(lblAnterior);

		JLabel lblSiguiente = new JLabel("Siguiente");
		lblSiguiente.setOpaque(true);
		lblSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				siguienteEquipo();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblSiguiente.setCursor(new Cursor(Cursor.HAND_CURSOR));
				lblSiguiente.setBackground(Color.BLUE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSiguiente.setBackground(Color.WHITE);
				lblSiguiente.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
		});
		lblSiguiente.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblSiguiente.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSiguiente.setIcon(new ImageIcon(PanelMiEquipo.class.getResource("/utils/Derecha.png")));
		panelInf.add(lblSiguiente);

		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.EAST);

		JPanel panel_4 = new JPanel();
		add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(5, 2, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);

		lblNombre = new JLabel("");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNombre);

		JLabel lblNewLabel_2 = new JLabel("Año");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_2);

		lblAño = new JLabel("");
		lblAño.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblAño);

		JLabel lblNewLabel_6 = new JLabel("Genero");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_6);

		lblGenero = new JLabel("");
		lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblGenero);

		JLabel lblNewLabel_8 = new JLabel("Horario");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_8);

		lblHorario = new JLabel("");
		lblHorario.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblHorario);

		JLabel lblNewLabel_5 = new JLabel("Entrenador");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_5);

		lblEntrenador = new JLabel("");
		lblEntrenador.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblEntrenador);
	}

	protected void anteriorEquipo() {
		if (lstEquiposUsuario != null && !lstEquiposUsuario.isEmpty()) {
			indice--; // Decrementa el índice
			if (indice < 0) {
				indice = lstEquiposUsuario.size() - 1; // Si estamos en el primer equipo, vuelve al último
			}
			actualizarEquipo();
		} else {
			JOptionPane.showMessageDialog(null, "No hay equipos disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void siguienteEquipo() {
		if (lstEquiposUsuario != null && !lstEquiposUsuario.isEmpty()) {
			indice++; // Incrementa el índice
			if (indice >= lstEquiposUsuario.size()) {
				indice = 0; // Si estamos en el último equipo, vuelve al primero
			}
			actualizarEquipo();
		} else {
			JOptionPane.showMessageDialog(null, "No hay equipos disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actualizarEquipo() {
		if (lstEquiposUsuario != null && !lstEquiposUsuario.isEmpty()) {
			equipoActual = lstEquiposUsuario.get(indice);

			lblNombre.setText(equipoActual.getNombre());
			lblAño.setText(Integer.toString(equipoActual.getAnyoCreacion()));
			lblGenero.setText(equipoActual.getGenero());
			lblHorario.setText(equipoActual.getHorario());
			lblEntrenador.setText(
					equipoActual.getEntrenador().getNombre() + " " + equipoActual.getEntrenador().getApellidos());
		}
	}
}

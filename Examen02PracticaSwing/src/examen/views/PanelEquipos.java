package examen.views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import examen.mainApp.Launcher;
import models.Equipo;
import models.Usuario;

import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelEquipos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox cbEquipos;
	private JLabel lblAño;
	private JLabel lblGenero;
	private JLabel lblEntrenador;
	private JLabel lblNºJugadores;
	private JLabel lblHorario;
	private Usuario us;
	private JButton btnInscribir;
	private int indice = 0;
	/**
	 * Create the panel.
	 */
	public PanelEquipos(Usuario us) {
		this.us = us;
		inicializarComponentes();
		cargaEquipos();
	}

	private void cargaEquipos() {
		for (Equipo eq : Launcher.lstEquipos) {
			if (((DefaultComboBoxModel) cbEquipos.getModel()).getIndexOf(eq.getNombre()) == -1) {
				cbEquipos.addItem(eq.getNombre());
			}
		}
	}

	public List<Equipo> ObtieneEquipoJugador(Usuario user) {
		List<Equipo> lstEquipoUsuario = new ArrayList<Equipo>();
		for (Equipo eq : Launcher.lstEquipos) {
			if (user.getEsEntrenador() && eq.getEntrenador().equals(user)) {
				lstEquipoUsuario.add(eq);
			} else {
				if (eq.getLstJugadores().contains(user)) {
					lstEquipoUsuario.add(eq);
				}
			}
			;
		}
		return lstEquipoUsuario;
	}

	private void inicializarComponentes() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Equipos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.WEST);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel_2, BorderLayout.SOUTH);

		btnInscribir = new JButton("Inscribirte");
		btnInscribir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inscribir();
			}
		});
		panel_2.add(btnInscribir);

		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.EAST);

		JPanel panel_4 = new JPanel();
		add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(6, 2, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("Equipo");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);

		cbEquipos = new JComboBox();
		cbEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarCombos(e);
			}
		});
		panel_4.add(cbEquipos);

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

		JLabel lblNewLabel_8 = new JLabel("Entrenador");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_8);

		lblEntrenador = new JLabel("");
		lblEntrenador.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblEntrenador);

		JLabel lblNewLabel_13 = new JLabel("Horario Entrenamiento");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_13);

		lblHorario = new JLabel("");
		lblHorario.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblHorario);

		JLabel lblNmeroDeJugadores = new JLabel("Número de Jugadores");
		lblNmeroDeJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNmeroDeJugadores);

		lblNºJugadores = new JLabel("");
		lblNºJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNºJugadores);
	}

	protected void inscribir() {
	    // Obtener equipos del usuario
	    List<Equipo> lstEquiposUsuario = ObtieneEquipoJugador(us);

	    // Validar selección en el ComboBox
	    if (cbEquipos.getSelectedItem() == null) {
	        JOptionPane.showMessageDialog(null, "Por favor, selecciona un equipo.", "Error",
	                JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    String nombreEquipo = cbEquipos.getSelectedItem().toString();
	    Equipo eqSeleccionado = null;

	    // Buscar equipo seleccionado
	    for (Equipo eq : Launcher.lstEquipos) {
	        if (eq.getNombre().equals(nombreEquipo)) {
	            eqSeleccionado = eq;
	            break;
	        }
	    }

	    // Validar que el equipo exista
	    if (eqSeleccionado == null) {
	        JOptionPane.showMessageDialog(null, "El equipo seleccionado no existe.", "Error",
	                JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Verificar si el usuario ya pertenece al equipo seleccionado
	    if (eqSeleccionado.getLstJugadores().contains(us)) {
	        JOptionPane.showMessageDialog(null, "Ya estás inscrito en este equipo.", "Info",
	                JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }

	    // Si el usuario no tiene equipo
	    if (lstEquiposUsuario.isEmpty()) {
	        // Inscribir directamente
	        eqSeleccionado.getLstJugadores().add(us);
	        JOptionPane.showMessageDialog(null, "Jugador inscrito correctamente al equipo " + nombreEquipo + ".");
	    } else {
	        // Confirmar cambio si ya pertenece a otro equipo
	        int respuesta = JOptionPane.showConfirmDialog(null, "¿Quiere cambiar de equipo?");
	        if (respuesta == JOptionPane.YES_OPTION) {
	            // Eliminar usuario del equipo actual
	            Equipo equipoActual = lstEquiposUsuario.get(0);
	            eliminaUsuarioDeEquipo(equipoActual, us);

	            // Inscribir en el nuevo equipo
	            eqSeleccionado.getLstJugadores().add(us);
	            JOptionPane.showMessageDialog(null, "Jugador cambiado al equipo " + nombreEquipo + ".");
	        } else {
	            return; // Cancelar inscripción
	        }
	    }

	    // Actualizar la interfaz
	    lblNºJugadores.setText(Integer.toString(eqSeleccionado.getLstJugadores().size()));
	    btnInscribir.setEnabled(false);
	}

	private void eliminaUsuarioDeEquipo(Equipo equipoActual, Usuario us2) {
		equipoActual.getLstJugadores().remove(us2);
	}

	protected void cargarCombos(ActionEvent e) {
		String nombreEquipo = cbEquipos.getSelectedItem().toString();
		Equipo eqSeleccionado = null;
		for (Equipo eq : Launcher.lstEquipos) {
			if (eq.getNombre().equals(nombreEquipo)) {
				eqSeleccionado = eq;
				break;
			}

		}
		if (eqSeleccionado != null) {
			lblAño.setText(Integer.toString(eqSeleccionado.getAnyoCreacion()));
			lblEntrenador.setText(
					eqSeleccionado.getEntrenador().getNombre() + " " + eqSeleccionado.getEntrenador().getApellidos());
			lblGenero.setText(eqSeleccionado.getGenero());
			lblHorario.setText(eqSeleccionado.getHorario());
			lblNºJugadores.setText(Integer.toString(eqSeleccionado.getLstJugadores().size()));
		}
		List<Equipo> lstEquiposUsuario = ObtieneEquipoJugador(us);

		if (lstEquiposUsuario.contains(eqSeleccionado)) {
			btnInscribir.setEnabled(false);
		} else {
			btnInscribir.setEnabled(true);

		}

	}

}

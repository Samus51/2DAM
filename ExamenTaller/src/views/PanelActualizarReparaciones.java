package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Reparacion;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelActualizarReparaciones extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox cbMatricula;
	private JLabel lblMarca;
	private JLabel lblModelo;
	private JLabel lblEstadoActual;
	private JComboBox cbNuevoEstado;
	private JTextArea txtObservaciones;

	/**
	 * Create the dialog.
	 */
	public PanelActualizarReparaciones() {
		inicializarComponentes();
		cargaReparaciones();
	}

	private void inicializarComponentes() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(5, 2, 0, 0));
			{
				JLabel lblNewLabel_2 = new JLabel("Matrícula");
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_2);
			}
			{
				cbMatricula = new JComboBox();
				panel.add(cbMatricula);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Marca");
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_3);
			}
			{
				lblMarca = new JLabel("");
				lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblMarca);
			}
			{
				JLabel lblNewLabel_6 = new JLabel("Modelo");
				lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_6);
			}
			{
				lblModelo = new JLabel("");
				lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblModelo);
			}
			{
				JLabel lblNewLabel_8 = new JLabel("Estado Actual");
				lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_8);
			}
			{
				lblEstadoActual = new JLabel("");
				lblEstadoActual.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblEstadoActual);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nuevo Estado");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_1);
			}
			{
				cbNuevoEstado = new JComboBox();
				panel.add(cbNuevoEstado);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(2, 2, 0, 0));
			{
				JLabel lblNewLabel_5 = new JLabel("Importe");
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_5);
			}
			{
				JTextField txtImporte = new JTextField();
				panel.add(txtImporte);
				txtImporte.setColumns(10);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Observaciones");
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_4);
			}
			{
				txtObservaciones = new JTextArea();
				panel.add(txtObservaciones);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					actualizarReparacion();
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						btnAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));

					}

					@Override
					public void mouseExited(MouseEvent e) {
						btnAceptar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

					}
				});
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					dispose();
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

					}

					@Override
					public void mouseExited(MouseEvent e) {
						cancelButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 0, 139));
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("Actualizar Reparacion");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNewLabel.setForeground(new Color(255, 255, 255));
				panel.add(lblNewLabel);
			}
		}
	}

	protected void actualizarReparacion() {
		// TODO Auto-generated method stub
		
	}

	private void cargaReparaciones() {
	    DefaultComboBoxModel model = (DefaultComboBoxModel) cbMatricula.getModel();
	    for (Reparacion eq : main.Launcher.lstReparaciones) {
	        if (!eq.getEstado().equals("Finalizado") && model.getIndexOf(eq) == -1) { // Evita duplicados
	            model.addElement(eq.getCita().getVehiculo().getMatricula());
	        }
	    }
	}

	
	
	
	
	/*
	 * protected void cargarCombos(ActionEvent e) { String matricula =
	 * cbMatricula.getSelectedItem();
	 * 
	 * 
	 * String modelo = cbMatricula.getSelectedItem().toString(); String
	 * marcaVehiculo = cbMatricula.getSelectedItem().toString(); Equipo
	 * eqSeleccionado = null; for (Equipo eq : Launcher.lstEquipos) { if
	 * (eq.getNombre().equals(nombreEquipo)) { eqSeleccionado = eq; break; }
	 * 
	 * } if (eqSeleccionado != null) {
	 * lblAño.setText(Integer.toString(eqSeleccionado.getAnyoCreacion()));
	 * lblEntrenador.setText( eqSeleccionado.getEntrenador().getNombre() + " " +
	 * eqSeleccionado.getEntrenador().getApellidos());
	 * lblGenero.setText(eqSeleccionado.getGenero());
	 * lblHorario.setText(eqSeleccionado.getHorario());
	 * lblNºJugadores.setText(Integer.toString(eqSeleccionado.getLstJugadores().size
	 * ())); } List<Equipo> lstEquiposUsuario = ObtieneEquipoJugador(us);
	 * 
	 * if (lstEquiposUsuario.contains(eqSeleccionado)) {
	 * btnInscribir.setEnabled(false); } else { btnInscribir.setEnabled(true);
	 * 
	 * }
	 * 
	 * }
	 */	
	
}

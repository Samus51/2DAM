package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import main.Launcher;
import models.Cita;
import models.Reparacion;
import models.Usuario;
import models.Vehiculo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PanelCita extends JDialog {

	private static final long serialVersionUID = 1L;
	private JDateChooser txtFecha;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextField txtMatricula;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private Usuario cliente;
	/**
	 * Create the dialog.
	 */
	public PanelCita(Usuario user) {
		inicializarComponentes();
		this.cliente = user;
	}

	private void inicializarComponentes() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
			{
				JPanel panel = new JPanel();
				panel.setBackground(new Color(135, 206, 250));
				buttonPane.add(panel);
			}
			{
				JPanel panel = new JPanel();
				panel.setBackground(new Color(135, 206, 250));
				buttonPane.add(panel);
				{
					btnAceptar = new JButton("Aceptar");
					btnAceptar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							btnAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));

						}

						@Override
						public void mouseExited(MouseEvent e) {
							btnAceptar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

						}

						@Override
						public void mouseClicked(MouseEvent e) {
							pedirCita();
						}
					});
					panel.add(btnAceptar);
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
					panel.add(btnCancelar);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 0, 128));
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(0, 0, 139));
				panel.add(panel_1);
				{
					JLabel lblNewLabel = new JLabel("Pedir Cita Previa");
					lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
					lblNewLabel.setForeground(new Color(255, 255, 255));
					panel_1.add(lblNewLabel);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(135, 206, 250));
				panel.add(panel_1);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(135, 206, 250));
			getContentPane().add(panel, BorderLayout.WEST);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(135, 206, 250));
			getContentPane().add(panel, BorderLayout.EAST);
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(4, 2, 0, 0));
			{
				JLabel lblNewLabel_2 = new JLabel("Matrícula");
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_2);
			}
			{
				txtMatricula = new JTextField();
				panel.add(txtMatricula);
				txtMatricula.setColumns(10);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Marca");
				lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_3);
			}
			{
				txtMarca = new JTextField();
				panel.add(txtMarca);
				txtMarca.setColumns(10);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Modelo");
				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_4);
			}
			{
				txtModelo = new JTextField();
				panel.add(txtModelo);
				txtModelo.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Fecha");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lblNewLabel_1);
			}
			{
				txtFecha = new JDateChooser();
				panel.add(txtFecha);
			}
		}
	}

	protected void pedirCita() {
		int contadorCitas = 0;
		String matricula = txtMatricula.getText();
		String marca = txtMarca.getText();
		String modelo = txtModelo.getText();
		Date fechaCita = txtFecha.getDate();

		// Buscar el vehículo
		Vehiculo vehiculo = null;
		for (Vehiculo v : Launcher.lstVehiculos) {
			if (v.getMatricula().equalsIgnoreCase(matricula) && v.getPropietario().equals(cliente)) {
				vehiculo = v;
				break;
			}
		}

		if (vehiculo == null) {
			vehiculo = new Vehiculo(matricula, marca, modelo, cliente);
			Launcher.lstVehiculos.add(vehiculo);
		}

		for (Cita v2 : Launcher.lstCitas) {
			if (esMismaFecha(v2.getFechaCita(), fechaCita)) {
				contadorCitas++;

			}
		}

		if (contadorCitas >= 2) {
			JOptionPane.showMessageDialog(null, "Este dia no esta disponible para su cita, elija otra fecha", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return;

		} else {

			for (Cita citaExistente : Launcher.lstCitas) {
				if (citaExistente.getFechaCita().equals(fechaCita)) {
					JOptionPane.showMessageDialog(null, "Ya tiene usted una cita para su vehiculo el dia seleccionado",
							"Warning", JOptionPane.WARNING_MESSAGE);
					return;

				}
			}

			Cita nuevaCita = new Cita(vehiculo, fechaCita);
			Launcher.lstCitas.add(nuevaCita);
			Reparacion r1 = new Reparacion(nuevaCita,"Pendiente","",0.0,null);
			Launcher.lstReparaciones.add(r1);
			JOptionPane.showMessageDialog(null,
					"La cita para el vehiculo de matricula " + matricula + " ha sido creado con éxito");

		}

	}

	private boolean esMismaFecha(Date fecha1, Date fecha2) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");
		return formatoFecha.format(fecha1).equals(formatoFecha.format(fecha2));
	}

}

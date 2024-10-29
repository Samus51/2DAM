package uiux.practicaExamen.panels;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import uiux.practicaExamen.VentanaLogin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelHomeCliente extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelHomeCliente() {
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(135, 206, 235));
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setPreferredSize(new Dimension(200,150));
		JLabel lblNewLabel = new JLabel("  GYM Picasso");
		lblNewLabel.setForeground(new Color(100, 149, 237));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon(PanelHomeCliente.class.getResource("/resources/logoApp.png")));
		panelTitulo.add(lblNewLabel);
		
		JPanel panelOpciones = new JPanel();
		getContentPane().add(panelOpciones, BorderLayout.CENTER);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			cerrarSesion();
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon(PanelHomeCliente.class.getResource("/resources/cierreSesion.png")));
		
		JLabel lblNewLabel_8 = new JLabel("Cerrar Sesión");
		
		JLabel lblNewLabel_1 = new JLabel("Ver Reservas");
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(PanelHomeCliente.class.getResource("/resources/listarReservas.png")));
		GroupLayout gl_panelOpciones = new GroupLayout(panelOpciones);
		gl_panelOpciones.setHorizontalGroup(
			gl_panelOpciones.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelOpciones.createSequentialGroup()
					.addContainerGap(110, Short.MAX_VALUE)
					.addGroup(gl_panelOpciones.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addGap(96)
					.addGroup(gl_panelOpciones.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_8)
						.addComponent(lblNewLabel_4))
					.addGap(117))
		);
		gl_panelOpciones.setVerticalGroup(
			gl_panelOpciones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOpciones.createSequentialGroup()
					.addGap(73)
					.addGroup(gl_panelOpciones.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelOpciones.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8)
						.addComponent(lblNewLabel_1))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		panelOpciones.setLayout(gl_panelOpciones);
		
		JPanel panelFoot = new JPanel();
		panelFoot.setBackground(new Color(135, 206, 235));
		getContentPane().add(panelFoot, BorderLayout.SOUTH);
		
		JLabel lblNombre = new JLabel("Samuel Fernández Rodríguez 29/10/2024");
		lblNombre.setForeground(new Color(65, 105, 225));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelFoot.add(lblNombre);

	}
	public void cerrarSesion() {
		dispose();
		VentanaLogin ventana = new VentanaLogin();
		ventana.setVisible(true);
	}
}

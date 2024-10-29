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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelHomeAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelHomeAdministrador() {
		setSize(new Dimension(800, 600));
		setResizable(false);
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(135, 206, 235));
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setPreferredSize(new Dimension(200,150));
		JLabel lblNewLabel = new JLabel("  GYM Picasso");
		lblNewLabel.setForeground(new Color(100, 149, 237));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon(PanelHomeAdministrador.class.getResource("/resources/logoApp.png")));
		panelTitulo.add(lblNewLabel);
		
		JPanel panelOpciones = new JPanel();
		getContentPane().add(panelOpciones, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			addClase();
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(PanelHomeAdministrador.class.getResource("/resources/addClase.png")));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			tablaClientes();
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(PanelHomeAdministrador.class.getResource("/resources/listarReservas.png")));
		
		JLabel lblNewLabel_5 = new JLabel("Añade Clase");
		
		JLabel lblNewLabel_6 = new JLabel("Ver Clases");
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(PanelHomeAdministrador.class.getResource("/resources/listarUsuarios.png")));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrarSesion();
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon(PanelHomeAdministrador.class.getResource("/resources/cierreSesion.png")));
		
		JLabel lblNewLabel_7 = new JLabel("Ver Clientes");
		
		JLabel lblNewLabel_8 = new JLabel("Cerrar Sesión");
		GroupLayout gl_panelOpciones = new GroupLayout(panelOpciones);
		gl_panelOpciones.setHorizontalGroup(
			gl_panelOpciones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOpciones.createSequentialGroup()
					.addGap(284)
					.addGroup(gl_panelOpciones.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_5)
						.addGroup(gl_panelOpciones.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel_7)
							.addComponent(lblNewLabel_3)))
					.addGap(65)
					.addGroup(gl_panelOpciones.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_8)
						.addComponent(lblNewLabel_4)
						.addGroup(gl_panelOpciones.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_6)))
					.addContainerGap(306, Short.MAX_VALUE))
		);
		gl_panelOpciones.setVerticalGroup(
			gl_panelOpciones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOpciones.createSequentialGroup()
					.addGap(84)
					.addGroup(gl_panelOpciones.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelOpciones.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_5)
							.addGap(18)
							.addComponent(lblNewLabel_3))
						.addGroup(gl_panelOpciones.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_6)
							.addGap(18)
							.addComponent(lblNewLabel_4)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelOpciones.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_7)
						.addComponent(lblNewLabel_8))
					.addContainerGap(111, Short.MAX_VALUE))
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

	protected void tablaClientes() {

		PanelTablaClientesAdministrador panel = new PanelTablaClientesAdministrador();
		panel.setVisible(true);
	}

	protected void addClase() {
		PanelClasesAdministrador clases = new PanelClasesAdministrador();
		clases.setVisible(true);
	}

	protected void cerrarSesion() {
		dispose();
		VentanaLogin ventana = new VentanaLogin();
		ventana.setVisible(true);
	}
}

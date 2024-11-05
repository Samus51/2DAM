package uiux.practicaExamen.panels;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import uiux.practicaExamen.VentanaLogin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class PanelHomeAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblNombre;

	/**
	 * Create the panel.
	 */
	public PanelHomeAdministrador(String nombre) {
		initialize();
		setSize(new Dimension(800, 600));
		setResizable(false);
		lblNombre.setText(nombre);
	}

	private void initialize() {
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(135, 206, 235));
		getContentPane().add(panelTitulo, BorderLayout.NORTH);
		panelTitulo.setPreferredSize(new Dimension(200, 150));
		JLabel lblNewLabel = new JLabel("  GYM Picasso");
		lblNewLabel.setForeground(new Color(100, 149, 237));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setIcon(new ImageIcon(PanelHomeAdministrador.class.getResource("/resources/logoApp.png")));
		panelTitulo.add(lblNewLabel);

		JPanel panelOpciones = new JPanel();
		getContentPane().add(panelOpciones, BorderLayout.CENTER);

		JLabel lblAddClase = new JLabel("");
		lblAddClase.setIcon(new ImageIcon(PanelHomeAdministrador.class.getResource("/resources/addClase.png")));
		lblAddClase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addClase();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblAddClase.setBorder(new LineBorder(Color.WHITE, 2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblAddClase.setBorder(null);
			}
		});

		JLabel lblVerClases = new JLabel("");
		lblVerClases.setIcon(new ImageIcon(PanelHomeAdministrador.class.getResource("/resources/listarReservas.png")));
		lblVerClases.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tablaClientes();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblVerClases.setBorder(new LineBorder(Color.WHITE, 2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblVerClases.setBorder(null);
			}
		});

		JLabel lblNewLabel_5 = new JLabel("Añade Clase");
		JLabel lblNewLabel_6 = new JLabel("Ver Clases");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblVerClientes = new JLabel("");
		lblVerClientes
				.setIcon(new ImageIcon(PanelHomeAdministrador.class.getResource("/resources/listarUsuarios.png")));
		lblVerClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				verClientes();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblVerClientes.setBorder(new LineBorder(Color.WHITE, 2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblVerClientes.setBorder(null);
			}
		});

		JLabel lblSalir = new JLabel("");
		lblSalir.setIcon(new ImageIcon(PanelHomeAdministrador.class.getResource("/resources/cierreSesion.png")));
		lblSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrarSesion();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblSalir.setBorder(new LineBorder(Color.WHITE, 2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSalir.setBorder(null);
			}
		});

		JLabel lblNewLabel_7 = new JLabel("Ver Clientes");
		JLabel lblNewLabel_8 = new JLabel("Cerrar Sesión");
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			PanelEliminarCliente pani = new PanelEliminarCliente();
			pani.setVisible(true);
			}
		});
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(PanelHomeAdministrador.class.getResource("/resources/apuntaAClase.png")));
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			PanelEditarCliente pani = new PanelEditarCliente();
			pani.setVisible(true);
			}
		});
		label.setIcon(new ImageIcon(PanelHomeAdministrador.class.getResource("/resources/listarReservas.png")));
		
		JLabel lblNewLabel_2 = new JLabel("Eliminar Usuarios");
		
		JLabel lblNewLabel_3 = new JLabel("Editar Usuarios");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);

		GroupLayout gl_panelOpciones = new GroupLayout(panelOpciones);
		gl_panelOpciones.setHorizontalGroup(
			gl_panelOpciones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOpciones.createSequentialGroup()
					.addGap(163)
					.addGroup(gl_panelOpciones.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelOpciones.createSequentialGroup()
							.addGap(8)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panelOpciones.createParallelGroup(Alignment.TRAILING)
							.addComponent(label)
							.addGroup(gl_panelOpciones.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_2))))
					.addGap(59)
					.addGroup(gl_panelOpciones.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddClase, Alignment.TRAILING)
						.addComponent(lblNewLabel_5, Alignment.TRAILING)
						.addGroup(Alignment.TRAILING, gl_panelOpciones.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel_7)
							.addComponent(lblVerClientes)))
					.addGroup(gl_panelOpciones.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelOpciones.createSequentialGroup()
							.addGroup(gl_panelOpciones.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelOpciones.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_8))
								.addGroup(gl_panelOpciones.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panelOpciones.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblSalir))
									.addGroup(gl_panelOpciones.createSequentialGroup()
										.addGap(75)
										.addComponent(lblVerClases, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addGap(297))
						.addGroup(gl_panelOpciones.createSequentialGroup()
							.addGap(44)
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panelOpciones.setVerticalGroup(
			gl_panelOpciones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOpciones.createSequentialGroup()
					.addGap(84)
					.addGroup(gl_panelOpciones.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelOpciones.createSequentialGroup()
							.addGroup(gl_panelOpciones.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelOpciones.createSequentialGroup()
									.addComponent(lblAddClase)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_5))
								.addGroup(gl_panelOpciones.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblVerClases)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_6)))
							.addGap(40)
							.addGroup(gl_panelOpciones.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblVerClientes)
								.addComponent(lblSalir))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelOpciones.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_7)
								.addComponent(lblNewLabel_8)))
						.addGroup(gl_panelOpciones.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2)
							.addGap(37)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3)))
					.addGap(189))
		);
		panelOpciones.setLayout(gl_panelOpciones);

		JPanel panelFoot = new JPanel();
		panelFoot.setBackground(new Color(135, 206, 235));
		getContentPane().add(panelFoot, BorderLayout.SOUTH);

		lblNombre = new JLabel("");
		lblNombre.setForeground(new Color(65, 105, 225));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelFoot.add(lblNombre);
	}

	/**
	 * Metodos que accionan segun que icono pulses y abre ciertas ventanas
	 */
	protected void verClientes() {
		PanelTablaClientesAdministrador panel = new PanelTablaClientesAdministrador(this, true);
		panel.setVisible(true);
	}

	protected void tablaClientes() {
		PanelTablaClasesAdministrador panel = new PanelTablaClasesAdministrador(this, true);
		panel.setVisible(true);
	}

	protected void addClase() {
		PanelClasesAdministrador clases = new PanelClasesAdministrador(this, true);
		clases.setVisible(true);
	}

	protected void cerrarSesion() {
		dispose();
		VentanaLogin ventana = new VentanaLogin();
		ventana.setVisible(true);
	}
}

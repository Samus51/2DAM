package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Usuario;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblUsuario;
	private Usuario userLogado;
	private JLabel lblCita;
	private JLabel lblReparaciones;
	private JLabel lblLogOut;

	/**
	 * Create the frame.
	 */
	public HomeCliente(Usuario clienteLogueado) {
		inicializarComponentes();
		this.userLogado = clienteLogueado;
		lblUsuario.setText("Bienvenido " + userLogado.getNombre() + " " + userLogado.getApellidos());
	}

	private void inicializarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		FlowLayout flowLayout_3 = (FlowLayout) panel.getLayout();
		flowLayout_3.setAlignOnBaseline(true);
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("  Talleres Picasso");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setIcon(new ImageIcon(HomeCliente.class.getResource("/resources/cocheAzul.png")));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_2, BorderLayout.SOUTH);

		lblLogOut = new JLabel("");
		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrarSesion();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogOut.setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblLogOut.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
		});
		lblLogOut.setIcon(new ImageIcon(HomeCliente.class.getResource("/resources/logout.png")));
		panel_2.add(lblLogOut);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);

		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_4.add(panel_5, BorderLayout.NORTH);

		lblUsuario = new JLabel("Bienvenido ");
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(lblUsuario);

		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setVgap(50);
		flowLayout_2.setAlignOnBaseline(true);
		flowLayout_2.setHgap(100);
		panel_6.setBackground(new Color(255, 255, 255));
		panel_4.add(panel_6, BorderLayout.CENTER);

		lblCita = new JLabel("Pedir Cita Previa");
		lblCita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				abrirCita();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblCita.setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblCita.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
		});
		lblCita.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCita.setIconTextGap(10);
		lblCita.setHorizontalAlignment(SwingConstants.CENTER);
		lblCita.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblCita.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCita.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCita.setIcon(new ImageIcon(HomeCliente.class.getResource("/resources/calendario.png")));
		panel_6.add(lblCita);

		lblReparaciones = new JLabel("Ver mis reparaciones");
		lblReparaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				verReparaciones();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblReparaciones.setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblReparaciones.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
		});
		lblReparaciones.setVerticalAlignment(SwingConstants.BOTTOM);
		lblReparaciones.setHorizontalTextPosition(SwingConstants.CENTER);
		lblReparaciones.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblReparaciones.setIcon(new ImageIcon(HomeCliente.class.getResource("/resources/reparaciones.png")));
		lblReparaciones.setIconTextGap(15);
		panel_6.add(lblReparaciones);
	}

	protected void verReparaciones() {
		PanelMisReparaciones panel = new PanelMisReparaciones(userLogado);
		panel.setVisible(true);

	}

	protected void abrirCita() {
		PanelCita cita = new PanelCita(userLogado);
		cita.setVisible(true);

	}

	private void cerrarSesion() {
		dispose();
		VentanaLogin ventana = new VentanaLogin();
		ventana.setVisible(true);
	}

}

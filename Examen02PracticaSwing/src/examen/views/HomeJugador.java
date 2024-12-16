package examen.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import examen.mainApp.Launcher;
import models.Equipo;
import models.Usuario;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLayeredPane;

public class HomeJugador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCerrar;
	private JLabel lblEquipo;
	private JLabel lblHome;
	private JLayeredPane panelCentral;
	private Usuario usuariologado;
	/**
	 * Create the frame.
	 * 
	 * @param us1
	 */
	public HomeJugador(Usuario us1) {
		this.usuariologado = us1;
		inicializarComponentes();
		CargarPanelInicial(us1);

	}

	private void CargarPanelInicial(Usuario us1) {
		List<Equipo> equipoJugador = ObtieneEquipoJugador(us1);
		if (equipoJugador == null || equipoJugador.isEmpty()) {
		    PanelSinEquipo pan1 = new PanelSinEquipo();
		    panelCentral.add(pan1);
		    panelCentral.revalidate();
		    panelCentral.repaint();
		} else {
		    panelCentral.removeAll();
		    PanelMiEquipo pan1 = new PanelMiEquipo(equipoJugador);
		    panelCentral.add(pan1);
		    panelCentral.revalidate();
		    panelCentral.repaint();
		}

	}

	public List<Equipo> ObtieneEquipoJugador(Usuario user) {
		List<Equipo> lstEquipoUsuario = new ArrayList<Equipo>();
		for (Equipo eq : Launcher.lstEquipos) {
			if (user.getEsEntrenador() && eq.getEntrenador().equals(user)) {
				lstEquipoUsuario.add(eq);
			}
			else {
				if(eq.getLstJugadores().contains(user)) {
					lstEquipoUsuario.add(eq);
				}
			}
			;
		}
		return lstEquipoUsuario;
	}

	private void inicializarComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelSup = new JPanel();
		panelSup.setBackground(new Color(30, 144, 255));
		contentPane.add(panelSup, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HomeJugador.class.getResource("/utils/Logo.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelSup.add(lblNewLabel);

		JPanel panelIzq = new JPanel();
		panelIzq.setBackground(new Color(30, 144, 255));
		contentPane.add(panelIzq, BorderLayout.WEST);
		panelIzq.setLayout(new GridLayout(3, 1, 0, 25));

		lblHome = new JLabel("Home");
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				handlerCursorEntrar(lblHome);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				cursorSalir(lblHome);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelCentral.removeAll();
				CargarPanelInicial(usuariologado);
			}
		});
		lblHome.setForeground(new Color(255, 255, 255));
		lblHome.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHome.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setIcon(new ImageIcon(HomeJugador.class.getResource("/utils/Home.png")));
		panelIzq.add(lblHome);

		lblEquipo = new JLabel("Equipo");
		lblEquipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				handlerCursorEntrar(lblEquipo);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				cursorSalir(lblEquipo);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				panelCentral.removeAll();
				PanelEquipos pan = new PanelEquipos(usuariologado);
				panelCentral.add(pan);
				panelCentral.revalidate();
				panelCentral.repaint();

			}
		});
		lblEquipo.setForeground(new Color(255, 255, 255));
		lblEquipo.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblEquipo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo.setIcon(new ImageIcon(HomeJugador.class.getResource("/utils/Equipo.png")));
		panelIzq.add(lblEquipo);

		lblCerrar = new JLabel("Cerrar Sesión");
		lblCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				handlerCursorEntrar(lblCerrar);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				cursorSalir(lblCerrar);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				VentanaLogin ven = new VentanaLogin();
				ven.setVisible(true);
			}
		});
		lblCerrar.setForeground(new Color(255, 255, 255));
		lblCerrar.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCerrar.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setIcon(new ImageIcon(HomeJugador.class.getResource("/utils/Logout.png")));
		panelIzq.add(lblCerrar);

		JPanel panelInf = new JPanel();
		panelInf.setBackground(new Color(30, 144, 255));
		contentPane.add(panelInf, BorderLayout.SOUTH);

		JPanel panelDer = new JPanel();
		contentPane.add(panelDer, BorderLayout.EAST);

		panelCentral = new JLayeredPane();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
	}

	protected void cursorSalir(Component lbl) {

		lbl.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	protected void handlerCursorEntrar(Component lbl) {
		lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));

	}

}
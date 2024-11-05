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

import uiux.models.Usuario;
import uiux.practicaExamen.VentanaLogin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelHomeCliente extends JFrame {

    private static final long serialVersionUID = 1L;
    Usuario usuarioConectado;
    private JLabel lblNombre;

    /**
     * Create the panel.
     */
    public PanelHomeCliente(String nombre, Usuario user) {
        initialize();
        setSize(new Dimension(600, 400));
        setResizable(false);
        usuarioConectado = user;
        lblNombre.setText(nombre);
    }

    /**
     * Metodo que inicializa los componentes de la ventana
     */
    private void initialize() {
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(135, 206, 235));
        getContentPane().add(panelTitulo, BorderLayout.NORTH);
        panelTitulo.setPreferredSize(new Dimension(200,150));
        JLabel lblTtitulo = new JLabel("  GYM Picasso");
        lblTtitulo.setForeground(new Color(100, 149, 237));
        lblTtitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTtitulo.setIcon(new ImageIcon(PanelHomeCliente.class.getResource("/resources/logoApp.png")));
        panelTitulo.add(lblTtitulo);

        JPanel panelOpciones = new JPanel();
        getContentPane().add(panelOpciones, BorderLayout.CENTER);

        JLabel imgSalida = new JLabel("");
        imgSalida.setIcon(new ImageIcon(PanelHomeCliente.class.getResource("/resources/cierreSesion.png")));
        imgSalida.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cerrarSesion();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                imgSalida.setBorder(new LineBorder(Color.WHITE, 2));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                imgSalida.setBorder(null);
            }
        });

        JLabel lblSalida = new JLabel("Cerrar Sesión");

        JLabel imgReserva = new JLabel("");
        imgReserva.setIcon(new ImageIcon(PanelHomeCliente.class.getResource("/resources/listarReservas.png")));
        imgReserva.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirReserva();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                imgReserva.setBorder(new LineBorder(Color.WHITE, 2));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                imgReserva.setBorder(null);
            }
        });

        JLabel lblReserva = new JLabel("Ver Reservas");

        GroupLayout gl_panelOpciones = new GroupLayout(panelOpciones);
        gl_panelOpciones.setHorizontalGroup(
            gl_panelOpciones.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_panelOpciones.createSequentialGroup()
                    .addContainerGap(184, Short.MAX_VALUE)
                    .addGroup(gl_panelOpciones.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblReserva)
                        .addComponent(imgReserva))
                    .addGap(96)
                    .addGroup(gl_panelOpciones.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblSalida)
                        .addComponent(imgSalida))
                    .addGap(175))
        );
        gl_panelOpciones.setVerticalGroup(
            gl_panelOpciones.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panelOpciones.createSequentialGroup()
                    .addGap(66)
                    .addGroup(gl_panelOpciones.createParallelGroup(Alignment.TRAILING)
                        .addComponent(imgSalida)
                        .addComponent(imgReserva))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(gl_panelOpciones.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblSalida)
                        .addComponent(lblReserva))
                    .addContainerGap(87, Short.MAX_VALUE))
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
    protected void abrirReserva() {
        PanelReservarClase rs = new PanelReservarClase(usuarioConectado, this, true);
        rs.setVisible(true);
    }

    public void cerrarSesion() {
        dispose();
        VentanaLogin ventana = new VentanaLogin();
        ventana.setVisible(true);
    }
}

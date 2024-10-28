package uiux.practicaExamen;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;

import uiux.practicaExamen.panels.PanelLoginInicial;
import java.awt.GridLayout;

public class VentanaLogin2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public VentanaLogin2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 902, 556);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        inicializarComponentes(); 
    }

    private void inicializarComponentes() {
        
        JPanel panelSuperior_1 = new JPanel();
        panelSuperior_1.setBackground(new Color(175, 238, 238));
        contentPane.add(panelSuperior_1, BorderLayout.NORTH);
        panelSuperior_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel lblLogo_1 = new JLabel("         GYM Picasso");
        lblLogo_1.setIcon(new ImageIcon(VentanaLogin2.class.getResource("/resources/logoApp.png")));
        lblLogo_1.setForeground(Color.CYAN);
        lblLogo_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        panelSuperior_1.add(lblLogo_1);
        
        JPanel panelCentral = new JPanel();
        panelCentral.setBackground(Color.WHITE);
        contentPane.add(panelCentral, BorderLayout.CENTER);
        panelCentral.setLayout(new BorderLayout(0, 0));
        
        JLabel lblFotoLogin = new JLabel("");
        lblFotoLogin.setIcon(new ImageIcon(VentanaLogin2.class.getResource("/resources/imgLogin.png")));
        panelCentral.add(lblFotoLogin, BorderLayout.WEST);
        
        JPanel panelDerecha = new JPanel();
        panelDerecha.setPreferredSize(new Dimension(500, 300));
        panelCentral.add(panelDerecha, BorderLayout.EAST);
        panelDerecha.setLayout(new GridLayout(0, 1, 0, 0));
        
        JPanel panelTituloLogin = new JPanel();
        panelTituloLogin.setPreferredSize(new Dimension(120, 120));
        panelTituloLogin.setBackground(new Color(30, 144, 255));
        panelDerecha.add(panelTituloLogin);
        panelTituloLogin.setLayout(new GridLayout(1, 0, 0, 0));
        
        JLabel lblNewLabel_1 = new JLabel("Bienvenidos a la aplicación GYM Picasso");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setBackground(new Color(30, 144, 255));
        panelTituloLogin.add(lblNewLabel_1);
        
        JPanel panelLogin = new JPanel();
        panelDerecha.add(panelLogin);
        panelLogin.setLayout(new GridLayout(1, 0, 0, 0));
        
        PanelLoginInicial panelPrs = new PanelLoginInicial();
        panelLogin.add(panelPrs);
        
    }
}

package uiux.ejercicio03;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.GridLayout;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPopupMenu popupMenu;

    /**
     * Launch the application.
     */
    /**
     * Create the frame.
     */
    public VentanaPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);

        contentPane = new JPanel();
        contentPane.setBackground(Color.decode("#FF9505"));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[][][][][grow][grow][][][][][][]", "[][][][grow][][grow]"));

        JLabel lblLogo = new JLabel("\r\n");
        lblLogo.setIcon(
                new ImageIcon(VentanaPrincipal.class.getResource("/resources/imagen_2024-10-19_134002464 (1).png")));
        contentPane.add(lblLogo, "cell 0 0,alignx center,aligny center");

        JLabel lblMenu = new JLabel("");
        lblMenu.setIcon(
                new ImageIcon(VentanaPrincipal.class.getResource("/resources/imagen_2024-10-19_134528012.png")));
        contentPane.add(lblMenu, "cell 0 1");

        popupMenu = new JPopupMenu();
        addPopup(lblMenu, popupMenu);

        JMenu mnNewMenu_1 = new JMenu("Productos");
        popupMenu.add(mnNewMenu_1);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listar Productos");
        mnNewMenu_1.add(mntmNewMenuItem_3);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("Añadir Producto");
        mnNewMenu_1.add(mntmNewMenuItem_4);

        JMenuItem mntmNewMenuItem_5 = new JMenuItem("Eliminar Producto");
        mnNewMenu_1.add(mntmNewMenuItem_5);

        JMenu mnNewMenu = new JMenu("Clientes");
        popupMenu.add(mnNewMenu);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("Listar Clientes");
        mnNewMenu.add(mntmNewMenuItem_2);

        JMenuItem mntmNewMenuItem = new JMenuItem("Añadir Cliente");
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Eliminar Cliente");
        mnNewMenu.add(mntmNewMenuItem_1);

        // Añadir un nuevo panel con GridLayout
        JPanel panelNuevo = new JPanel();
        panelNuevo.setBackground(Color.decode("#FFF000"));
        contentPane.add(panelNuevo, "cell 1 0 8 6,grow");
        panelNuevo.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 169, 322, 168);
        panelNuevo.add(panel);
        panel.setLayout(null);

        lblMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                popupMenu.show(lblMenu, e.getX(), e.getY());
            }
        });

    }

    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }
}

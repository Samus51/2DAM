package uiux.ejercicio03;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;
import uiux.ejercicio03.panels.PanelAñadirCliente;
import uiux.ejercicio03.panels.PanelAñadirProducto;
import uiux.ejercicio03.panels.PanelClientes;
import uiux.ejercicio03.panels.PanelEliminarCliente;
import uiux.ejercicio03.panels.PanelEliminarProducto;
import uiux.ejercicio03.panels.PanelProductos;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPopupMenu popupMenu;
    private JTabbedPane tabbedPane;

    public VentanaPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 694, 497);

        contentPane = new JPanel();
        contentPane.setBackground(Color.decode("#FF9505"));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[30px][7px][596px]", "[35px][395px]"));

        // Crear el JTabbedPane
        tabbedPane = new JTabbedPane();
        tabbedPane.setSelectedIndex(-1);
        contentPane.add(tabbedPane, "cell 2 1,grow");

        JLabel lblLogo = new JLabel();
        lblLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/resources/imagen_2024-10-19_134002464 (1).png")));
        contentPane.add(lblLogo, "cell 0 0 3 1,alignx left,aligny top");

        JLabel lblMenu = new JLabel("");
        lblMenu.setVerticalAlignment(SwingConstants.TOP);
        lblMenu.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/resources/imagen_2024-10-19_134528012.png")));
        contentPane.add(lblMenu, "cell 0 1,growx,aligny top");

        popupMenu = new JPopupMenu();
        addPopup(lblMenu, popupMenu);

        JMenu mnNewMenu_1 = new JMenu("Productos");
        popupMenu.add(mnNewMenu_1);

        JMenuItem mntmListarProductos = new JMenuItem("Listar Productos");
        mnNewMenu_1.add(mntmListarProductos);
        mntmListarProductos.addActionListener(e -> mostrarPanel("Listar Productos", new PanelProductos()));

        JMenuItem mntmAnadirProducto = new JMenuItem("Añadir Producto");
        mnNewMenu_1.add(mntmAnadirProducto);
        mntmAnadirProducto.addActionListener(e -> mostrarPanel("Añadir Producto", new PanelAñadirProducto()));

        JMenuItem mntmEliminarProducto = new JMenuItem("Eliminar Producto");
        mnNewMenu_1.add(mntmEliminarProducto);
        mntmEliminarProducto.addActionListener(e -> mostrarPanel("Eliminar Producto", new PanelEliminarProducto()));

        JMenu mnNewMenu = new JMenu("Clientes");
        popupMenu.add(mnNewMenu);

        JMenuItem mntmListarClientes = new JMenuItem("Listar Clientes");
        mnNewMenu.add(mntmListarClientes);
        mntmListarClientes.addActionListener(e -> mostrarPanel("Listar Clientes", new PanelClientes()));

        JMenuItem mntmAnadirCliente = new JMenuItem("Añadir Cliente");
        mnNewMenu.add(mntmAnadirCliente);
        mntmAnadirCliente.addActionListener(e -> mostrarPanel("Añadir Cliente", new PanelAñadirCliente()));

        JMenuItem mntmEliminarCliente = new JMenuItem("Eliminar Cliente");
        mnNewMenu.add(mntmEliminarCliente);
        mntmEliminarCliente.addActionListener(e -> mostrarPanel("Eliminar Cliente", new PanelEliminarCliente()));

        lblMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                popupMenu.show(lblMenu, e.getX(), e.getY());
            }
        });
    }

    private void mostrarPanel(String title, JPanel panel) {
        tabbedPane.removeAll(); 
        tabbedPane.addTab(title, panel); 
        tabbedPane.setDisplayedMnemonicIndexAt(0, -1);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal frame = new VentanaPrincipal();
            frame.setVisible(true);
        });
    }
}

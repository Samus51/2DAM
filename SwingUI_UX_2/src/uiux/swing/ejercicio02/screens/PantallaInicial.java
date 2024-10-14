package uiux.swing.ejercicio02.screens;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Clase que representa la pantalla inicial de la aplicación de gestión de usuarios y productos.
 * Esta clase permite añadir y eliminar clientes, así como gestionar productos.
 */
public class PantallaInicial extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextArea clientesTextArea;
    private ArrayList<String> clientes = new ArrayList<>();
    private ArrayList<String> productos = new ArrayList<>();

    /**
     * Constructor de la clase PantallaInicial.
     * Inicializa la interfaz de usuario y configura los elementos del menú.
     */
    public PantallaInicial() {
        setTitle("Gestión de Usuarios y Productos");
        setIconImage(new ImageIcon(getClass().getResource("/resources/iconoui.jpg")).getImage());

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Menú Clientes
        JMenu clientesMenu = new JMenu("Clientes");
        JMenuItem altaClienteItem = new JMenuItem("Alta Cliente");
        JMenuItem bajaClienteItem = new JMenuItem("Baja Cliente");

        altaClienteItem.addActionListener(e -> new AltaCliente(this));
        bajaClienteItem.addActionListener(e -> new BajaCliente(this));

        clientesMenu.add(altaClienteItem);
        clientesMenu.add(bajaClienteItem);

        // Menú Productos
        JMenu productosMenu = new JMenu("Productos");
        JMenuItem altaProductoItem = new JMenuItem("Alta Producto");
        JMenuItem listarProductosItem = new JMenuItem("Listar Productos");

        altaProductoItem.addActionListener(e -> new AltaProducto(this));
        listarProductosItem.addActionListener(e -> new ListadoProductos(this));

        productosMenu.add(altaProductoItem);
        productosMenu.add(listarProductosItem);

        menuBar.add(clientesMenu);
        menuBar.add(productosMenu);

        setJMenuBar(menuBar);

        // Área de texto para mostrar clientes
        clientesTextArea = new JTextArea();
        clientesTextArea.setEditable(false);
        add(new JScrollPane(clientesTextArea), BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Agrega un cliente a la lista y actualiza el área de texto que muestra los clientes.
     *
     * @param cliente El nombre del cliente a agregar.
     */
    public void agregarCliente(String cliente) {
        clientes.add(cliente);
        actualizarClientesTextArea();
    }

    /**
     * Elimina un cliente de la lista y actualiza el área de texto que muestra los clientes.
     *
     * @param nombre El nombre del cliente a eliminar.
     */
    public void eliminarCliente(String nombre) {
        clientes.removeIf(cliente -> cliente.contains(nombre));
        actualizarClientesTextArea();
    }

    /**
     * Obtiene la lista de clientes.
     *
     * @return Una lista de clientes.
     */
    public ArrayList<String> getClientes() {
        return clientes;
    }

    /**
     * Actualiza el área de texto que muestra la lista de clientes.
     */
    private void actualizarClientesTextArea() {
        clientesTextArea.setText("");
        for (String cliente : clientes) {
            clientesTextArea.append(cliente + "\n");
        }
    }

    /**
     * Obtiene la lista de productos.
     *
     * @return Una lista de productos.
     */
    public ArrayList<String> getProductos() {
        return productos;
    }

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        PantallaInicial pantalla = new PantallaInicial();
        // Agregar productos de ejemplo
        for (int i = 1; i <= 50; i++) {
            pantalla.getProductos().add("Producto " + i + ", " + (i * 10.0) + "€, " + (i % 2 == 0 ? "Perecedero" : "No Perecedero"));
        }
    }
}

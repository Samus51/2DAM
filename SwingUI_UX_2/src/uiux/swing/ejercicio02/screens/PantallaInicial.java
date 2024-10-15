package uiux.swing.ejercicio02.screens;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import utils.Producto;

/**
 * Clase que representa la pantalla inicial de la aplicación de gestión de
 * usuarios y productos. Esta clase permite añadir y eliminar clientes, así como
 * gestionar productos.
 */
public class PantallaInicial extends JFrame {
    private static final long serialVersionUID = 1L;
    protected JTextArea clientesTextArea;
    public ArrayList<String> clientes = new ArrayList<>();
    private ArrayList<Producto> productos = new ArrayList<>();

    private static final String CLIENTES_FILE = "clientes.dat";
    private static final String PRODUCTOS_FILE = "productos.dat";

    /**
     * Constructor de la clase PantallaInicial. Inicializa la interfaz de usuario y
     * configura los elementos del menú.
     */
  
    
    public PantallaInicial() {
        // Colores elegidos
        Color fondoPrincipal = new Color(173, 216, 230); // Light Blue
        Color fondoTextArea = new Color(255, 255, 255); // Blanco
        Color textoColor = new Color(0, 0, 0); // Negro para el texto
        Color menuColor = new Color(70, 130, 180); // Steel Blue
        Color menuTextoColor = new Color(255, 255, 255); // Blanco para el texto del menú

        setForeground(textoColor);
        getContentPane().setBackground(fondoPrincipal);
        setTitle("Gestión de Usuarios y Productos");
        setIconImage(new ImageIcon(getClass().getResource("/resources/iconoui.jpg")).getImage());

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear barra de menú
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(menuColor);
        menuBar.setForeground(menuTextoColor);

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
        clientesTextArea.setForeground(textoColor);
        clientesTextArea.setBackground(fondoTextArea);
        clientesTextArea.setEditable(false);
        getContentPane().add(new JScrollPane(clientesTextArea), BorderLayout.CENTER);

        // Cargar clientes y productos desde los archivos
        cargarClientes();
        cargarProductos();

        setVisible(true);
    }

    // Métodos para manejar clientes
    public void agregarCliente(String clienteInfo) {
        if (clientes.stream().anyMatch(c -> c.equalsIgnoreCase(clienteInfo))) {
            JOptionPane.showMessageDialog(this, "El cliente ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        clientes.add(clienteInfo);
        actualizarClientesTextArea();
        guardarClientes();
    }

    public void eliminarCliente(String nombre) {
        clientes.removeIf(cliente -> cliente.contains(nombre));
        actualizarClientesTextArea();
        guardarClientes();
    }

    public ArrayList<String> getClientes() {
        return clientes;
    }

    private void actualizarClientesTextArea() {
        clientesTextArea.setText("");
        for (String cliente : clientes) {
            clientesTextArea.append(cliente + "\n");
        }
    }

    // Métodos para manejar productos
    public void agregarProducto(Producto producto) {
        if (productos.stream().anyMatch(p -> p.getNombre().equalsIgnoreCase(producto.getNombre()))) {
            JOptionPane.showMessageDialog(this, "El producto ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        productos.add(producto);
        guardarProductos();
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    private void cargarProductos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRODUCTOS_FILE))) {
            productos = (ArrayList<Producto>) ois.readObject();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "No se encontró el archivo de productos. No hay ningún producto.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (EOFException e) {
            // Este bloque se ejecuta si el archivo está vacío
            JOptionPane.showMessageDialog(this, "El archivo de productos está vacío. No hay ningún producto disponible.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Mostrar mensaje si la lista de productos está vacía
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningún producto disponible.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void cargarClientes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CLIENTES_FILE))) {
            clientes = (ArrayList<String>) ois.readObject();
            actualizarClientesTextArea();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "No se encontró el archivo de clientes. No hay ningún cliente.", "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (EOFException e) {
            // Este bloque se ejecuta si el archivo está vacío
            JOptionPane.showMessageDialog(this, "El archivo de clientes está vacío. No hay ningún cliente disponible.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Mostrar mensaje si la lista de clientes está vacía
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningún cliente disponible.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void guardarClientes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CLIENTES_FILE))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarProductos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PRODUCTOS_FILE))) {
            oos.writeObject(productos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

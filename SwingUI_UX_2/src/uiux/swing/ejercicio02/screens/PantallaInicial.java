package uiux.swing.ejercicio02.screens;

import javax.swing.*;
import java.awt.*;
<<<<<<< HEAD
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
	private ArrayList<Producto> productos = new ArrayList<>(); // Cambiado a ArrayList<Producto>

	private static final String CLIENTES_FILE = "clientes.dat"; // Archivo para guardar clientes
	private static final String PRODUCTOS_FILE = "productos.dat"; // Archivo para guardar productos

	/**
	 * Constructor de la clase PantallaInicial. Inicializa la interfaz de usuario y
	 * configura los elementos del menú.
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

		// Cargar clientes y productos desde los archivos
		cargarClientes();
		cargarProductos();

		setVisible(true);
	}

	// Métodos para manejar clientes
	public void agregarCliente(String clienteInfo) {
    // Comprobar si el cliente ya existe en la lista
    if (clientes.stream().anyMatch(c -> c.equalsIgnoreCase(clienteInfo))) {
        JOptionPane.showMessageDialog(this, "El cliente ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Agregar el nuevo cliente a la lista
    clientes.add(clienteInfo); // Agregar el cliente a la lista de clientes
    actualizarClientesTextArea(); // Actualizar el área de texto con la nueva lista
    guardarClientes(); // Guardar cambios al agregar un cliente
}

	public void eliminarCliente(String nombre) {
		clientes.removeIf(cliente -> cliente.contains(nombre));
		actualizarClientesTextArea();
		guardarClientes(); // Guardar cambios al eliminar un cliente
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
		guardarProductos(); // Guardar cambios al agregar un producto
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	private void cargarProductos() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRODUCTOS_FILE))) {
			productos = (ArrayList<Producto>) ois.readObject();
		} catch (FileNotFoundException e) {
			// Archivo no encontrado, no hay productos guardados
		} catch (IOException | ClassNotFoundException e) {
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

	private void cargarClientes() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CLIENTES_FILE))) {
			clientes = (ArrayList<String>) ois.readObject();
			actualizarClientesTextArea();
		} catch (FileNotFoundException e) {
			// Archivo no encontrado, no hay clientes guardados
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void guardarClientes() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CLIENTES_FILE))) {
			oos.writeObject(clientes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

=======
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
>>>>>>> d7bf18b3bf8bd8f10fbc24ebdf3e0e1e78507536
}

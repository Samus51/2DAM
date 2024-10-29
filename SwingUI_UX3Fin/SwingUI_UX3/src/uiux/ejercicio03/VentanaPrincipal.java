package uiux.ejercicio03;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import net.miginfocom.swing.MigLayout;
import uiuc.models.Cliente;
import uiuc.models.Producto;
import uiux.ejercicio03.panels.PanelAñadirCliente;
import uiux.ejercicio03.panels.PanelAñadirProducto;
import uiux.ejercicio03.panels.PanelClientes;
import uiux.ejercicio03.panels.PanelEliminarCliente;
import uiux.ejercicio03.panels.PanelEliminarProducto;
import uiux.ejercicio03.panels.PanelProductos;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout.Alignment;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPopupMenu popupMenu;
	private JTabbedPane tabbedPane;
	private static ArrayList<Cliente> listClientes = new ArrayList<>();
	private static ArrayList<Producto> listProducto = new ArrayList<>();

	public VentanaPrincipal() {
		cargarClientes();
		cargarProductos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 626);
		setMinimumSize(new Dimension(600, 400)); // Ajusta según sea necesario

		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#FF9505"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(new MigLayout("", "[30px,grow 0][28px,grow][559px,grow][20px,grow 0]",
				"[35px][30px,grow][393px,grow]"));

		// Crear el JTabbedPane
		tabbedPane = new JTabbedPane();
		tabbedPane.setSelectedIndex(-1);
		contentPane.add(tabbedPane, "cell 1 1 3 2,grow");

		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(
				new ImageIcon(VentanaPrincipal.class.getResource("/resources/imagen_2024-10-19_134002464 (1).png")));
		contentPane.add(lblLogo, "cell 0 0 3 1,alignx left,aligny top");

		JLabel lblMenu = new JLabel("");
		lblMenu.setVerticalAlignment(SwingConstants.TOP);
		lblMenu.setIcon(
				new ImageIcon(VentanaPrincipal.class.getResource("/resources/imagen_2024-10-19_134528012.png")));

		lblMenu.setPreferredSize(new Dimension(30, 30));
		lblMenu.setMaximumSize(new Dimension(30, 30));
		contentPane.add(lblMenu, "cell 0 1,alignx left,aligny top");

		popupMenu = new JPopupMenu();
		addPopup(lblMenu, popupMenu);

		JMenu mnNewMenu_1 = new JMenu("Productos");
		popupMenu.add(mnNewMenu_1);

		JMenuItem mntmListarProductos = new JMenuItem("Listar Productos");
		mnNewMenu_1.add(mntmListarProductos);
		PanelProductos panelProductos = new PanelProductos();
		mntmListarProductos.addActionListener(e -> mostrarPanel("Listar Productos", panelProductos));
		panelProductos.setLayout(new MigLayout("", "[]", "[]"));

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

	private void cargarProductos() {
		File file = new File("Productos.txt");

		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("Archivo de Productos creado: " + file.getName());
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al crear el archivo: " + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		// Leer el archivo
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			boolean isEmpty = true;

			while ((line = reader.readLine()) != null) {
				Producto pro = parsearProducto(line);
				VentanaPrincipal.getListProductos().add(pro);
				isEmpty = false;
			}

			if (isEmpty) {
				JOptionPane.showMessageDialog(null, "El archivo de Productos está vacío.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			} else {
				System.out.println("Productos cargados con éxito.");
			}
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar los Productos: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void mostrarPanel(String title, JPanel panel) {
	    tabbedPane.removeAll();
	    tabbedPane.addTab(title, panel);
	    tabbedPane.revalidate();
	    tabbedPane.repaint();
	}

	public static void guardarClientes() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Clientes.txt"))) {
			for (Cliente cl : listClientes) {
				// Suponiendo que los atributos de Cliente son: nombre, apellidos, email,
				// provincia, fecha
				String linea = String.join(",", cl.getNombre(), cl.getApellidos(), cl.getEmail(), cl.getProvincia(),
						cl.getEdad());
				writer.write(linea);
				writer.newLine();
			}
			System.out.println("Clientes guardados con éxito.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void guardarProductos() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Productos.txt"))) {
			for (Producto pro : listProducto) {
				String linea = String.join(",", pro.getNombre(), String.valueOf(pro.getPrecioUnitario()),
						String.valueOf(pro.isEsPerecedero()));
				writer.write(linea);
				writer.newLine();
			}
			System.out.println("Productos guardados con éxito.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cargarClientes() {
		File file = new File("Clientes.txt");

		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("Archivo de clientes creado: " + file.getName());
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al crear el archivo: " + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		// Leer el archivo
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			boolean isEmpty = true;

			while ((line = reader.readLine()) != null) {
				Cliente cl = parsearCliente(line);
				VentanaPrincipal.getListClientes().add(cl);
				isEmpty = false;
			}

			if (isEmpty) {
				JOptionPane.showMessageDialog(null, "El archivo de clientes está vacío.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			} else {
				System.out.println("Clientes cargados con éxito.");
			}
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al cargar los clientes: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private Cliente parsearCliente(String line) {
		if (line == null || line.trim().isEmpty()) {
			throw new IllegalArgumentException("Linea nula");
		}

		String[] datos = line.split(",");

		// Verifica que hay suficientes datos
		if (datos.length < 5) {
			System.out.println("Línea inválida: " + line);
			throw new IllegalArgumentException("Datos incompletos");
		}

		// Crea un objeto Cliente solo si se tienen suficientes datos
		return new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4]);
	}

	public Producto parsearProducto(String linea) {
		if (linea == null || linea.trim().isEmpty()) {
			throw new IllegalArgumentException("Linea nula");
		}

		String[] datos = linea.split(",");

		// Verifica que hay suficientes datos
		if (datos.length < 3) {
			System.out.println("Línea inválida: " + linea);
			throw new IllegalArgumentException("Datos incompletos");
		}

		// Crea un objeto Cliente solo si se tienen suficientes datos
		return new Producto(datos[0], Double.parseDouble(datos[1]), Boolean.parseBoolean(datos[2]));
	}

	public static ArrayList<Cliente> getListClientes() {
		return listClientes;
	}

	public static ArrayList<Producto> getListProductos() {
		return listProducto;
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

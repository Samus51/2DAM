package uiux.swing.ejercicio02.screens;

import javax.swing.*;
import java.awt.*;
import utils.Producto;

/**
 * Clase que representa la ventana de alta de producto en la aplicación de gestión de productos.
 * Permite al usuario ingresar los datos de un nuevo producto y agregarlos a la lista de productos.
 */
public class AltaProducto extends JDialog {
    private static final long serialVersionUID = 1L;

    protected JTextField nombreField;
    protected JTextField precioField;
    private JComboBox<String> perecederoComboBox;
    private JButton agregarButton;

    /**
     * Constructor de la clase AltaProducto.
     * Crea y configura la interfaz gráfica para el alta de un producto.
     *
     * @param pantalla Referencia a la pantalla principal para poder agregar el producto a la lista.
     */
    public AltaProducto(PantallaInicial pantalla) {
        setTitle("Alta Producto");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));
        setIconImage(new ImageIcon(getClass().getResource("/resources/iconoui.jpg")).getImage());

        // Colores elegidos
        Color fondoDialogo = new Color(224, 255, 255); // Color suave para el fondo del diálogo
        Color textoColor = new Color(0, 0, 0); // Negro para el texto
        Color labelColor = new Color(0, 102, 204); // Azul oscuro para las etiquetas
        Color buttonColor = new Color(70, 130, 180); // Steel Blue para el botón

        // Configuración del fondo del diálogo
        getContentPane().setBackground(fondoDialogo);

        // Añadir etiquetas y campos
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setForeground(labelColor);
        add(nombreLabel);
        nombreField = new JTextField();
        add(nombreField);

        JLabel precioLabel = new JLabel("Precio:");
        precioLabel.setForeground(labelColor);
        add(precioLabel);
        precioField = new JTextField();
        add(precioField);

        JLabel perecederoLabel = new JLabel("¿Es Perecedero?");
        perecederoLabel.setForeground(labelColor);
        add(perecederoLabel);
        perecederoComboBox = new JComboBox<>(new String[] { "Sí", "No" });
        add(perecederoComboBox);

        agregarButton = new JButton("Agregar Producto");
        agregarButton.setBackground(buttonColor);
        agregarButton.setForeground(Color.WHITE); 
        agregarButton.addActionListener(e -> {
            String nombre = nombreField.getText().trim();
            String precioText = precioField.getText().trim();
            boolean perecedero = perecederoComboBox.getSelectedItem().equals("Sí");

            if (nombre.isEmpty() || precioText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            double precio;
            try {
                precio = Double.parseDouble(precioText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El precio debe ser un número válido.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Producto nuevoProducto = new Producto(nombre, precio, perecedero);

            if (pantalla.getProductos().stream().anyMatch(p -> p.getNombre().equalsIgnoreCase(nuevoProducto.getNombre()))) {
                JOptionPane.showMessageDialog(this, "No puede introducir un producto ya creado.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de que desea agregar el producto " + nuevoProducto.getNombre() + "?", "Confirmar Agregar",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                pantalla.agregarProducto(nuevoProducto);
                dispose();
            }
        });

        add(new JLabel()); 
        add(agregarButton);

        setModal(true); 
        setVisible(true);
    }
}

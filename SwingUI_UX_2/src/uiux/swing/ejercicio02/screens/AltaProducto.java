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

    /** Campo de texto para el nombre del producto */
    protected JTextField nombreField;

    /** Campo de texto para el precio del producto */
    protected JTextField precioField;

    /** ComboBox para seleccionar si el producto es perecedero o no */
    private JComboBox<String> perecederoComboBox;

    /** Botón para agregar el producto */
    private JButton agregarButton;

    /**
     * Constructor de la clase AltaProducto.
     * Crea y configura la interfaz gráfica para el alta de un producto.
     *
     * @param pantalla Referencia a la pantalla principal para poder agregar el producto a la lista
     */
    public AltaProducto(PantallaInicial pantalla) {
        setTitle("Alta Producto");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        add(nombreField);

        add(new JLabel("Precio:"));
        precioField = new JTextField();
        add(precioField);

        add(new JLabel("¿Es Perecedero?"));
        perecederoComboBox = new JComboBox<>(new String[] { "Sí", "No" });
        add(perecederoComboBox);

        agregarButton = new JButton("Agregar Producto");
        agregarButton.addActionListener(e -> {
            String nombre = nombreField.getText().trim();
            String precioText = precioField.getText().trim();
            boolean perecedero = perecederoComboBox.getSelectedItem().equals("Sí");

            // Validar campos vacíos
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

            // Crear un nuevo producto
            Producto nuevoProducto = new Producto(nombre, precio, perecedero);

            // Validar si el producto ya existe
            if (pantalla.getProductos().stream().anyMatch(p -> p.getNombre().equalsIgnoreCase(nuevoProducto.getNombre()))) {
                JOptionPane.showMessageDialog(this, "No puede introducir un producto ya creado.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Agregar producto
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

        setModal(true); // Hacer el diálogo modal
        setVisible(true);
    }
}
